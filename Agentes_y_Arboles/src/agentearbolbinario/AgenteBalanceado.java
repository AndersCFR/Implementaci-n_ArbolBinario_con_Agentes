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
/**
 *
 * @author Anderson
 */
public class AgenteBalanceado extends Agent{
    
    @Override
    protected void setup() {
        super.setup();
        System.out.println("Mi nombre es:" + getName()+"y me acabo de crear");
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "Agente2", getAgent(), 
            "Hola Agente, soy " + getAgent().getName(),"COD001");
            ACLMessage acl = blockingReceive();
            System.out.println("ciclo terminado, recibí de: " +acl.getSender()+"este mensaje"+acl.getContent());
            doDelete();

        }
    }
    
}
