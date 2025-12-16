package Trabajo_Clase;

import Trabajo_Clase.MiniLexer.TipoToken;
import Trabajo_Clase.MiniLexer.Token;

public class MiniParser {
	
	Token[] tokens;
	int actual;
	
	public MiniParser(Token[] tokens) {
		
		this.tokens = tokens;
		this.actual = 0;
		
	}
	
	public void match(TipoToken tipoEsperado){
		
	}

}