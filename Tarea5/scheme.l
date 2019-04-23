%{
#include "scheme.tab.h"
%}
NUM -?[1-9][0-9]*
STR [0-9a-z(\ )]*
SIM [a-z]*
BOO \#[ft]

%%

{BOO} {printf("(BOOL)\t");return BOO;};
{NUM} {printf("(NUM: %s)\t",yytext);return NUM;};
{SIM} {printf("(SIM: %s)\t",yytext);return SIM;};
\“{STR}\” {printf("(STRING: %s)\t",yytext);return STR;};

(\ )+ ;
[\n]  ;
. {printf("<<ERROR LEXICO>>\n");return 1;};
<<EOF>> {return 0;};
%%

int main()
{
    yylex();
    return 0;
}