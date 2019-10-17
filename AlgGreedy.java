/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javafx.util.Pair;
import pr1meta.Utils;//NO SE PORQUE NO LA DETECTA

/**
 *
 * @author carol
 */
public class AlgGreedy {

    public AlgGreedy() {

    }

    /**
     * Introduce los datos del fichero dom.txt en la matrizDOM El rango de
     * frecuencia se introduce de 0 a numeroMAXRango
     *
     * @param ctr
     * @param dom
     * @param semilla
     * @param var
     * @return solucion
     */
    public ArrayList<Integer> greedy(ArrayList<ArrayList<Integer>> dom, ArrayList<ArrayList<Integer>> var, ArrayList<ArrayList<Integer>> ctr, Integer semilla) {
        Random rand = new Random(semilla);//añado la semilla para poder replicar el experimento
        ArrayList<Integer> solucion = new ArrayList<>();
        for (int i = 0; i < var.size(); ++i) {
            int rangoFrec = var.get(i).get(1) - 1; //-1 para evitar que se salga del rango
//            System.out.println("rango frec " + rangoFrec);
            int limite = dom.get(rangoFrec).size();
//            System.out.println("limite " + limite);
            int posicion = rand.nextInt(limite);
//            System.out.println("posicion " + posicion);
            solucion.add(dom.get(rangoFrec).get(posicion));
        }
        Utils utils = new Utils();
        MostrarDatos mostrar = new MostrarDatos();
//        System.out.println("tam solucion " + solucion.size());
//        mostrar.mostrarCoste(utils.calcularCoste(solucion, ctr,hashVar));
        return solucion;
    }

    /**
     * Para ficheros scen, ya que hay que hacer un cambio en los transistores, debido a que su orden es distinto
     * Introduce los datos del fichero dom.txt en la matrizDOM El rango de
     * frecuencia se introduce de 0 a numeroMAXRango
     *  
     * @param hashVar
     * @param ctr
     * @param dom
     * @param semilla
     * @param var
     * @return solucion
     */
    public ArrayList<Integer> greedy(ArrayList<ArrayList<Integer>> dom, ArrayList<ArrayList<Integer>> var,
            ArrayList<ArrayList<Integer>> ctr, Integer semilla, HashMap<Integer, Integer> hashVar) {
        Random rand = new Random(semilla);//añado la semilla para poder replicar el experimento
        ArrayList<Integer> solucion = new ArrayList<>();
        for (int i = 0; i < var.size(); ++i) {
//            System.out.println("i  " + i);
            int trx = var.get(i).get(0);
            int rangoFrec = var.get(hashVar.get(trx)-1).get(1) - 1; //-1 para evitar que en dom se salga del rango y -1 en el var.get para evitar que se salga de rango, ya que en los dos casos (0-(size-1)) 
//            System.out.println("rango frec " + rangoFrec);
            int limite = dom.get(rangoFrec).size();
//            System.out.println("limite " + limite);
            int posicion = rand.nextInt(limite);
//            System.out.println("posicion " + posicion);
            solucion.add(dom.get(rangoFrec).get(posicion));
        }
        Utils utils = new Utils();
        MostrarDatos mostrar = new MostrarDatos();
//        System.out.println("tam solucion greedy hashVar" + solucion.size());
        mostrar.mostrarCoste(utils.calcularCoste(solucion, ctr, hashVar));
        return solucion;
    }
/**
 *   VERSION NUEVA CON CTR NUEVO
     * Para ficheros scen, ya que hay que hacer un cambio en los transistores, debido a que su orden es distinto
     * Introduce los datos del fichero dom.txt en la matrizDOM El rango de
     * frecuencia se introduce de 0 a numeroMAXRango
     *  
     * @param hashVar
     * @param ctr
     * @param dom
     * @param semilla
     * @param var
     * @return solucion
     */
//    public ArrayList<Integer> greedy(ArrayList<ArrayList<Integer>> dom, ArrayList<ArrayList<Integer>> var,
//            ArrayList<ArrayList<Pair>> ctr, Integer semilla, HashMap<Integer, Integer> hashVar) {
//        Random rand = new Random(semilla);//añado la semilla para poder replicar el experimento
//        ArrayList<Integer> solucion = new ArrayList<>();
//        for (int i = 0; i < var.size(); ++i) {
////            System.out.println("i  " + i);
//            int trx = var.get(i).get(0);
//            int rangoFrec = var.get(hashVar.get(trx)-1).get(1) - 1; //-1 para evitar que en dom se salga del rango y -1 en el var.get para evitar que se salga de rango, ya que en los dos casos (0-(size-1)) 
////            System.out.println("rango frec " + rangoFrec);
//            int limite = dom.get(rangoFrec).size();
////            System.out.println("limite " + limite);
//            int posicion = rand.nextInt(limite);
////            System.out.println("posicion " + posicion);
//            solucion.add(dom.get(rangoFrec).get(posicion));
//        }
//        Utils utils = new Utils();
//        MostrarDatos mostrar = new MostrarDatos();
//        System.out.println("tam solucion greedy hashVar" + solucion.size());
//        mostrar.mostrarCoste(utils.calcularCoste(solucion, ctr, hashVar));
//        return solucion;
//    }
}
