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
public class AgenteRecorridos extends Agent {
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
            System.out.println("AgRecorridos= recibí de: " +acl.getSender());
            try{
                ArbolBinario arbol = (ArbolBinario)acl.getContentObject();
                
                arbol.inOrden();
                ArrayList <Integer> inOrden = arbol.getRecorridoInorden();
                arbol.preOrden();
                ArrayList <Integer> preOrden = arbol.getRecorridoPreorden();
                arbol.postOrden();
                ArrayList <Integer> postOrden = arbol.getRecorridoPostorden();
                
                ArrayList <ArrayList> recorridos = new ArrayList();
                recorridos.add(inOrden);
                recorridos.add(preOrden);
                recorridos.add(postOrden);

                new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "AgInformador",getAgent(),recorridos,"COD001");
                System.out.println("AgRecorridos= Se han creado y enviado los recorridos al agente informador");
               
            }
            catch(Exception error){
                System.out.println("error: "+error);
            }
            

        }
    }
    
}
