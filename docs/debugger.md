Debugging
=========
![Debugger blocks](images/debugger-blocks.png)


Working with ocamldebug
-----------------------

Send  SIGINT(*ctrl-c*) to the ocamldebug instance to stop a running program

### Setting up ocamldebug to run remotely 

 * Start ocamldebug with command to run
 
        $ ocamdebug -emacs -s <socket> <command file>
        (odb) set loadingmode manual
        (ocd) run
  
 * Start process to debug
 
        $ export CAML_DEBUG_SOCKET=<socket> 
        $ <command file> <params>
        