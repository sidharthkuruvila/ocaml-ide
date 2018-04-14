package org.ocaml.sexp.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import static org.ocaml.sexp.lexer.SexpTypes.*;
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
%class _SexpLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType

EOL= \n|\r|\r\n
WHITE_SPACE_CHAR=[\ \t\f]|{EOL}
WHITE_SPACE={WHITE_SPACE_CHAR}+
NEWLINE=("\r"* "\n")

%state IN_SEXP
%state IN_SEXP_COMMENT
%state IN_BLOCK_COMMENT
%state IN_STRING

%%

<YYINITIAL> {
 [^] { yybegin(IN_SEXP); yypushback(1); }
}

<IN_SEXP> {
    {WHITE_SPACE} { return WHITE_SPACE; }
    "(" { return LPAREN; }
    ")" { return RPAREN; }
    "\"" { yybegin(IN_STRING); tokenStart(); }
    "#|" { yybegin(IN_BLOCK_COMMENT); commentDepth = 1; tokenStart(); }
    ";" [^\r\n]* { return COMMENT; }
    "#;" {WHITE_SPACE} "(" { yybegin(IN_SEXP_COMMENT); commentDepth = 1; tokenStart(); }
    (("#" [^|;()\ \t\f\n\r]) | [^()\ \t\f\n\r])+ "#"* { return ATOM; }
}


<IN_STRING> {
       "\"" { yybegin(IN_SEXP); tokenEnd(); return ATOM; }
       "\\" { NEWLINE } ([ \t] *) { }
       "\\" [\\\'\"ntbr ] { }
       "\\" [0-9] [0-9] [0-9] { }
       "\\" "o" [0-3] [0-7] [0-7] { }
       "\\" "x" [0-9a-fA-F] [0-9a-fA-F] { }
       "\\" . { }
       { NEWLINE } { }
       . { }
       <<EOF>> { yybegin(IN_SEXP); tokenEnd(); return ATOM; }

}

<IN_BLOCK_COMMENT> {
    "#|" { commentDepth += 1; }
    "|#" { commentDepth -= 1; if(commentDepth == 0) { yybegin(IN_SEXP); tokenEnd(); return COMMENT; } }
    . | { NEWLINE } { }
    <<EOF>> { yybegin(IN_SEXP); tokenEnd(); return COMMENT; }
}


<IN_SEXP_COMMENT> {
    "(" { commentDepth += 1; }
    ")" { commentDepth -= 1; if(commentDepth == 0) { yybegin(IN_SEXP); tokenEnd(); return COMMENT; } }
    . | { NEWLINE } { }
    <<EOF>> { yybegin(IN_SEXP); tokenEnd(); return COMMENT; }
}