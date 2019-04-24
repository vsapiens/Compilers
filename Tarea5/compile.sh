bison -d scheme.y
flex scheme.l
gcc -c scheme.tab.c
gcc -c lex.yy.c
gcc -o scheme lex.yy.o scheme.tab.o -lfl
echo "DONE!"