import re
f = file("/Users/sidharthkuruvila/Code/ocaml_idea_plugin/ocaml/parsing/parser.mly")
s = f.read()

file_parts = s.split("%%")

r = re.compile("^;$", re.MULTILINE)

parser_part = file_parts[1]

rule_parts = r.split(parser_part)

brace_contents_re = re.compile(r"[{][^}]*[}]")
rule_name_re = re.compile(r"^(\w+):$", re.MULTILINE)


res = rule_name_re.sub(r"\1 ::=", brace_contents_re.sub("", parser_part)).replace(";", "")



print res
