Ocaml IDE
=========

[![Build Status](https://travis-ci.org/sidharthkuruvila/ocaml-ide.svg?branch=master)](https://travis-ci.org/sidharthkuruvila/ocaml-ide)

An Ocaml language plugin for IntelliJ IDEA. It uses merlin for most of it's heavy lifting.

### Features

 * Syntax highlighting.
 * Autocompletion.
 * Got to declaration of value.

The merlin based features require a .merlin file to work.

Install the plugin
------------------

### Install merlin

    opam switch 4.04.0
    opam install merlin

### Generate the parser and lexer code

	./gradlew generateOcamlLexer
	./gradlew generateOcamlPsiAndParser
	
### Run the plugin from gradle

    ./gradlew runIdea