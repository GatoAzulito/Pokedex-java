/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HOME
 */
public class Mainpruebas {
    public static void main(String[] args) {
    
    Pokemon pikachu   = new Pokemon("Pikachu", 25, Tipo.ELECTRICO);
    Pokemon charizard = new Pokemon("Charizard", 6, Tipo.FUEGO, Tipo.VOLADOR);
    
    List<Pokemon> equipo = new ArrayList<>();
        equipo.add(pikachu);
        equipo.add(charizard);
        
    Map<Integer, Pokemon> pokemap = new HashMap<>();
    for (Pokemon p : equipo) {
            pokemap.put(p.getNum(), p);
        }    
    buscar(pokemap, 25);
    buscar(pokemap, 1);
    }//
    
    public static void buscar(Map<Integer, Pokemon> mapa, int numero) {
        if (mapa.containsKey(numero)) {
            mapa.get(numero).info();
        } else {
        Utilidades.error("No existe el Pokemon numero " + numero);
    }
    }
}
