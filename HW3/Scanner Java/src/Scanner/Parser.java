package Scanner;

import java.util.List;

import Scanner.Token.Type;

public class Parser {
	public Parser() {
		
	}
	/**
	 * parseS
	 * @param tokens
	 */
	public void parseS(List<Token>tokens) {
		match(tokens,new Token(Type.OPERATOR,"+-/*"));
		parseExpr(tokens);
		parseExpr(tokens);
		System.out.println("This input is a well formed expression");
	}
	/**
	 * parseExpr
	 * @param tokens
	 */
	private void parseExpr(List<Token>tokens) {
		switch(tokens.get(0).getValue()) {
			case "":
				break;
			case "var":
				break;
			case "num":
				break;
			
		}
	}
	private void match(List<Token> tokens, Token token) {
		
		
	}
	
}
