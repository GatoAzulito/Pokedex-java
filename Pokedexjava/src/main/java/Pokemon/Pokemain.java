/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HOME
 */
public class Pokemain {
    public static void main(String[] args) {
        Pokemon pikachu   = new Pokemon("Pikachu", 25, Tipo.ELECTRICO);
        Pokemon charizard = new Pokemon("Charizard", 6, Tipo.FUEGO, Tipo.VOLADOR);

        charizard.info("nombre"); //Devuelve  lo que pide como argumento
        charizard.info("numero");
        charizard.info("tipos");
        charizard.info(); //Este devuelve "ficha"
        
        //Una lista de Pokedex llamada equipo, que es ArrayList, y está vacía
        List<Pokemon> equipo = new ArrayList<>();
        equipo.add(pikachu);
        equipo.add(charizard);
        Utilidades.imprimir(equipo.size()); //Imprime 2
        
        equipo.get(0).info(); //Imprime ficha del primer add()
        
        //Para cada Pokedex llamada p en equipo, ejecuta: ... 
        for (Pokemon p : equipo) {
            p.info();
        }
        
        
        Map<Integer, Pokemon> pokemap = new HashMap<>(); //ES INTEGER NO INTERGERRRRRR AAAAAAAA
        pokemap.put(25, pikachu); //clave 25, valor "pikachu"
        pokemap.put(6, charizard);
        System.out.println(pokemap.size()); //Imprime 2
        pokemap.get(6).info(); //.info sobre el 6
        //Hay una forma segura de guardar valores con getOrDefault(clave, nombreobjeto);
        pokemap.containsKey(1); //False,verifica si clave 1 existen en pokemap
        pokemap.containsValue(pikachu); //True, verifica si pikachu existen en pokemap
        pokemap.isEmpty(); //Si está vacío
        
        for (Pokemon p : pokemap.values()) {
            p.info();
            p.info("nombre");
        }
        
        //.put(25, charizard) Reemplaza lo que ya habia en 25 y devuelve el valor anterior
        //.putIfAbsent(26, Raichu) Reemplaza solo si está vacío
        //remove(26) Borra 26 y Raichu y devuelve un valor
        //clear() Vacía TODO el map
    }
}

