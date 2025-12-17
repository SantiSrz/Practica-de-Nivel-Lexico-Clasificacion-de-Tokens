package Trabajo_Clase;

import Trabajo_Clase.MiniLexer.Token;

public class MiniParser {
	
	Token[] tokens;
	int actual;
	
	public MiniParser(Token[] tokens, int actual) {
		
		this.tokens = tokens;
		this.actual = actual;
		
	}
	
	public void match(Token[] tokens, int actual){
		
	}

}