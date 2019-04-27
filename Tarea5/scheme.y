%{
/*
Carlos Estrada A01039919
Erick González A01039859
Moisés Fernández A01197049
*/
#include <stdio.h>
%}
/*Tokens proveidos por el flex*/
%token SIM NUM BOO STR END LCP RCP LSP RSP
/*
LCP - Left Circle Parenthesis
RCP - Right Circle Parenthesis
LSP - Left Square Parenthesis
RSP - Right Square Parenthesis
*/

%%
prog: program ;
program: 
    exp program {printf("Parser: [PRG]\n"); /*recusion por la derecha*/} 
    | END       {printf("Parser: [PRG]\n"); /*token final*/};
exp: 
    atomo       {printf("Parser: [EXP]\n"); /*expresion*/}
    | lista     {printf("Parser: [EXP]\n"); /*expresion*/};
atomo: 
    SIM         {printf("Parser: [ATM]\n");}
    | const     {printf("Parser: [ATM]\n");};
const: 
    NUM         {printf("Parser: [CST]\n"); /*Datos primitivos*/}
    | BOO       {printf("Parser: [CST]\n"); /*Datos primitivos*/}
    | STR       {printf("Parser: [CST]\n"); /*Datos primitivos*/};
lista: 
    LCP elem RCP    {printf("Parser: [LST]\n"); /*Definicion de parentesis balanceados*/}
    | LSP elem RSP  {printf("Parser: [LST]\n"); /*Definicion de parentesis balanceados*/};
elem: 
    exp elem        {printf("Parser: [ELM]\n"); /*Posibilidad de agregar mas expresiones*/}
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