import org.jetbrains.grammarkit.tasks.*
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

val ideaVersion: String by project

plugins {
    java
    id ("org.jetbrains.intellij") version "0.4.21"
    id ("org.jetbrains.grammarkit") version "2021.1.3"
    id ("org.jetbrains.kotlin.jvm") version "1.6.10"
}

apply(plugin = "org.jetbrains.grammarkit")
apply(plugin = "idea")
apply(plugin = "org.jetbrains.intellij")
apply(plugin = "java")
apply(plugin = "kotlin")


tasks.named("compileJava", JavaCompile::class).configure {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

intellij {
    version = ideaVersion
    pluginName = "ocaml-idea"
    intellij.updateSinceUntilBuild = false
}


group = "kuruvila"
version = "0.0.1-SNAPSHOT"

sourceSets {
    main {
        java {
            srcDirs("gen")
        }
    }
}

val gen = configurations.create("gen")
repositories {
    mavenCentral()
}

dependencies {
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("junit:junit:4.12")
    testCompile("org.jetbrains.kotlin:kotlin-stdlib-jdk7")
    gen("de.jflex:jflex:1.6.0")
    gen(files("lib/gk/grammar-kit-patched.jar"))
}

tasks.register("generateOcamlLexer", GenerateLexer::class) {
    source = "parser/OcamlLexer.flex"
    targetDir = "gen/org/ocaml/lang/lexer/"
    targetClass = "_OcamlLexer"
    purgeOldFiles = true
}

tasks.register("generateSexpLexer", GenerateLexer::class) {
    source = "parser/sexp/SexpLexer.flex"
    targetDir = "gen/org/ocaml/sexp/lexer/"
    targetClass = "_SexpLexer"
    purgeOldFiles = true
}


tasks.register("generateOcamlPsiAndParser", GenerateParser::class) {
    source = "parser/ocaml.bnf"
    targetRoot = "gen"
    pathToParser = "/org/ocaml/lang/parser/OcamlParser.java"
    pathToPsiRoot = "/org/ocaml/lang/parser/psi"
    purgeOldFiles = true
}

tasks.register("generateSexpPsiAndParser", GenerateParser::class) {
    source = "parser/sexp/sexp.bnf"
    targetRoot = "gen"
    pathToParser = "org/ocaml/sexp/parser/SexpParser.java"
    pathToPsiRoot = "/org/ocaml/sexp/parser/psi"
    purgeOldFiles = true
}

tasks.register("generateJbuildPsiAndParser", GenerateParser::class) {
    source = "parser/jbuild/jbuild.bnf"
    targetRoot = "gen"
    pathToParser = "/org/ocaml/jbuild/parser/SexpParser.java"
    pathToPsiRoot = "/org/ocaml/jbuild/parser/psi"
    purgeOldFiles = true
}

tasks.named("compileKotlin").configure{
    dependsOn(tasks.named("generateOcamlLexer"))
    dependsOn(tasks.named("generateOcamlPsiAndParser"))

    dependsOn(tasks.named("generateSexpLexer"))
    dependsOn(tasks.named("generateSexpPsiAndParser"))

    dependsOn(tasks.named("generateJbuildPsiAndParser"))
}

tasks.named("test", Test::class).configure {
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
    }
}
