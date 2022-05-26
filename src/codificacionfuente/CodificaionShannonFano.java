/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codificacionfuente;

import java.util.*;

public class CodificaionShannonFano {

    static Organizar Organizar = new Organizar();

    static String name;
    static int Espacio;
    static int Orden;

    public CodificaionShannonFano(String IngreseString, String IngreseEspacio, String IngreseOrden) {
        name = IngreseString;
        if (IngreseEspacio == "espacio") {
            Espacio = 1;
        }
        if (IngreseOrden == "abecedario") {
            Orden = 1;
        }
    }

    public CodificaionShannonFano(String IngreseString, String IngreseEspacio) {
        name = IngreseString;
        if (IngreseEspacio == "espacio") {
            Espacio = 1;
        }
        Orden = 0;

    }

    public CodificaionShannonFano(String IngreseString) {
        name = IngreseString;
        Espacio = 0;
        Orden = 0;

    }
    private String sapo = "";
    private String tramaBin = "";

    public void Iniciar() {
        // String to check it's value

        int Memoria = 0;

        int nameLenght = name.length(); // length of the string used for the loop
        Vector<Integer> VectorAscii = new Vector<Integer>(nameLenght);
        Vector VectorLetras = new Vector(nameLenght);

        Vector<Integer> VectorArbol0 = new Vector<Integer>();
        Vector<Integer> VectorArbol1 = new Vector<Integer>();

        Vector<Integer> VectorMemoria0 = new Vector<Integer>();
        Vector<Integer> VectorMemoria1 = new Vector<Integer>();

        for (int i = 0; i < nameLenght; i++) {
            char character = name.charAt(i);
            int ascii = (int) character;
            VectorAscii.addElement(ascii);
            VectorLetras.addElement(character);
            System.out.print(character + "=" + ascii + "   ");
        }
        //System.out.println("Vector Ascii "+VectorAscii);

//Quitar Espacio
        Organizar.quitarEspacios(VectorAscii, Espacio);
        VectorAscii.clear();
        VectorAscii.addAll(Organizar.getVectorCambio0());
        OrdenFila OrdenFila = new OrdenFila();

        Organizar.mayusculas(VectorAscii);
        VectorAscii.clear();
        VectorAscii.addAll(Organizar.getVectorCambio0());

        switch (Orden) {
            case 0:
//cuenta el Ascci
                Organizar.contar(VectorAscii);
                VectorArbol0.clear();
                VectorArbol1.clear();
                VectorArbol0.addAll(Organizar.getVectorCambio0());
                VectorArbol1.addAll(Organizar.getVectorCambio1());

//Ordena el vector
                Organizar.setVectorCambio(VectorArbol0, VectorArbol1);
                VectorArbol0.clear();
                VectorArbol1.clear();
                VectorArbol0.addAll(Organizar.getVectorCambio1());
                VectorArbol1.addAll(Organizar.getVectorCambio0());
                System.out.println("entra a  fila " + VectorArbol0 + "\n" + VectorArbol1);

//Ordena la fila
                OrdenFila.setFila(VectorArbol0, VectorArbol1);

                //System.out.println( OrdenFila.getVectorACambiar0()+"\n"+OrdenFila.getVectorACambiar1());
                for (int i = 0; i < OrdenFila.getVectorACambiar1().size(); i++) {
                    setSapo(getSapo() + Character.toString((char) OrdenFila.getVectorACambiar0().elementAt(i).intValue()) + "= ");
                    setSapo(getSapo() + OrdenFila.getVectorACambiar1().elementAt(i).toString());
                    setSapo(getSapo() + "   ");
                    setTramaBin(getTramaBin()+OrdenFila.getVectorACambiar1().elementAt(i).toString());
                }
                System.out.println(getSapo());

                break;

            case 1:

//cuenta el Ascci
                Organizar.setVectorCambioUnico(VectorAscii);
                VectorAscii.clear();
                VectorAscii.addAll(Organizar.getVectorCambio0());

                Organizar.contar(VectorAscii);
                VectorArbol0.clear();
                VectorArbol1.clear();
                VectorArbol0.addAll(Organizar.getVectorCambio0());
                VectorArbol1.addAll(Organizar.getVectorCambio1());

//Ordena el vector
                Organizar.setVectorCambio(VectorArbol0, VectorArbol1);
                VectorArbol0.clear();
                VectorArbol1.clear();
                VectorArbol0.addAll(Organizar.getVectorCambio1());
                VectorArbol1.addAll(Organizar.getVectorCambio0());
                System.out.println("entra a  fila " + VectorArbol0 + "\n" + VectorArbol1);

//Ordena la fila
                OrdenFila.setFila(VectorArbol0, VectorArbol1);
//System.out.println( OrdenFila.getVectorACambiar0()+"\n"+OrdenFila.getVectorACambiar1());
                for (int i = 0; i < OrdenFila.getVectorACambiar1().size(); i++) {
                    setSapo(getSapo() + Character.toString((char) OrdenFila.getVectorACambiar0().elementAt(i).intValue()) + "= ");
                    setSapo(getSapo() + OrdenFila.getVectorACambiar1().elementAt(i).toString());
                    setSapo(getSapo() + "   ");
                }
                System.out.println(getSapo());

            default:
                System.out.println("ingrese un orden correcto");
        }
        System.out.println("getTramaBin() "+getTramaBin());
    }

    /**
     * @return the sapo
     */
    public String getSapo() {
        return sapo;
    }

    /**
     * @param sapo the sapo to set
     */
    public void setSapo(String sapo) {
        this.sapo = sapo;
    }

    /**
     * @return the tramaBin
     */
    public String getTramaBin() {
        return tramaBin;
    }

    /**
     * @param tramaBin the tramaBin to set
     */
    public void setTramaBin(String tramaBin) {
        this.tramaBin = tramaBin;
    }
}
