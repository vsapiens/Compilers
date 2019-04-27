%{
#include "scheme.tab.h"
%}

NUMBER -?[1-9][0-9]*
STRING [0-9a-z(\ )]*
SYMBOL [a-z]*
BOOL \#[ft]
END \$

%%

{BOOL} /*ER que define si es booleano y su valor. Tiene que empezar con # y terminar con f o t*/{printf("(BOOL: %s)\n", yytext); return(BOO);};

{NUMBER} /*ER que define numero que acepta negativos y positivos enteros que sean mayores a 0*/ {printf("(NUM: %s)\n",yytext); return(NUM);};

{SYMBOL} /*ER que define un símbolo de cualquier minúscula desde la a hasta la z*/ {printf("(SIM: %s)\n",yytext); return (SIM);};

\“{STRING}\” /*ER que define un string que acepta espacios en blanco, dígitos del 0-9 y cualquier símbolo*/{printf("(STRING: %s)\n",yytext); return (STR);};

{END} /*ER que define si se recibe el s[imbolo final $*/{printf("(END)\n"); return (END);};

\( /* Instrucción que identifica el comienzo de un paréntisis circular*/ {printf("(LEFT CIRCLE PAR: %s)\n",yytext); return (LCP);};
\)  /* Instrucción que identifica la terminación de un paréntisis circular*/{printf("(RIGHT CIRCLE PAR: %s)\n",yytext); return (RCP);};
\[  /* Instrucción que identifica el comienzo de un paréntisis cuadrado*/{printf("(LEFT SQUARE PAR: %s)\n",yytext); return (LSP);};
\]  /* Instrucción que identifica la terminación de un paréntisis cuadrado*/{printf("(RIGHT SQUARE PAR: %s)\n",yytext); return (RSP);};

(\ )+ /*Si se recibe un espacio no hacer nada*/;
[\n]  /*Si se recibe un salto de línea no hacer nada*/;
. /*Cualquier otro token diferente a la gramática definida no es aceptada*/ {printf("<<ERROR LEXICO>>\n");return 1;};
<<EOF>>  /*En caso de que se lea un archivo y se llegue al final del mismo*/{return 0;};
%%