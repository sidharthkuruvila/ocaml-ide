package org.ocaml.merlin

class OpamCommand {
    private fun makeCommandString(vararg parameters: String): String {
        val userHome = System.getProperty("user.home")
        val cmd = """
            . $userHome/.opam/opam-init/init.zsh > /dev/null 2> /dev/null || true
            ${ parameters.joinToString(" ") }
            """
        return cmd
    }

    fun processBuilder(vararg  parameters: String): ProcessBuilder {
        val cmd = makeCommandString(*parameters)
        return ProcessBuilder("bash", "-c", cmd)
    }
}