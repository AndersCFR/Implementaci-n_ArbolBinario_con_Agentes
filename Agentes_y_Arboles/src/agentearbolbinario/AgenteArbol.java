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
public class AgenteArbol extends Agent{
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
            try{
               
                ListaNumeros numeros = (ListaNumeros)acl.getContentObject();
                System.out.println("AgArbol= recibí de: " +acl.getSender());
                int[] valores = numeros.getNumeros();
                
                ArbolBinario arbol = new ArbolBinario();
                
                for(int m=0;m<valores.length;m++){
                    arbol.insertar(valores[m]);
                }
                
                new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "AgRecorridos", getAgent(),arbol,"COD001");
                System.out.println("AgArbol= Se creó y envió el árbol binario ");


            }
            catch(Exception e){
                System.out.println("erro: " + e);
            }
        }
    }
    
}
