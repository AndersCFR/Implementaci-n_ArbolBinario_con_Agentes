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
/**
 *
 * @author Anderson
 */
public class AgenteInformador extends Agent{
    @Override
    protected void setup() {
        super.setup();
        System.out.println("Mi nombre es:" + getName()+"y me acabo de crear");
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            ACLMessage acl = blockingReceive();
            System.out.println("AgInformador= recibí de: " +acl.getSender());
            try{
                ArrayList <ArrayList> todos_recorridos = (ArrayList)acl.getContentObject();
                ArrayList <Integer> recorrido1 = todos_recorridos.get(0);
                ArrayList <Integer> recorrido2 = todos_recorridos.get(1);
                ArrayList <Integer> recorrido3 = todos_recorridos.get(2);
                
                System.out.println("AgInformador= El recorrido inOrder para el árbol es: ");
                for(int i=0; i<recorrido1.size(); i++){
                    System.out.print(recorrido1.get(i)+" ");
                }
                System.out.println("\nAgInformador= El recorrido preOrden para el árbol binario es:");
                for(int i=0; i<recorrido2.size(); i++){
                    System.out.print(recorrido2.get(i)+" ");
                }
                System.out.println("\nAgInformador= El recorrido postOrden para el árbol binario es:");
                for(int i=0; i<recorrido3.size(); i++){
                    System.out.print(recorrido3.get(i)+" ");
                }
                System.out.println("\n-- Terminado --");
        
                
            }catch(Exception error){
                System.out.println("Error: "+error);
            }
            doDelete();

        }
    }
    
    @Override
    protected void takeDown(){
        System.out.println("Soy agente informador y voy a morir");
    }
}
