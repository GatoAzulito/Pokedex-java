/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokemon;
/**
 *
 * @author HOME
 */
public class Pokemon {
    //VARIABLES
    private String nombre = "";
    private int num = 0;
    private Tipo tipo; //
    private Tipo tipo2;

    public Pokemon(String nombre, int num, Tipo tipo) { //Un solo tipo
        this.nombre = nombre;
        this.num = num;
        this.tipo = tipo;
    }
    public Pokemon(String nombre, int num, Tipo tipo, Tipo tipo2) { //Dos tipos
        this.nombre = nombre;
        this.num = num;
        this.tipo = tipo;
        this.tipo2 = tipo2;
    }
   
    public void info() {
        info("ficha");
    }

    public int getNum() {
        return num;
    }
    
    public void info(String input) {
        String texto = switch (input) {
            case "ficha" -> {
                String tipo1 = this.nombre + "/" + this.num + "/" + this.tipo;
                if (this.tipo2 != null) {
                 tipo1 = tipo1 + "|" + this.tipo2;
                }
                yield tipo1;
            }
            case "nombre" -> "Nombre: " + this.nombre;
            case "numero" -> "Número: " + this.num;
            case "tipos" -> {
                String tipo1 = this.tipo.toString();
                if (this.tipo2 != null) {
                 tipo1 = tipo1 + "|" + this.tipo2;
                }
                yield "Tipos: " + tipo1; //Yield para return dentro de switches
            }
            default -> "Opción no válida";
        };
        Utilidades.imprimir(texto);
    }
}
