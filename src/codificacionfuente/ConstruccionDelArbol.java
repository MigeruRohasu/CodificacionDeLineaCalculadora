/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codificacionfuente;

import java.util.*;

public class ConstruccionDelArbol {

    Organizar Organizar = new Organizar();
    private Vector<Integer> VectorArbol0 = new Vector<Integer>();
    private Vector<Integer> VectorArbol1 = new Vector<Integer>();
    private Vector<String> VectorACambiar1 = new Vector<String>();

    public void setVectorArbol(Vector<Integer> IngresoLetras, Vector<Integer> IngresoNumeros) {
        System.out.println();
        System.out.println("Entro al Arbol " + "\n" + IngresoLetras + "\n" + IngresoNumeros);
        VectorArbol1.clear();
        VectorArbol0.clear();
        VectorArbol1.addAll(IngresoNumeros);
        VectorArbol0.addAll(IngresoLetras);
        int memoria = 0;

        ArrayList<Vector<Integer>> Base = new ArrayList<Vector<Integer>>();
        for (int i = 0; i < VectorArbol0.size(); i++) {
            Vector<Integer> Nodo = new Vector<Integer>();
            Nodo.add(VectorArbol0.elementAt(i));
            Base.add(Nodo);
            VectorACambiar1.add("");
        }

        Vector<Integer> Memoria1 = new Vector<Integer>();
        
        while (VectorArbol1.size() > 1) {
int index=0;
            for(int i=0;i<Base.get(Base.size()-1).size();i++){
                index=IngresoLetras.indexOf(Base.get(Base.size()-1).elementAt(i));
                VectorACambiar1.set(index,"1"+VectorACambiar1.get(index) );
            }
            for(int i=0;i<Base.get(Base.size()-2).size();i++){
                index=IngresoLetras.indexOf(Base.get(Base.size()-2).elementAt(i));
                VectorACambiar1.set(index,"0"+VectorACambiar1.get(index) );
            }
            Base.get(Base.size()-2).addAll(Base.get(Base.size()-1));
            Base.remove(Base.size()-1);

 
            memoria = VectorArbol1.elementAt(VectorArbol1.size() - 1) + VectorArbol1.elementAt(VectorArbol1.size() - 2);
            VectorArbol1.removeElementAt(VectorArbol1.size() - 1);
            VectorArbol1.removeElementAt(VectorArbol1.size() - 1);
            VectorArbol1.add(memoria);
            Organizar.setVectorCambioArbol(Base, VectorArbol1);
            //Organizar.setVectorCambioUnico(VectorArbol1);

            //System.out.println("VectorArbol1.size() \n" + VectorACambiar1);
            VectorArbol1.clear();
            Base.clear();
            VectorArbol1.addAll(Organizar.getVectorCambio1());
            Base.addAll(Organizar.getVectorCambio2());
        }


        System.out.println("Hufman       \n"+VectorArbol0+"\n"+VectorACambiar1);
    }

    public Vector<String> getVectorACambiar1() {
        return VectorACambiar1;
    }

    public Vector<Integer> getVectorArbol0() {
        return VectorArbol0;
    }

    public Vector<Integer> getVectorArbol1() {
        return VectorArbol1;
    }
}
