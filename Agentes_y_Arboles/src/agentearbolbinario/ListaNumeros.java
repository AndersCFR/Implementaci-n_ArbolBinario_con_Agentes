/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentearbolbinario;
import java.util.*;
import java.io.*;

/**
 *
 * @author Anderson
 */
public class ListaNumeros implements Serializable {
    int[] numeros;
    public ListaNumeros(int[] numerosingresados){
       numeros = numerosingresados;
       
    }
    public void mostrarNumerosIngresados(){
        for(int i=0; i<numeros.length;i++){
            System.out.print(numeros[i]+"  ");
        }
        System.out.println("");
    }

    public int[] getNumeros() {
        return numeros;
    }
    
}
