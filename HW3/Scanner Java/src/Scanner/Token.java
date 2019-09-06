package Scanner;

public class Token {

    public enum Type {
    	  VARIABLE,
          NUMBER,
          OPENING_PARENTHESIS,
          CLOSING_PARENTHESIS,
          OPERATOR
    }   
    
    private final Type type;
    private final String value;
        
    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }
    
    public Type getType() {
        return type;
    }
    
    public String getValue() {
        return value;
    }
    
    public boolean equalsToken(Token token) {
        if (token.value.length() > 0) {
            return (type == token.type && value.equalsIgnoreCase(token.value)); 
        } else {
            return (type == token.type);
        }
    }
    
    public String toString() {
        StringBuilder string;
        string = new StringBuilder();
        string.append("<").append(type).append(", ").append(value).append(">");
        return string.toString();
    }
    
}
