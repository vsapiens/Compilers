%{
#include "scheme.tab.h"
%}

NUMBER -?[1-9][0-9]*
STRING [0-9a-z(\ )]*
SYMBOL [a-z]*
BOOL \#[ft]
END \$

%%

{BOOL} {printf("(BOOL: %s)\n", yytext); return(BOO);};
{NUMBER} {printf("(NUM: %s)\n",yytext); return(NUM);};
{SYMBOL} {printf("(SIM: %s)\n",yytext); return (SIM);};
\“{STRING}\” {printf("(STRING: %s)\n",yytext); return (STR);};
{END} {printf("(END)\n"); return (END);};

\(  {printf("(LEFT CIRCLE PAR: %s)\n",yytext); return (LCP);};
\)  {printf("(RIGHT CIRCLE PAR: %s)\n",yytext); return (RCP);};
\[  {printf("(LEFT SQUARE PAR: %s)\n",yytext); return (LSP);};
\]  {printf("(RIGHT SQUARE PAR: %s)\n",yytext); return (RSP);};

(\ )+ ;
[\n]  ;
. {printf("<<ERROR LEXICO>>\n");return 1;};
<<EOF>> {return 0;};
%%