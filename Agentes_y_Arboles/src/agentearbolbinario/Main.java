/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentearbolbinario;
import java.util.*;
/**
 *
 * @author Anderson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Esta implementación de agentes nos permite que dado un conjunto de número
        generar un árbol binario y obtener sus diferentes recorridos
        
        Consideremos lo siguiente para la arquitectura:
        
        Un agente recolector tomará los números ingresados en la consola, los 
        colocará en un array y lo enviará por mensaje al agente controlador.
        EL agente conrolador verificará que lo ingresado en consola sean números
        y que no existan valores repetidos, si todo esta correcta envia un mensaje 
        al agente arbol con los numeros en un Objeto Lista Numeros, si algo está
        incorrecto enviará un mensaje String al recolector y morirán los agentes
        El agente arbol creará un árbol binario a partir del Objeto LIstaNumeros
        y lo enviará al agente recorridos.
        El agente recorridos generará los tres recorridos del árbol y los colocará
        en un ArrayList que lo enviará al informador.
        Finalmente el agente nformador descomprime y deserializa el ArrayList con los
        tres recorridos y los imprime en consola pra luego morir
        */
        Contenedor miContenedor = new Contenedor();
        miContenedor.accionarContenedor();
        
    }
    
}
