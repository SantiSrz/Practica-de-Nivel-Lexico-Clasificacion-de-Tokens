package Trabajo_Clase;

public class MiniLexer {

    // Define los tipos de tokens que existen
    public enum TipoToken {
        PALABRA_CLAVE,
        IDENTIFICADOR,
        LITERAL_NUMERICO,
        OPERADOR,
        DELIMITADOR
    }

    // Representa un token con su tipo y el texto original
    public static class Token {
        TipoToken tipo;
        String lexema;

        public Token(TipoToken tipo, String lexema) {
            this.tipo = tipo;
            this.lexema = lexema;
        }

        // Muestra el token en formato legible
        public String toString() {
            return "Token: <" + tipo + ", \"" + lexema + "\">";
        }
    }

    // Identifica a que tipo de token pertenece una palabra
    public static TipoToken clasificarToken(String lexema) {

        // Verifica si es una palabra reservada del lenguaje
        if (lexema.equals("int") || lexema.equals("if") || lexema.equals("for") || lexema.equals("var") || lexema.equals("String") || lexema.equals("double")|| lexema.equals("print")) {
            return TipoToken.PALABRA_CLAVE;
        }

        // Verifica si es un operador matematico o de asignacion
        if (lexema.equals("=") || lexema.equals("==") || lexema.equals("+") || lexema.equals("-") || lexema.equals("*") || lexema.equals("/") || lexema.equals("%")) {
            return TipoToken.OPERADOR;
        }

        // Verifica si es un delimitador
        if (lexema.equals(";") || lexema.equals("(") || lexema.equals(")") || lexema.equals(",")) {
            return TipoToken.DELIMITADOR;
        }

        // Verifica si es un numero
        if (lexema.matches("[0-9]+")) {
            return TipoToken.LITERAL_NUMERICO;
        }

        // Si no es nada de lo anterior, es un identificador (nombre de variable)
        return TipoToken.IDENTIFICADOR;
    }
    
}