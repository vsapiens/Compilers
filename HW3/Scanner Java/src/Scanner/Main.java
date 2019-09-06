package Scanner;

import Scanner.Scanner;
import java.util.List;
import Scanner.Token;

/*
  Main Class
  Here we init the Scanner, String and Parser
  
  	Moisés Fernández							A01197049
	Carlos Estrada 								A01039919
	Luis Alvarez 								A01194173
	Erick González								A01039859
	
	Test cases:
	
	->Normal cases
	
	1. ( + 3 4 )
	2. ( - (* 2 $var4 ) (+ 2 3 ) )
	3. ( / ( / 2 ( + 2 $ter ) ) 6 )
	4. ( + ( + 2 ( $var1 $var2) ) ( + 4 ( + 4 5 )) )
	5. ( / ( * 2 ( 7 8 ) ) ( + 4 ( + $erw 5 ) ) )
	6. ( -           ( * 2 5 ) (+ 2 3 ))
	
	->Anormal cases
	
	1. ( - ( * 2 $4var4 ) (+ $1 3 )
	2.  ( / ( / 2 3 4 ) 6 )
	3. ( + 4 6 ) )
	4. ( -           ( * 2 5 ) (+ 2 3 )
	5. ( . (* 2 5 ) (+ 2 $var2 ) )

*/
public class Main {

    public static void main(String[] args) {
    	//Declaration of variables
        String string;
        Scanner scanner;
        Parser parser;
        //Init the objects
        parser = new Parser();
        scanner = new Scanner();
        //Init the token list
        List<Token> tokens;  
        //String declaration
        string = "(+ (- 2 89) (+ $erw 90))";
        
        System.out.println(string);
        //Get the tokens from the scanner
        try {
        	tokens = scanner.scan(string);
        } catch (Exception e) {
        	System.out.println(e.toString());
        	return;
        }
        
        //Display tokens
        for (Token token : tokens) {
            System.out.println(token);
        }
        
        //Parse the tokens
        try {
        	parser.parseS(tokens);
        } catch (Exception e) {
        	System.out.println(e.toString());
        	return;
        }
        
    }

}
