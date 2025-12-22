package Trabajo_Clase;

import java.util.Scanner;

import Trabajo_Clase.MiniLexer.TipoToken;
import Trabajo_Clase.MiniLexer.Token;

public class Main {
	
    // Lee codigo del usuario, lo convierte en tokens y lo analiza
    public static void main(String[] args) {
    	
    	// Lee la entrada del usuario
    	Scanner scanner = new Scanner(System.in);
    	String ejemplo;
    	System.out.println("Inserta tu codigo: ");
        ejemplo = scanner.nextLine();
        scanner.close();
        
        // Divide el codigo por espacios y crea un array de tokens
        String[] separacion = ejemplo.split(" ");
        Token[] tokens = new Token[separacion.length];
        int index = 0;

        // Para cada palabra, identifica su tipo y crea un token
        for (String lexema : separacion) {

            lexema = lexema.trim();
            if (lexema.isEmpty()) {
            	continue;
            }

            TipoToken tipo = MiniLexer.clasificarToken(lexema);
            Token t = new Token(tipo, lexema);

            tokens[index] = t;
            index++;

            System.out.println(t);
        }
        // Analiza los tokens
        MiniParser parser = new MiniParser(tokens);
        parser.parseStmtList();
        System.out.println("El programa ha funcionado a la perfeccion");
    } 
}