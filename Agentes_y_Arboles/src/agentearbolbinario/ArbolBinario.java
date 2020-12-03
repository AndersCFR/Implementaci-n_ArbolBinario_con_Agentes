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
public class ArbolBinario implements Serializable{
    


    class Nodo implements Serializable
      {
        int valor;
        Nodo izquierdo, derecho;
      }
      
    Nodo raiz;
    ArrayList <Integer> recorridoPreorden = new ArrayList();
    ArrayList <Integer> recorridoInorden = new ArrayList();
    ArrayList <Integer> recorridoPostorden = new ArrayList();

      public ArbolBinario() {
          raiz=null;
      }
      
      public void insertar (int numero_ingresado)
      {
          Nodo nuevo;
          nuevo = new Nodo ();
          nuevo.valor = numero_ingresado;
          nuevo.izquierdo = null;
          nuevo.derecho = null;
          if (raiz == null)
              raiz = nuevo;
          else
          {
              Nodo anterior = null, padre;
             padre = raiz;
              while (padre != null)
              {
                  anterior = padre;
                  if (numero_ingresado < padre.valor)
                      padre = padre.izquierdo;
                  else
                      padre = padre.derecho;
              }
              if (numero_ingresado < anterior.valor)
                  anterior.izquierdo = nuevo;
              else
                  anterior.derecho = nuevo;
          }
      }


      private void preOrden (Nodo nodo)
      {
          if (nodo != null)
          {
              recorridoPreorden.add(nodo.valor);
              preOrden (nodo.izquierdo);
              preOrden (nodo.derecho);
          }
      }

      public void preOrden ()
      {
          preOrden (raiz);
      }

      private void inOrden (Nodo nodo)
      {
          if (nodo != null)
          {    
              inOrden (nodo.izquierdo);
              recorridoInorden.add(nodo.valor);
              inOrden (nodo.derecho);
          }
      }

      public void inOrden ()
      {
          inOrden (raiz);
      }


      private void postOrden (Nodo nodo)
      {
          if (nodo != null)
          {
              postOrden (nodo.izquierdo);
              postOrden (nodo.derecho);
              recorridoPostorden.add(nodo.valor);
          }
      }

      public void postOrden ()
      {
          postOrden(raiz);
      }

    public ArrayList<Integer> getRecorridoPreorden() {
        return recorridoPreorden;
    }

    public ArrayList<Integer> getRecorridoInorden() {
        return recorridoInorden;
    }

    public ArrayList<Integer> getRecorridoPostorden() {
        return recorridoPostorden;
    }
      
}
