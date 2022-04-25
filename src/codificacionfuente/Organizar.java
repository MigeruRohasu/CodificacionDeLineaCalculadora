/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codificacionfuente;

import java.util.*;

public class Organizar {

    private Vector<Integer> VectorACambiar0 = new Vector<Integer>();
    private Vector<Integer> VectorACambiar1 = new Vector<Integer>();
    private ArrayList<Vector<Integer>> VectorACambiar2 = new ArrayList<Vector<Integer>>();

    private int cuantoMuevo;

    public void setVectorCambio(Vector<Integer> IngresoNumeros, Vector<Integer> IngresoLetras) {

        int Memoria = 0;
        VectorACambiar1.clear();
        VectorACambiar0.clear();
        VectorACambiar1.addAll(IngresoNumeros);
        VectorACambiar0.addAll(IngresoLetras);
        System.out.println();
        System.out.println("Lo que entra a Organizar es " + "\n" + VectorACambiar0 + "\n" + VectorACambiar1);

        for (int a = 0; a < VectorACambiar0.size(); a++) {
            for (int b = a; b < VectorACambiar0.size(); b++) {

                if (VectorACambiar0.elementAt(a) < VectorACambiar0.elementAt(b)) {

                    for (int i = a; i < b; i++) {
                        Memoria = VectorACambiar0.elementAt(i);
                        VectorACambiar0.setElementAt(VectorACambiar0.elementAt(i + 1), i);
                        VectorACambiar0.setElementAt(Memoria, i + 1);

                        Memoria = VectorACambiar1.elementAt(i);
                        VectorACambiar1.setElementAt(VectorACambiar1.elementAt(i + 1), i);
                        VectorACambiar1.setElementAt(Memoria, i + 1);
                    }
                    b = a;
                }
            }
        }

        System.out.println("y asi quedo " + "\n" + VectorACambiar0 + "\n" + VectorACambiar1);
        System.out.println();
        System.out.println();
    }



    public void setVectorCambioArbol(ArrayList<Vector<Integer>> IngresoLetras,Vector<Integer> IngresoNumeros ) {

        int Memoria = 0;
        VectorACambiar1.clear();
        VectorACambiar2.clear();
        VectorACambiar1.addAll(IngresoNumeros);
        VectorACambiar2.addAll(IngresoLetras);
        System.out.println();
        System.out.println("Lo que entra a Organizar es " + "\n" + VectorACambiar2 + "\n" + VectorACambiar1);
        
        for (int a = 0; a < VectorACambiar1.size(); a++) {
            for (int b = a; b < VectorACambiar1.size(); b++) {

                if (VectorACambiar1.elementAt(a) < VectorACambiar1.elementAt(b)) {

                    for (int i = a; i < b; i++) {
                        Memoria = VectorACambiar1.elementAt(i);
                        VectorACambiar1.setElementAt(VectorACambiar1.elementAt(i + 1), i);
                        VectorACambiar1.setElementAt(Memoria, i + 1);

                        Vector<Integer>Memoria2 = new Vector<Integer>();
                        Vector<Integer>Memoria3 = new Vector<Integer>();

                        //System.out.println("\nlo pongo en "+(i+1)+VectorACambiar2.get(i)+"\nlo pongo en "+i +(VectorACambiar2.get(i + 1)));
                        Memoria2.addAll(VectorACambiar2.get(i));
                        Memoria3.addAll(VectorACambiar2.get(i+1));
                        
                        VectorACambiar2.set(i, Memoria3 );

                        //System.out.println("sapoooooooooooooooooooooooooooooooooooooo  "+(i+1)+"   "+Memoria2);
                        VectorACambiar2.set( (i + 1),Memoria2);
                        //System.out.println("VectorACambiar2 "+VectorACambiar2);
                    }
                    b = a;
                }
            }
        }

        System.out.println("y asi quedo " + "\n" + VectorACambiar2 + "\n" + VectorACambiar1);
        System.out.println();
        System.out.println();
    }




