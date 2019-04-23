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
    printf("<<SYNTAX ERROR>>");
    return 0;
}

int main() {
    if (yyparse()==0)
        printf("Palabra correcta!\n");
    else
        printf("Palabra incorrecta...\n");
}