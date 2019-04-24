%{
#include <stdio.h>
%}

%token SIM NUM BOO STR END LCP RCP LSP RSP

%%
prog: program ;
program: 
    exp program {printf("Parser: [PRG]\n");}
    | END       {printf("Parser: [PRG]\n");};
exp: 
    atomo       {printf("Parser: [EXP]\n");}
    | lista     {printf("Parser: [EXP]\n");};
atomo: 
    SIM         {printf("Parser: [ATM]\n");}
    | const     {printf("Parser: [ATM]\n");};
const: 
    NUM         {printf("Parser: [CST]\n");}
    | BOO       {printf("Parser: [CST]\n");}
    | STR       {printf("Parser: [CST]\n");};
lista: 
    LCP elem RCP    {printf("Parser: [LST]\n");}
    | LSP elem RSP  {printf("Parser: [LST]\n");};
elem: 
    exp elem        {printf("Parser: [ELM]\n");}
    |               {printf("Parser: [ELM]\n");};
%%

int yyerror(char *s) {
    printf("<<ERROR SINTACTICO>>\n");
    return 0;
}

int main() {
    if (yyparse() == 0) {
        printf("<<PROGRAMA CORRECTO>>\n");
    }
}