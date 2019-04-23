%{

%}
NUM -?[1-9][0-9]*
STR [a-zA-Z(\ )]*
%%
#f {printf("(BOOL: False)\n");}
#t {printf("(BOOL: True)\n");}


{NUM} {printf("(NUM: %s)\n",yytext);}
(\ )+ ;
[\n]  {printf("New Line\n");}
. {printf("<<ERROR LEXICO>>\n");return 1;}

\"{STR}\" {printf("(STRING: %s)\n",yytext);}
%%

int main()
{
    yylex();
    return 0;
}