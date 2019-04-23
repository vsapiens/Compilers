%{
#include "scheme.tab.h"
%}

NUMBER -?[1-9][0-9]*
STRING [0-9a-z(\ )]*
SYMBOL [a-z]*
BOOL \#[ft]

%%

{BOOL} {printf("(BOOL)\t"); return(BOO);};
{NUMBER} {printf("(NUM: %s)\t",yytext); return(NUM);};
{SYMBOL} {printf("(SIM: %s)\t",yytext); return (SIM);};
\“{STRING}\” {printf("(STRING: %s)\t",yytext); return (STR);};

(\ )+ ;
[\n]  ;
. {printf("<<ERROR LEXICO>>\n");return 1;};
<<EOF>> {return 0;};
%%