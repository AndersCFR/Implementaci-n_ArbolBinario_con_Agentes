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
public class AgenteControlador extends Agent{
    
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
               System.out.println("AgControlador= recibí de: " +acl.getSender());
               ListaNumeros objaux = (ListaNumeros)acl.getContentObject();
               int[] auxlista = objaux.getNumeros();
               System.out.print("este array:  ");
               objaux.mostrarNumerosIngresados();
               
               boolean flagnumeros = false;
               boolean flagrepetidos = false;
               
               for(int i=0; i<auxlista.length; i++){
                   String tipo_dato =((Object)auxlista[i]).getClass().getSimpleName();
                   String integer = "Integer";
                   if(tipo_dato.equals(integer)==false){
                       flagnumeros = true;
                   }
                   
                   for(int j=i+1; j<auxlista.length; j++){
                       if(auxlista[i] == auxlista[j]){
                           flagrepetidos = true;
                       }
                   }
               }
               
               if(flagnumeros == true || flagrepetidos == true){
                    new EnviarMensaje().enviarMensajeString(ACLMessage.INFORM, "AgRecolector", getAgent(),
                            "NO se ingresaron numeros o hay numeros repetidos; NO se puede crear el árbol","COD006");
                    doDelete();
               }else{
                  new EnviarMensaje().enviarMensajeObject(ACLMessage.INFORM, "AgArbol", getAgent(),objaux,"COD001");
                  System.out.println("AgControlador= Los números ingresados son válidos, se enviaron al agente arbol");
               }
               
            }
            
            catch(Exception e){
                System.out.println("error: " + e);
            }
        }
    }
    
       @Override
    protected void takeDown(){
        System.out.println("Soy el agente controlador y voy a morir");
    }  

}
