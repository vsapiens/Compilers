package Scanner;

import Scanner.Scanner;

import java.util.List;

import Scanner.Token;

public class Main {

    public static void main(String[] args) {

        String string;
        Scanner scanner;
        Parser parser;
        parser = new Parser();
        scanner = new Scanner();
        List<Token> tokens;        
        string = "(+ (- 2 89) ( $erw 90))";
        //string = "101b+11b";
        //string = "101b(+11b)";
        //string = ""; 
        System.out.println(string);
        
        try {
        	tokens = scanner.scan(string);
        } catch (Exception e) {
        	System.out.println(e.toString());
        	return;
        }
        
        
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
