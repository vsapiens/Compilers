%{
#include <stdio.h>
%}

%token SIM NUM BOO STR

%%
prog: prog exp | '$' ;
exp: atomo | lista ;
atomo: SIM | const ;
const: NUM | BOO | STR ;
lista: '(' elem ')' | '[' elem ']' ;
elem: exp elem | ;
%%

int yyerror(char *s) {
    printf("<<SYNTAX ERROR>>\n");
    return 0;
}

int main() {
    yyparse();
}