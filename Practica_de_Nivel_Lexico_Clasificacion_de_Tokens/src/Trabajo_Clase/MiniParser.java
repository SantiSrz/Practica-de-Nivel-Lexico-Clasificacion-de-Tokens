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
	
	public void match(TipoToken tipoEsperado) {
		if (this.actual < this.tokens.length) {
		Token t = this.tokens[this.actual];
		if (t.tipo == tipoEsperado) {
		this.actual++;
		}else {
		System.out.println("Error");
		System.exit(1);}
		}
	}
	
	public void parseStmtList() {
		while (this.actual < this.tokens.length) {
			parseStmt();
		}
	}
	
	public void parseStmt() {
		Token n = this.tokens[this.actual];
		if (n.lexema.equals("print")) {
			match(TipoToken.PALABRA_CLAVE);
			match(TipoToken.DELIMITADOR);
			parseExpr();
			match(TipoToken.DELIMITADOR);
			match(TipoToken.DELIMITADOR);
		}else if (n.tipo == TipoToken.IDENTIFICADOR){
			match(TipoToken.IDENTIFICADOR);
			match(TipoToken.OPERADOR);
			parseExpr();
			match(TipoToken.DELIMITADOR);
		}else {
			System.out.println("Se esperaba un " + "PRINT" + " de tipo " + TipoToken.PALABRA_CLAVE + " o un " + TipoToken.IDENTIFICADOR + ", no un " + n);
			System.exit(1);
		}
	}
	
	public void parseExpr() {
		parseTerm();
		if (this.actual >= this.tokens.length) {
			return;
		}
		while (this.tokens[this.actual].lexema.equals("+") || this.tokens[this.actual].lexema.equals("-")) {
				match(TipoToken.OPERADOR);
				parseTerm();
		}
		if (this.actual >= this.tokens.length) {
			return;
		}
	}
	
	public void parseTerm() {
		parseFactor();
		while (this.actual < this.tokens.length && this.tokens[this.actual].lexema.equals("*") || this.tokens[this.actual].lexema.equals("/")) {
			match(TipoToken.OPERADOR);
			parseFactor();
		}
	}
	
	public void parseFactor() {
		if (this.actual >= this.tokens.length) {
	        System.out.println("Error, se esperaba un " + TipoToken.IDENTIFICADOR + " un " + TipoToken.LITERAL_NUMERICO + " o un '(' ");
	        System.exit(1);
	    }
		Token g = this.tokens[this.actual];
		if (g.tipo == TipoToken.IDENTIFICADOR) {
			match(TipoToken.IDENTIFICADOR);
		}else if (g.tipo == TipoToken.LITERAL_NUMERICO) {
			match(TipoToken.LITERAL_NUMERICO);
		}else if(this.tokens[this.actual].lexema.equals("(")){
			match(TipoToken.DELIMITADOR);
			parseExpr();
			match(TipoToken.DELIMITADOR);
		}else {
			System.out.println("Error, se esperaba un " + TipoToken.IDENTIFICADOR + " un " + TipoToken.LITERAL_NUMERICO + " o un '(' ");
	        System.exit(1);
		}
	}
}