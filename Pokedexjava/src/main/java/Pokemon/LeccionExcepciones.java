/*
 * Leccion de excepciones: try / catch / finally / throw
 * En Java NO existe "except", se dice "catch".
 * Ejecuta este archivo y lee la salida junto con los comentarios.
 */
package Pokemon;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HOME
 */
public class LeccionExcepciones {

    public static void main(String[] args) {
        Map<Integer, Pokemon> pokemap = new HashMap<>();
        pokemap.put(25, new Pokemon("Pikachu", 25, Tipo.ELECTRICO));
        pokemap.put(6, new Pokemon("Charizard", 6, Tipo.FUEGO, Tipo.VOLADOR));

        paso1TryCatch();
        paso2Finally();
        paso3VariosCatch(pokemap);
        paso4Throw(pokemap);

        //Si llegamos aqui, ninguna excepcion mato el programa
        Utilidades.imprimir("\nFin de la leccion. El programa sigue vivo.");
    }

    //PASO 1: estructura basica
    //El codigo que puede fallar va en el try.
    //Si falla, Java salta al catch y el programa NO se cae.
    public static void paso1TryCatch() {
        Utilidades.imprimir("\n--- PASO 1: try / catch ---");
        String entrada = "veinticinco"; //Imagina que lo escribio el usuario

        try {
            int numero = Integer.parseInt(entrada); //Aqui revienta: no es un numero
            Utilidades.imprimir("Esta linea nunca se imprime: " + numero);
        } catch (NumberFormatException e) { //e es el objeto con la info del fallo
            Utilidades.error("Eso no es un numero -> " + e.getMessage());
        }
    }

    //PASO 2: finally
    //finally se ejecuta SIEMPRE, falle o no el try.
    public static void paso2Finally() {
        Utilidades.imprimir("\n--- PASO 2: finally ---");
        String[] entradas = {"6", "abc"}; //Uno bueno y uno malo

        for (String entrada : entradas) {
            try {
                int numero = Integer.parseInt(entrada);
                Utilidades.imprimir("Leido el numero " + numero);
            } catch (NumberFormatException e) {
                Utilidades.error("'" + entrada + "' no es valido");
            } finally {
                Utilidades.imprimir("(finally) Termine de procesar '" + entrada + "'");
            }
        }
    }

    //PASO 3: varios catch
    //Cada catch atrapa un tipo concreto de error. Java usa el primero que encaje.
    public static void paso3VariosCatch(Map<Integer, Pokemon> pokemap) {
        Utilidades.imprimir("\n--- PASO 3: varios catch ---");
        String[] entradas = {"25", "hola", "1"};

        for (String entrada : entradas) {
            try {
                int numero = Integer.parseInt(entrada);  //Puede fallar: NumberFormatException
                pokemap.get(numero).info();              //Puede fallar: NullPointerException
            } catch (NumberFormatException e) {
                Utilidades.error("'" + entrada + "' no es un numero");
            } catch (NullPointerException e) {
                //OJO: esto es solo para verlo. En codigo real usa containsKey con un if,
                //como hiciste en Mainpruebas.buscar(). Si un if lo evita, no uses catch.
                Utilidades.error("No hay ningun Pokemon con el numero " + entrada);
            }
        }
    }

    //PASO 4: throw
    //Aqui somos NOSOTROS quienes lanzamos la excepcion a proposito.
    public static void paso4Throw(Map<Integer, Pokemon> pokemap) {
        Utilidades.imprimir("\n--- PASO 4: throw ---");

        try {
            obtener(pokemap, 6).info();  //Existe: funciona
            obtener(pokemap, 999).info(); //No existe: obtener() lanza la excepcion
            Utilidades.imprimir("Esta linea nunca se imprime");
        } catch (IllegalArgumentException e) {
            Utilidades.error(e.getMessage()); //El mensaje lo escribimos nosotros abajo
        }
    }

    //Este metodo no devuelve null nunca: o devuelve un Pokemon, o lanza una excepcion.
    public static Pokemon obtener(Map<Integer, Pokemon> mapa, int numero) {
        if (!mapa.containsKey(numero)) {
            throw new IllegalArgumentException("El numero " + numero + " no esta en la Pokedex");
        }
        return mapa.get(numero);
    }

    //EJERCICIO PARA TI:
    //1. En Pokemon.info(String), cambia el default -> "Opcion no valida"
    //   por: default -> throw new IllegalArgumentException("Opcion no valida: " + input);
    //2. Aqui, en un paso5, llama a charizard.info("peso") dentro de un try
    //   y atrapa la excepcion con un catch que use Utilidades.error().
}
