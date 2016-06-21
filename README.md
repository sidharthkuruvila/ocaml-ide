Installing the plugin
=====================

###Install the latest version of merlin from github

	git clone https://github.com/the-lambda-church/merlin.git
	cd merlin
	opam pin add .


###Generating the parser and lexer code
	./gradlew generateOcamlLexer
	./gradlew generateOcamlParser