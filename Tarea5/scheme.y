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

int main() {

    if (yyparse()==0)
        printf("Palabra correcta!\n");
    else
        printf("Palabra incorrecta...\n");
    return 0;
}