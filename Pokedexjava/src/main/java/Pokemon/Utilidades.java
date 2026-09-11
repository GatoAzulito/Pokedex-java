/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokemon;

/**
 *
 * @author HOME
 */
public class Utilidades {
    private Utilidades() {} //para que nadie haga new Utilidades()
    
    public static void imprimir(Object mensaje) { //Con object para que acepte cualquier tipo
        System.out.println(mensaje);
    }
    
    public static void error(Object mensaje) {
        System.out.println("[ERROR] " + mensaje);
        
    }
}
