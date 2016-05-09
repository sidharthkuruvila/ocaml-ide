import re
s = """let newline = ('\\013'* '\\010')
let blank = [' ' '\\009' '\\012']
let lowercase = ['a'-'z' '_']
let uppercase = ['A'-'Z']
let identchar = ['A'-'Z' 'a'-'z' '_' '\\'' '0'-'9']
let lowercase_latin1 = ['a'-'z' '\\223'-'\\246' '\\248'-'\\255' '_']
let uppercase_latin1 = ['A'-'Z' '\\192'-'\\214' '\\216'-'\\222']
let identchar_latin1 = ['A'-'Z' 'a'-'z' '_' '\\192'-'\\214' '\\216'-'\\246' '\\248'-'\\255' '\\'' '0'-'9']
let symbolchar =  ['!' '$' '%' '&' '*' '+' '-' '.' '/' ':' '<' '=' '>' '?' '@' '^' '|' '~']
let decimal_literal = ['0'-'9'] ['0'-'9' '_']*
let hex_literal = '0' ['x' 'X'] ['0'-'9' 'A'-'F' 'a'-'f']['0'-'9' 'A'-'F' 'a'-'f' '_']*
let oct_literal = '0' ['o' 'O'] ['0'-'7'] ['0'-'7' '_']*
let bin_literal = '0' ['b' 'B'] ['0'-'1'] ['0'-'1' '_']*
let int_literal = decimal_literal | hex_literal | oct_literal | bin_literal
let float_literal = ['0'-'9'] ['0'-'9' '_']* ('.' ['0'-'9' '_']* )? (['e' 'E'] ['+' '-']? ['0'-'9'] ['0'-'9' '_']* )?
let hex_float_literal = '0' ['x' 'X'] ['0'-'9' 'A'-'F' 'a'-'f'] ['0'-'9' 'A'-'F' 'a'-'f' '_']* ('.' ['0'-'9' 'A'-'F' 'a'-'f' '_']* )? (['p' 'P'] ['+' '-']? ['0'-'9'] ['0'-'9' '_']* )?
let literal_modifier = ['G'-'Z' 'g'-'z']"""

l = s.split("\n")

#FIRST_VALUE_CHARACTER=[^ \n\r\f\\] | "\\"{CRLF} | "\\".
#let hex_literal = '0' ['x' 'X'] ['0'-'9' 'A'-'F' 'a'-'f']['0'-'9' 'A'-'F' 'a'-'f' '_']


def handle_char_class(s):
    r = re.compile(r"'([^']+)'|([^ ])")

    return "[" + "".join(max(a, b) for (a, b) in r.findall(s)) + "]"
def handle_char(s):
    return '"%s"' %s

def convert_re(mly_re):
    r = re.compile(r"\[(?P<char_class>[^]]+)\]|'(?P<char>[^']+)'|(?P<rest>.)")
    l = r.findall(mly_re)
    for (char_class, char, rest) in l:
        if len(char_class) > 0:
            yield handle_char_class(char_class)
        elif len(char) > 0:
            yield handle_char(char)
        else:
            yield rest



r = re.compile("let (\w+) = (.*)")
for e in l:
    m = r.match(e)
    print m.group(1).upper() + "=" + "".join(convert_re(m.group(2)))

