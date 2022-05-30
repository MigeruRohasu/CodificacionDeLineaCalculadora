/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codificacionfuente;

import java.util.*;

public class Organizar {

    private Vector<Integer> VectorACambiarLetras = new Vector<Integer>();
    private Vector<Integer> VectorACambiarCuenta = new Vector<Integer>();
    private ArrayList<Vector<String>> VectorACambiarCodificacion = new ArrayList<Vector<String>>();
    private ArrayList<Vector<Integer>> VectorACambiar2 = new ArrayList<Vector<Integer>>();

    private int cuantoMuevo;

    public void mayorAMenor(Vector<Integer> IngresoCuenta, Vector<Integer> IngresoLetras) {
        //System.out.println("--------------------------------------------------------------------------------------------");
        int Memoria = 0;
        VectorACambiarCuenta.clear();
        VectorACambiarLetras.clear();
        VectorACambiarCuenta.addAll(IngresoCuenta);
        VectorACambiarLetras.addAll(IngresoLetras);
        System.out.println();
        System.out.println("Lo que entra a Organizar es " + "\n" + VectorACambiarLetras + "\n" + VectorACambiarCuenta);

        for (int a = 0; a < VectorACambiarCuenta.size(); a++) {
            for (int b = a; b < VectorACambiarCuenta.size(); b++) {
                //System.out.println("if (VectorACambiarCuenta.elementAt(a) < VectorACambiarCuenta.elementAt(b))   \n"+a+"  <  "+b);
                if (VectorACambiarCuenta.elementAt(a) < VectorACambiarCuenta.elementAt(b)) {
                    for (int i = b; i > a; i--) {
                        
                        Memoria = VectorACambiarLetras.elementAt(i);
                        VectorACambiarLetras.setElementAt(VectorACambiarLetras.elementAt(i - 1), i);
                        VectorACambiarLetras.setElementAt(Memoria, i - 1);
                        
                        //System.out.println("("+i+" <-- "+(i-1)+")");
                        Memoria = VectorACambiarCuenta.elementAt(i);
                        VectorACambiarCuenta.setElementAt(VectorACambiarCuenta.elementAt(i - 1), i);
                        VectorACambiarCuenta.setElementAt(Memoria, i - 1);
                    }
                    b = a;
                }
                //System.out.println(VectorACambiarCuenta);
            }
        }

        System.out.println("y asi quedo " + "\n" + VectorACambiarLetras + "\n" + VectorACambiarCuenta);
        System.out.println();
        System.out.println();

        //System.out.println("--------------------------------------------------------------------------------------------");
    }



    public void setVectorCambioArbol(ArrayList<Vector<Integer>> IngresoLetras,Vector<Integer> IngresoNumeros ,ArrayList<Vector<String>> IngresoCodificacion) {

        int Memoria = 0;
        String Memoria1="";
        VectorACambiarCuenta.clear();
        VectorACambiar2.clear();
        getVectorACambiarCodificacion().clear();
        VectorACambiarCuenta.addAll(IngresoNumeros);
        VectorACambiar2.addAll(IngresoLetras);
        getVectorACambiarCodificacion().addAll(IngresoCodificacion);
        System.out.println();

        System.out.println("Lo que entra a Organizar es");
        for(int a=0;a<VectorACambiar2.size();a++){
            System.out.print("[");
            for(int b=0;b<VectorACambiar2.get(a).size();b++){
                int letra=VectorACambiar2.get(a).get(b);                
System.out.print((char)letra+",");
            }
            System.out.print("] ");
        }
        System.out.println("\n" + VectorACambiarCuenta+ "\n" +getVectorACambiarCodificacion());
        
        for (int a = 0; a < VectorACambiarCuenta.size(); a++) {
            for (int b = a; b < VectorACambiarCuenta.size(); b++) {
                //System.out.println("if (VectorACambiarCuenta.elementAt(a) < VectorACambiarCuenta.elementAt(b))   \n"+a+"  <  "+b);
                if (VectorACambiarCuenta.elementAt(a) < VectorACambiarCuenta.elementAt(b)) {
                    for (int i = b; i > a; i--) {

                        Memoria = VectorACambiarCuenta.elementAt(i);
                        VectorACambiarCuenta.setElementAt(VectorACambiarCuenta.elementAt(i - 1), i);
                        VectorACambiarCuenta.setElementAt(Memoria, i - 1);

                        Vector<Integer>Memoria2 = new Vector<Integer>();
                        Vector<Integer>Memoria3 = new Vector<Integer>();
                        
                        Memoria2.addAll(VectorACambiar2.get(i));
                        Memoria3.addAll(VectorACambiar2.get(i-1));
                        
                        VectorACambiar2.set(i, Memoria3 );

                        VectorACambiar2.set( (i - 1),Memoria2);




                        Vector<String>Memoria22 = new Vector<String>();
                        Vector<String>Memoria33 = new Vector<String>();

                        Memoria22.addAll(getVectorACambiarCodificacion().get(i));
                        Memoria33.addAll(getVectorACambiarCodificacion().get(i-1));
                        
                        getVectorACambiarCodificacion().set(i, Memoria33 );

                        getVectorACambiarCodificacion().set( (i - 1),Memoria22);
                    }
                    b = a;
                }
            }
        }

        System.out.println("y asi quedo ");
for(int a=0;a<VectorACambiar2.size();a++){
            System.out.print("[");
            for(int b=0;b<VectorACambiar2.get(a).size();b++){
int letra=VectorACambiar2.get(a).get(b);                
System.out.print((char)letra+",");
            }
            System.out.print("] ");
        }
        System.out.println("\n" + VectorACambiarCuenta+ "\n" +getVectorACambiarCodificacion());
        System.out.println();
        System.out.println();
    }




