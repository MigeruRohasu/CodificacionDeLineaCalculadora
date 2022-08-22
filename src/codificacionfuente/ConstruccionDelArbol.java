/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codificacionfuente;

import java.util.*;

public class ConstruccionDelArbol {

    Organizar Organizar = new Organizar();
    private Vector<Integer> VectorArbolLetras = new Vector<Integer>();
    private Vector<Integer> VectorArbolCuenta = new Vector<Integer>();
    private ArrayList<Vector<String>> VectorACambiar1 = new ArrayList<Vector<String>>();

    public void setVectorArbol(Vector<Integer> IngresoLetras, Vector<Integer> IngresoNumeros) {

        System.out.println("-----------------------------------------------------------------------");
        System.out.println();
        System.out.println("Entro al Arbol " + "\n" + IngresoLetras + "\n" + IngresoNumeros);
        VectorArbolCuenta.clear();
        VectorArbolLetras.clear();
        VectorArbolCuenta.addAll(IngresoNumeros);
        VectorArbolLetras.addAll(IngresoLetras);
        int memoria = 0;

        ArrayList<Vector<Integer>> Base = new ArrayList<Vector<Integer>>();
        for (int i = 0; i < VectorArbolLetras.size(); i++) {
            Vector<Integer> Nodo = new Vector<Integer>();
            Nodo.add(VectorArbolLetras.elementAt(i));
            Base.add(Nodo);
            Vector<String> Nodo1 = new Vector<String>();
            Nodo1.add("");
            VectorACambiar1.add(Nodo1);
        }

        Vector<Integer> Memoria1 = new Vector<Integer>();

        while (VectorArbolCuenta.size() > 1) {
            int index = 0;

            for(int i=0;i<VectorACambiar1.get(VectorACambiar1.size()-1).size();i++){
                VectorACambiar1.get(VectorACambiar1.size()-1).set(i,"1"+VectorACambiar1.get(VectorACambiar1.size()-1).get(i));

            }
            for(int i=0;i<VectorACambiar1.get(VectorACambiar1.size()-2).size();i++){
                VectorACambiar1.get(VectorACambiar1.size()-2).set(i,"0"+VectorACambiar1.get(VectorACambiar1.size()-2).get(i));
            }

            VectorACambiar1.get(VectorACambiar1.size() - 2).addAll(VectorACambiar1.get(VectorACambiar1.size() - 1));
            VectorACambiar1.remove(VectorACambiar1.size() - 1);

            Base.get(Base.size() - 2).addAll(Base.get(Base.size() - 1));
            Base.remove(Base.size() - 1);



            memoria = VectorArbolCuenta.elementAt(VectorArbolCuenta.size() - 1) + VectorArbolCuenta.elementAt(VectorArbolCuenta.size() - 2);
            VectorArbolCuenta.removeElementAt(VectorArbolCuenta.size() - 1);
            VectorArbolCuenta.removeElementAt(VectorArbolCuenta.size() - 1);
            VectorArbolCuenta.add(memoria);

            Organizar.setVectorCambioArbol(Base, VectorArbolCuenta,VectorACambiar1);
            //Organizar.setVectorCambioUnico(VectorArbolCuenta);

            //System.out.println("VectorArbolCuenta.size() \n" + VectorACambiar1);
            VectorArbolCuenta.clear();
            Base.clear();
            VectorArbolCuenta.addAll(Organizar.getVectorCambioCuenta());
            Base.addAll(Organizar.getVectorCambio2());
            VectorACambiar1.clear();
            VectorACambiar1.addAll(Organizar.getVectorACambiarCodificacion());
            //System.out.println(VectorACambiar1+"\n");
        }
        VectorArbolLetras.clear();
        VectorArbolLetras.addAll(Base.get(0));
        System.out.println("Hufman       \n" + Base + "\n" + VectorACambiar1);

        System.out.println("-----------------------------------------------------------------------");
    }

    public ArrayList<Vector<String>> getVectorACambiar1() {
        return VectorACambiar1;
    }

    public Vector<Integer> getVectorArbolLetras() {
        return VectorArbolLetras;
    }

    public Vector<Integer> getVectorArbolCuenta() {
        return VectorArbolCuenta;
    }
}
