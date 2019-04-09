%{

#include <stdio.h>

%}

%token NUMERO

%%

estatuto: expresion { printf("valor:%d\n", $1); }

expresion: expresion '+' expresion { $$ = $1 + $3; }

| NUMERO { $$ = $1; }

%%

main()

{

yyparse();

}

yyerror(s)

char *s;

{

fprintf(stderr, "%s\n",s);

}

yywrap()

{

return(1);

}

