/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentearbolbinario;
import com.sun.istack.internal.logging.Logger;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import sun.util.logging.PlatformLogger;
/**
 *
 * @author Anderson
 */
public class Contenedor {
    
    AgentController controladorAgente;
    AgentContainer contenedorPrincipal;
    Object[] contenedor = new Object[1];
    
    public void accionarContenedor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance(); //ejecutar en segundo plano el proceso

        runtime.setCloseVM(true); //cerrando máquina virtual de java
        System.out.println("Runtime ha sido creado\n");

        Profile profile = new ProfileImpl(null, 1099, null); //recibe la ip, puerto, identificador perfil
        System.out.println("Perfil por defecto creado");
       
        contenedorPrincipal = runtime.createMainContainer(profile);
        System.out.println("Contenedor creado" + profile.toString());
        contenedor[0] = this;
        iniciarAgentes();
    }
    
    private void iniciarAgentes(){
        try{
            contenedorPrincipal.createNewAgent("AgInformador", AgenteInformador.class.getName(), contenedor).start();
            contenedorPrincipal.createNewAgent("AgRecorridos", AgenteRecorridos.class.getName(), contenedor).start();
            contenedorPrincipal.createNewAgent("AgArbol", AgenteArbol.class.getName(), contenedor).start();
            contenedorPrincipal.createNewAgent("AgControlador", AgenteControlador.class.getName(), contenedor).start();
            contenedorPrincipal.createNewAgent("AgRecolector", AgenteRecolector.class.getName(), contenedor).start();
        }
        catch(StaleProxyException error){
            error.printStackTrace();
        }
    }
    
}
