package Scanner;

import Scanner.Token.Type;
import java.util.ArrayList;
import java.util.List;

public class Scanner {

    private boolean debugMode = true;
    private final int ERROR = 999;
    private final int[][] transitionMatrix;
    

    public Scanner() {
        transitionMatrix = new int[][]{
            /*State 0*/ {0, 1, ERROR, 5, 107,108, ERROR},
            /*State 1*/ {ERROR, ERROR, 2, ERROR, ERROR, ERROR, ERROR},
            /*State 2*/ {ERROR, ERROR, 3, 3, ERROR, ERROR, ERROR},
            /*State 3*/ {104, 104, ERROR, ERROR, 104, 104,104},
            /*State 5*/ {106, 106, 106, 5, 106, 106,106}
        };

    }

    public List<Token> scan(String string) {
        char c;
        int state, index;
        StringBuilder value;
        List<Token> tokens;
        state = 0;
        index = 0;
        tokens = new ArrayList();
        while (index < string.length()) {
            value = new StringBuilder();
            do {
                c = string.charAt(index);
                System.out.println(c);
                if (debugMode) {
                    System.out.println("State " + state + ", \'" + c + "\' => " + transitionMatrix[state][filter(c)]);
                }
                index++;
                state = transitionMatrix[state][filter(c)];
                if (state != 0) {
                    value.append(c);
                }
            } while (index < string.length() && state < 100);
            switch (state) {
	            //State for variable
            	case 5:
            		  tokens.add(new Token(Type.NUMBER, value.toString()));
            		break;
	            case 104:
	                tokens.add(new Token(Type.VARIABLE, value.toString()));
	                break;
	            //State for number
	            case 106:
	                tokens.add(new Token(Type.NUMBER, value.toString()));
	                break;
	            //State for parenthesis    
	            case 107:
	                tokens.add(new Token(Type.PARENTHESIS, value.toString()));
	                break;
	            //State for operator
	            case 108:
	            
	                tokens.add(new Token(Type.OPERATOR, value.toString()));
	                break;   
	            //State for error 
	            case ERROR:
	                value.append(c);
	                System.out.println("LEXICAL ERROR: the string \'" + value.toString() + "\' is not a valid element in the language.");
	                return tokens;
	            default:
	                return tokens;
            }            
            state = 0;
        }
        return tokens;
    }

    private int filter(char c)
    {
        switch (c)
        {
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        	return 3;
        case '$':
            return 1;
        case '+':
        case '-':
        case '*':
        case '/':	
            return 5;
       case '(':
       case ')':
            return 4;
        case ' ':
        case '\t':
            return 0;
        default:
            return 5;
            // Illegal character
        }
    }
    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

}