    public void setVectorCambioUnico(Vector<Integer> IngresoNumeros) {

        int Memoria = 0;
        VectorACambiarLetras.clear();
        VectorACambiarLetras.addAll(IngresoNumeros);
        System.out.println();
        System.out.println("Lo que enta a Organizar es " + "\n" + VectorACambiarLetras);
        cuantoMuevo = 0;
        for (int a = 0; a < VectorACambiarLetras.size(); a++) {
            for (int b = a; b < VectorACambiarLetras.size(); b++) {

                if (VectorACambiarLetras.elementAt(a) < VectorACambiarLetras.elementAt(b)) {

                    for (int i = a; i < b; i++) {
                        Memoria = VectorACambiarLetras.elementAt(i);
                        VectorACambiarLetras.setElementAt(VectorACambiarLetras.elementAt(i + 1), i);
                        VectorACambiarLetras.setElementAt(Memoria, i + 1);
                    }
                    cuantoMuevo = cuantoMuevo + 1;
                    b = a;

                }
            }
        }
        System.out.println("y asi quedo " + "\n" + VectorACambiarLetras);
        System.out.println();
        System.out.println();
    }

    public void contar(Vector<Integer> IngresoLetras) {
        int Memoria = 0;
        VectorACambiarCuenta.clear();
        VectorACambiarLetras.clear();
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
            VectorACambiarLetras.addElement(IngresoLetras.elementAt(0));
            VectorACambiarCuenta.addElement(count);

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
        System.out.println("Lo que sale de contar es " + "\n" + VectorACambiarLetras + "\n" + VectorACambiarCuenta);
    }

    public void quitarEspacios(Vector<Integer> IngresoLetras, int Espacio) {

        if (Espacio == 1) {
            for (int i = 0; i < IngresoLetras.size(); i++) {
                if (IngresoLetras.elementAt(i) == 32) {
                    IngresoLetras.removeElementAt(i);
                    i = i - 1;
                }
            }

            VectorACambiarLetras.clear();
            VectorACambiarLetras.addAll(IngresoLetras);
        } else {
            VectorACambiarLetras.clear();
            VectorACambiarLetras.addAll(IngresoLetras);
        }
    }

    public void mayusculas(Vector<Integer> IngresoLetras) {
        VectorACambiarLetras.clear();
        for (int i = 0; i < IngresoLetras.size(); i++) {
            if (IngresoLetras.elementAt(i) >= 65 && IngresoLetras.elementAt(i) <= 90) {
                VectorACambiarLetras.add(IngresoLetras.elementAt(i) + 32);
            } else {
                VectorACambiarLetras.add(IngresoLetras.elementAt(i));
            }
        }
    }

    public Vector<Integer> getVectorCambioLetras() {
        return VectorACambiarLetras;
    }

    public Vector<Integer> getVectorCambioCuenta() {
        return VectorACambiarCuenta;
    }

    public ArrayList<Vector<Integer>> getVectorCambio2() {
        return VectorACambiar2;
    }

    public int cuantoMuevo() {
        return cuantoMuevo;
    }

    /**
     * @return the VectorACambiarCodificacion
     */
    public ArrayList<Vector<String>> getVectorACambiarCodificacion() {
        return VectorACambiarCodificacion;
    }

}
