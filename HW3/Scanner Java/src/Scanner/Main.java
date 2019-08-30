package Scanner;

import Scanner.Scanner;

import java.util.List;

import Scanner.Token;

public class Main {

    public static void main(String[] args) {

        String string;
        Scanner scanner;
        scanner = new Scanner();
        List<Token> tokens;        
        string = "1345+45";
        //string = "101b+11b";
        //string = "101b(+11b)";
        //string = ""; 
        System.out.println(string);
        tokens = scanner.scan(string);
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

}
