package Scanner;

import java.util.List;

import Scanner.Token.Type;

public class Parser {
	
	int tokenIndex;
	
	public Parser() {
		tokenIndex = 0;
	}
	/**
	 * parseS
	 * @param tokens
	 */
	public void parseS(List<Token>tokens) throws Exception {
		match(tokens, new Token(Type.OPENING_PARENTHESIS));
		match(tokens,new Token(Type.OPERATOR));
		parseExpr(tokens);
		parseExpr(tokens);
		match(tokens, new Token(Type.CLOSING_PARENTHESIS));
		System.out.println("This input is a well formed expression");
	}
	/**
	 * parseExpr
	 * @param tokens
	 */
	private void parseExpr(List<Token>tokens) throws Exception{
		switch(tokens.get(tokenIndex).getType()) {
			case NUMBER:
				match(tokens, new Token(Type.NUMBER));
				break;
			case VARIABLE:
				match(tokens, new Token(Type.VARIABLE));
				break;
			case OPENING_PARENTHESIS:
				match(tokens, new Token(Type.OPENING_PARENTHESIS));
				match(tokens,new Token(Type.OPERATOR));
				parseExpr(tokens);
				parseExpr(tokens);
				match(tokens, new Token(Type.CLOSING_PARENTHESIS));
				break;
			default:
				throw new Exception("La expresion es invalida");
			
		}
	}
	private void match(List<Token> tokens, Token token) throws Exception {
		if (tokenIndex >= tokens.size()) {
			throw new Exception("Index out of bounds");
		}
		if (tokens.get(tokenIndex).getType() != token.getType()) {
			throw new Exception("Error: " + tokens.get(tokenIndex).getType().toString() + " not valid");
		} else {
			tokenIndex++;
		}
	}
	
}
