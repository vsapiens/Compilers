%{
    int num_lines = 0, num_chars = 0, num_pal = 0;

%}
%%

\n ++num_lines;++num_pal;

(\ )+ ++num_pal;

. ++num_chars;

%%

main(){

yylex();

printf( "# de lineas = %d, # de cars = %d, # de pal = %d\n",

num_lines, num_chars, num_pal );

}