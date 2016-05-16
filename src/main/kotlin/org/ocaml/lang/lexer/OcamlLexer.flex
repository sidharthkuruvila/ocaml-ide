package org.ocaml.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import static org.ocaml.lang.lexer.OcamlTypes.*;
import static com.intellij.psi.TokenType.*;
%%

%{
  private int tokenStartIndex;
  private CharSequence quotedStringId;
  private int commentDepth;

  //Store the start index of a token
  private void tokenStart() {
    tokenStartIndex = zzStartRead;
  }

  //Set the start index of the token to the stored index
  private void tokenEnd() {
    zzStartRead = tokenStartIndex;
  }
%}

%public
%class _OcamlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
//%eof{  return;
//%eof}

EOL= \n|\r|\r\n
WHITE_SPACE_CHAR=[\ \t\f]|{EOL}
WHITE_SPACE={WHITE_SPACE_CHAR}+

NEWLINE=("\r"* "\n")
BLANK=[ \009\012]
LOWERCASE=[a-z_]
UPPERCASE=[A-Z]
IDENTCHAR=[A-Za-z_0-9']
LOWERCASE_LATIN1=[a-z\223-\246\248-\255_]
UPPERCASE_LATIN1=[A-Z\192-\214\216-\222]
IDENTCHAR_LATIN1=[A-Za-z_\192-\214\216-\246\248-\255\ 0-9']
SYMBOLCHAR= [!$%&*+-./:<=>?@\^|~]
DECIMAL_LITERAL=[0-9] [0-9_]*
HEX_LITERAL="0" [xX] [0-9A-Fa-f][0-9A-Fa-f_]*
OCT_LITERAL="0" [oO] [0-7] [0-7_]*
BIN_LITERAL="0" [bB] [0-1] [0-1_]*
INT_LITERAL= { DECIMAL_LITERAL } | { HEX_LITERAL } | { OCT_LITERAL } | { BIN_LITERAL }
FLOAT_LITERAL=[0-9] [0-9_]* ("." [0-9_]* )? ([eE] [+-]? [0-9] [0-9_]* )?
HEX_FLOAT_LITERAL="0" [xX] [0-9A-Fa-f] [0-9A-Fa-f_]* ("." [0-9A-Fa-f_]* )? ([pP] [+-]? [0-9] [0-9_]* )?
LITERAL_MODIFIER=[G-Zg-z]

FIRST_VALUE_CHARACTER=[^ \n\r\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\r\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\r\t\f\\] | "\\ "

%state WAITING_VALUE
%state INITIAL
%state IN_STRING
%state IN_QUOTED_STRING
%state IN_COMMENT

%%

<YYINITIAL>  {
      "#!" [\r\n]                     { yybegin(INITIAL); yypushback(1); return SHEBANG_LINE; }
      "#!" [^\[\r\n] [^\r\n]*         { yybegin(INITIAL); return SHEBANG_LINE; }
      [^]                             { yybegin(INITIAL); yypushback(1); }
}

<INITIAL> {
        {WHITE_SPACE} { return WHITE_SPACE; }

        "_" { return UNDERSCORE; }
        "~" { return TILDE; }
        "~" { LOWERCASE } { IDENTCHAR } * ":" { return LABEL_OP; }
        //"~" { LOWERCASE_LATIN1 } { IDENTCHAR_LATIN1 } * ":" { return LABEL; } Commenting this for now
        "?" { return QUESTION; }
        "?" {LOWERCASE} {IDENTCHAR} * ":" { return OPTLABEL; }
        //"?" { LOWERCASE_LATIN1 } {IDENTCHAR_LATIN1} * ":" { return OPTLABEL; }

        "and" { return AND;}
        "as" { return AS;}
        "assert" { return ASSERT;}
        "begin" { return BEGIN;}
        "class" { return CLASS;}
        "constraint" { return CONSTRAINT;}
        "do" { return DO;}
        "done" { return DONE;}
        "downto" { return DOWNTO;}
        "else" { return ELSE;}
        "end" { return END;}
        "exception" { return EXCEPTION;}
        "external" { return EXTERNAL;}
        "false" { return FALSE;}
        "for" { return FOR;}
        "fun" { return FUN;}
        "function" { return FUNCTION;}
        "functor" { return FUNCTOR;}
        "if" { return IF;}
        "in" { return IN;}
        "include" { return INCLUDE;}
        "inherit" { return INHERIT;}
        "initializer" { return INITIALIZER;}
        "lazy" { return LAZY;}
        "let" { return LET;}
        "match" { return MATCH;}
        "method" { return METHOD_KEYWORD;}
        "module" { return MODULE;}
        "mutable" { return MUTABLE;}
        "new" { return NEW;}
        "nonrec" { return NONREC;}
        "object" { return OBJECT;}
        "of" { return OF;}
        "open" { return OPEN;}
        "or" { return OR;}
    // "parser" { return PARSER;}
        "private" { return PRIVATE;}
        "rec" { return REC;}
        "sig" { return SIG;}
        "struct" { return STRUCT;}
        "then" { return THEN;}
        "to" { return TO;}
        "true" { return TRUE;}
        "try" { return TRY;}
        "type" { return TYPE;}
        "val" { return VAL;}
        "virtual" { return VIRTUAL;}
        "when" { return WHEN;}
        "while" { return WHILE;}
        "with" { return WITH;}

        "lor" { return INFIXOP3; }// Should be INFIXOP2
        "lxor" { return INFIXOP3; }// Should be INFIXOP2
        "mod" { return INFIXOP3; }
        "land" { return INFIXOP3; }
        "lsl" { return INFIXOP4; }
        "lsr" { return INFIXOP4; }
        "asr" { return INFIXOP4; }

        { LOWERCASE } { IDENTCHAR }  * { return LIDENT; }
        //{ LOWERCASE_LATIN1 } { IDENTCHAR_LATIN1 }  * { return LIDENT; }
        { UPPERCASE } { IDENTCHAR } * { return UIDENT; }
        //{ UPPERCASE_LATIN1 } { IDENTCHAR_LATIN1 } * { return UIDENT; }

        { INT_LITERAL } { LITERAL_MODIFIER } ? { return INT; }
        ( { FLOAT_LITERAL} | { HEX_FLOAT_LITERAL }  ) {LITERAL_MODIFIER} ? { return FLOAT; }
        ( { FLOAT_LITERAL} | { HEX_FLOAT_LITERAL }  | { INT_LITERAL } ) { IDENTCHAR } +  { return BAD_LITERAL; }


        "\"" { yybegin(IN_STRING); tokenStart(); }
        "{" { LOWERCASE } * "|" {
            yybegin(IN_QUOTED_STRING);
            CharSequence text = yytext();
            quotedStringId = text.subSequence(1, text.length() - 1);
            tokenStart();
        }


        "'" newline "'" { return CHAR; }
        "'" [^\\'\r\n] "'" { return CHAR; }
        "'\\" [\\'\"ntbr ] "'" { return CHAR; }
        "'\\" [0-9] [0-9] [0-9] "'" { return CHAR; }
        "'\\" "o" [0-3] [0-7] [0-7] "'" { return CHAR; }
        "'\\" "x" [0-9a-fA-F] [0-9a-fA-F] "'" { return CHAR; }
        "'\\" . "'" { return BAD_CHARACTER; }
        "(*" { yybegin(IN_COMMENT); commentDepth = 1; tokenStart(); }

        "#" [ \t]* [0-9]+ [ \t]* ("\"" [^\r\n\"]* "\"")? [^\r\n] * { NEWLINE } { }

        "#" { return SHARP; }
        "&" { return AMPERSAND; }
        "&&" { return AMPERAMPER; }
        "`" { return BACKQUOTE; }
        "'" { return QUOTE; }
        "(" { return LPAREN; }
        ")" { return RPAREN; }
        "*" { return STAR; }
        "," { return COMMA; }
        "->" { return MINUSGREATER; }
        "." { return DOT; }
        ".." { return DOTDOT; }
        ":" { return COLON; }
        "::" { return COLONCOLON; }
        ":=" { return COLONEQUAL; }
        ":>" { return COLONGREATER; }
        ";" { return SEMI; }
        ";;" { return SEMISEMI; }
        "<" { return LESS; }
        "<-" { return LESSMINUS; }
        "=" { return EQUAL; }
        "[" { return LBRACKET; }
        "[|" { return LBRACKETBAR; }
        "[<" { return LBRACKETLESS; }
        "[>" { return LBRACKETGREATER; }
        "]" { return RBRACKET; }
        "{" { return LBRACE; }
        "{<" { return LBRACELESS; }
        "|" { return BAR; }
        "||" { return BARBAR; }
        "|]" { return BARRBRACKET; }
        ">" { return GREATER; }
        ">]" { return GREATERRBRACKET; }
        "}" { return RBRACE; }
        ">}" { return GREATERRBRACE; }
        "[@" { return LBRACKETAT; }
        "[@@" { return LBRACKETATAT; }
        "[@@@" { return LBRACKETATATAT; }
        "[%" { return LBRACKETPERCENT; }
        "[%%" { return LBRACKETPERCENTPERCENT; }
        "!" { return BANG; }
        "!=" { return INFIXOP0; }
        "+" { return PLUS; }
        "+." { return PLUSDOT; }
        "+=" { return PLUSEQ; }
        "-" { return MINUS; }
        "-." { return MINUSDOT; }

        "!" { SYMBOLCHAR } + { return PREFIXOP; }
        [~?] { SYMBOLCHAR } + { return PREFIXOP; }
        [=<>|&$] { SYMBOLCHAR } * { return INFIXOP0; }
        [@\^] { SYMBOLCHAR } * { return INFIXOP1; }
        [+-] { SYMBOLCHAR } * { return INFIXOP2; }
        "**" { SYMBOLCHAR } * { return INFIXOP4; }
        "%"  { return PERCENT; }
        [*/%] { SYMBOLCHAR } * { return INFIXOP3; }
        "#" ({ SYMBOLCHAR } | "#") + { return SHARPOP; }

        //<<EOF>> { return EOF; }


}

<IN_STRING> {
       "\"" { yybegin(INITIAL); tokenEnd(); return STRING; }
       "\\" { NEWLINE } ([ \t] *) { }
       "\\" [\\\'\"ntbr ] { }
       "\\" [0-9] [0-9] [0-9] { }
       "\\" "o" [0-3] [0-7] [0-7] { }
       "\\" "x" [0-9a-fA-F] [0-9a-fA-F] { }
       "\\" . { }
       { NEWLINE } { }
       . { }
       <<EOF>> { yybegin(INITIAL); tokenEnd(); return STRING; }

}

<IN_QUOTED_STRING> {
    { NEWLINE }  { }
    <<EOF>> { yybegin(INITIAL); tokenEnd(); return STRING; } //Should probable create a special token here
    "|" { LOWERCASE  } * "}" {
        yybegin(INITIAL);
        CharSequence text = yytext();
        if(text.subSequence(1, text.length() - 1).equals(quotedStringId)) {
            tokenEnd(); return STRING;
        }
     }
     . { }

}


//TODO: This needs to be replaced with the definition in lexer.mll
<IN_COMMENT> {
    "(*" { commentDepth += 1; }
    "*)" { commentDepth -= 1; if(commentDepth == 0) { yybegin(INITIAL); tokenEnd(); return COMMENT; } }
    . | { NEWLINE } { }
    <<EOF>> { yybegin(INITIAL); tokenEnd(); return COMMENT; }
}



[^] { System.out.println("Bad char:" + yytext()); return BAD_CHARACTER; } //Copied this need to know how it works