    public void setVectorCambioUnico(Vector<Integer> IngresoNumeros) {

        int Memoria = 0;
        VectorACambiar0.clear();
        VectorACambiar0.addAll(IngresoNumeros);
        System.out.println();
        System.out.println("Lo que enta a Organizar es " + "\n" + VectorACambiar0);
        cuantoMuevo = 0;
        for (int a = 0; a < VectorACambiar0.size(); a++) {
            for (int b = a; b < VectorACambiar0.size(); b++) {

                if (VectorACambiar0.elementAt(a) < VectorACambiar0.elementAt(b)) {

                    for (int i = a; i < b; i++) {
                        Memoria = VectorACambiar0.elementAt(i);
                        VectorACambiar0.setElementAt(VectorACambiar0.elementAt(i + 1), i);
                        VectorACambiar0.setElementAt(Memoria, i + 1);
                    }
                    cuantoMuevo = cuantoMuevo + 1;
                    b = a;

                }
            }
        }
        System.out.println("y asi quedo " + "\n" + VectorACambiar0);
        System.out.println();
        System.out.println();
    }

    public void contar(Vector<Integer> IngresoLetras) {
        int Memoria = 0;
        VectorACambiar1.clear();
        VectorACambiar0.clear();
        System.out.println();
        System.out.println("Lo que entra a contar es " + "\n" + IngresoLetras);
        Vector<Integer> VecMemoria = new Vector<Integer>();
//Contar las letras que se repiten
        Memoria = 0;
        boolean Band1 = true;
        for (int ii = 0; Band1; ii++) {

            int count = 0;
            for (int i = 0; i < IngresoLetras.size(); i++) {
                if (IngresoLetras.elementAt(0) == IngresoLetras.elementAt(i)) {
                    count = count + 1;
                }
            }
            VectorACambiar0.addElement(IngresoLetras.elementAt(0));
            VectorACambiar1.addElement(count);

//borrar valores de lista
            VecMemoria.clear();
            Memoria = IngresoLetras.elementAt(0);
            for (int s = 0; s < IngresoLetras.size(); s++) {
                if (IngresoLetras.elementAt(s) != Memoria) {
                    VecMemoria.add(IngresoLetras.elementAt(s));
                }
            }

            IngresoLetras.clear();
            IngresoLetras.addAll(VecMemoria);

//termina el conteo 
            if (IngresoLetras.size() == 0) {
                Band1 = false;
            }
        }
        System.out.println("Lo que sale de contar es " + "\n" + VectorACambiar0 + "\n" + VectorACambiar1);
    }

    public void quitarEspacios(Vector<Integer> IngresoLetras, int Espacio) {

        if (Espacio == 1) {
            for (int i = 0; i < IngresoLetras.size(); i++) {
                if (IngresoLetras.elementAt(i) == 32) {
                    IngresoLetras.removeElementAt(i);
                    i = i - 1;
                }
            }

            VectorACambiar0.clear();
            VectorACambiar0.addAll(IngresoLetras);
        } else {
            VectorACambiar0.clear();
            VectorACambiar0.addAll(IngresoLetras);
        }
    }

    public void mayusculas(Vector<Integer> IngresoLetras) {
        VectorACambiar0.clear();
        for (int i = 0; i < IngresoLetras.size(); i++) {
            if (IngresoLetras.elementAt(i) >= 65 && IngresoLetras.elementAt(i) <= 90) {
                VectorACambiar0.add(IngresoLetras.elementAt(i) + 32);
            } else {
                VectorACambiar0.add(IngresoLetras.elementAt(i));
            }
        }
    }

    public Vector<Integer> getVectorCambio0() {
        return VectorACambiar0;
    }

    public Vector<Integer> getVectorCambio1() {
        return VectorACambiar1;
    }

    public ArrayList<Vector<Integer>> getVectorCambio2() {
        return VectorACambiar2;
    }

    public int cuantoMuevo() {
        return cuantoMuevo;
    }
}
