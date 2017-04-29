Ocaml IDE
=========

[![Build Status](https://travis-ci.org/sidharthkuruvila/ocaml-ide.svg?branch=master)](https://travis-ci.org/sidharthkuruvila/ocaml-ide)

Installing the plugin
---------------------


### Generating the parser and lexer code

	./gradlew generateOcamlLexer
	./gradlew generateOcamlPsiAndParser
	
### Run the plugin from gradle

    ./gradlew runIdea