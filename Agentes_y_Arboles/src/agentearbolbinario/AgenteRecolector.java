/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentearbolbinario;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.*;
import java.io.*;
/**
 *
 * @author Anderson
 */
public class AgenteRecolector extends Agent{
     
    @Override
    protected void setup() {
        super.setup();
        System.out.println("Mi nombre es:" + getName()+"y me acabo de crear");
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            int num=0;
            System.out.println("Hola soy el agente recolector de números\n"
                    + "¿Cuántos número vas a ingresar para el arbol binario? \n");
            Scanner entrada = new Scanner(System.in);
            num = entrada.nextInt();
            
            int[] numeros = new int[num];
            
            for(int i=0; i<numeros.length; i++){
                int numeroIngresado=0;
                System.out.println("Ingresa el numero "+ (i+1) +" : \n");
                numeroIngresado = entrada.nextInt();
                numeros[i] = (numeroIngresado);
            }
            
            
            ListaNumeros lista = new ListaNumeros(numeros);
            
            try{
                
            System.out.println("AgRecolector= Enviando valores ingresados en consola al agente controlador");
            new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "AgControlador", getAgent(),lista,"COD001");
            //ACLMessage acl = blockingReceive();
            //System.out.println("ciclo terminado, recibí de: " +acl.getSender()+"este mensaje"+acl.getContent());doDelete();
            }
            catch(Exception error){
                System.out.println("El error fue:" + error);
            }
            
            ACLMessage acl = blockingReceive();
            System.out.println("Ciclo terminado, recibí de: " +acl.getSender()+
                "\neste mensaje:     "+acl.getContent());
        
           
            doDelete();
        }
    }
    
    @Override
    protected void takeDown(){
        System.out.println("Soy agente receptor y voy a morir");
    }  
}
