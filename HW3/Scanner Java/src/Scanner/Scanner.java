package Scanner;

import Scanner.Token.Type;
import java.util.ArrayList;
import java.util.List;

public class Scanner {

    private boolean debugMode = false;
    private final int ERROR = 999;
    private final int[][] transitionMatrix;
    

    public Scanner() {
        transitionMatrix = new int[][]{
            /*State 0*/ {0, 1, ERROR, 3, 4, 5, ERROR},
            /*State 1*/ {ERROR, ERROR, 2, ERROR, ERROR, ERROR, ERROR},
            /*State 2*/ {106, 106, 2, 2, 106, 106, 106},
            /*State 3*/ {107, 107, 107, 3, 107, 107, 107},
            /*State 4*/ {108, 108, 108, 108, 108, 108, 108},
            /*State 5*/ {109, 109, 109, 109, 109, 109, 109},
        };

    }

    public List<Token> scan(String string) {
        char c;
        int state, index;
        StringBuilder value;
        List<Token> tokens;
        state = 0;
        index = 0;
        int count = 50;
        boolean done = false;
        tokens = new ArrayList();
        while (index < string.length() && !done && count-- > 0) {
            value = new StringBuilder();
            done = false;
            do {
                c = string.charAt(index);
                System.out.println(c);
                if (debugMode) {
                    System.out.print("State " + state + ", \'" + c + "\' => " + transitionMatrix[state][filter(c)]);
                    System.out.println("  Index " + index);
                }
                index++;
                state = transitionMatrix[state][filter(c)];
                if (state != 0 && state < 100) {
                    value.append(c);
                    if (index == string.length()) {
                    	for (int i = 0; i < 7; i++) {
                    		if (transitionMatrix[state][i] > 100) {
                    			state = transitionMatrix[state][i];
                    			if (debugMode) {
                    				System.out.println("CHANGING STATE " + state);                    				
                    			}
                    			done = true;
                    			break;
                    		}
                    	}
                    }
                }
                if (state > 100) {
                	if (debugMode) {
                		System.out.println("At state " + state + " And index: " + index + " reducing index");                		
                	}
                	index--;
                }
            } while (index < string.length() && state < 100 && !done);
            switch (state) {

            	//State for variable
	            case 106:
	                tokens.add(new Token(Type.VARIABLE, value.toString()));
	                break;
	            //State for number
	            case 107:
	                tokens.add(new Token(Type.NUMBER, value.toString()));
	                break;
	            //State for parenthesis    
	            case 108:
	                tokens.add(new Token(Type.PARENTHESIS, value.toString()));
	                break;
	            //State for operator
	            case 109:
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
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            return 2;
        case '+':
        case '-':
        case '*':
        case '/':	
            return 5;
       case '(':
       case ')':
       case '[':
       case ']':
            return 4;
            
        case ' ':
        case '\t':
        case '\n':
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
