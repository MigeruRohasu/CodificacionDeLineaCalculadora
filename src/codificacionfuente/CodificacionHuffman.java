/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codificacionfuente;

import java.util.*;

/**
 *
 * @author super
 */
public class CodificacionHuffman {

    static String name;
    static int Espacio;
    static int Orden;
    private String Huff = "";
    private String tramaBin="";

    public void setHuff(String Huff) {
        this.Huff = Huff;
    }

    /**
     * @return the Huff
     */
    public String getHuff() {
        return Huff;
    }

    public CodificacionHuffman(String IngreseString, String IngreseEspacio, String IngreseOrden) {
        name = IngreseString;
        if (IngreseEspacio == "espacio") {
            Espacio = 1;
        }
        if (IngreseOrden == "abecedario") {
            Orden = 1;
        }
    }

    public CodificacionHuffman(String IngreseString, String IngreseEspacio) {
        name = IngreseString;
        if (IngreseEspacio == "espacio") {
            Espacio = 1;
        }
        Orden = 0;
    }

    public CodificacionHuffman(String IngreseString) {
        name = IngreseString;
        Espacio = 0;
        Orden = 0;
    }

    public void Iniciar() {
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
        ConstruccionDelArbol ConstruccionDelArbol = new ConstruccionDelArbol();
        Organizar Organizar = new Organizar();

        Organizar.mayusculas(VectorAscii);
        VectorAscii.clear();
        VectorAscii.addAll(Organizar.getVectorCambio0());

        Organizar.quitarEspacios(VectorAscii, Espacio);
        VectorAscii.clear();
        VectorAscii.addAll(Organizar.getVectorCambio0());

        switch (Orden) {
            case 0:
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

//empieza el arbol
                //System.out.println(VectorArbol0 + "\n" + VectorArbol1);
                ConstruccionDelArbol.setVectorArbol(VectorArbol0, VectorArbol1);
                System.out.println("Codificacion Huffman \n" + ConstruccionDelArbol.getVectorArbol0() + "\n" + ConstruccionDelArbol.getVectorACambiar1());

                for (int i = 0; i < ConstruccionDelArbol.getVectorACambiar1().size(); i++) {
                    setHuff(getHuff() + Character.toString((char) ConstruccionDelArbol.getVectorArbol0().elementAt(i).intValue()) + "=  ");
                    setHuff(getHuff() + ConstruccionDelArbol.getVectorACambiar1().elementAt(i).toString());
                    setHuff(getHuff() + "   ");
                    setTramaBin(getTramaBin() + ConstruccionDelArbol.getVectorACambiar1().elementAt(i).toString());
                }
                System.out.println(getHuff());
                break;

            case 1:

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

//empieza el arbol
                //System.out.println("estoy aqui");
                //System.out.println(VectorArbol0 + "\n" + VectorArbol1);
                ConstruccionDelArbol.setVectorArbol(VectorArbol0, VectorArbol1);
                System.out.println("Codificacion Huffman \n" + ConstruccionDelArbol.getVectorACambiar1());

                for (int i = 0; i < ConstruccionDelArbol.getVectorACambiar1().size(); i++) {
                    setHuff(getHuff() + Character.toString((char) ConstruccionDelArbol.getVectorArbol0().elementAt(i).intValue()) + "= ");
                    setHuff(getHuff() + ConstruccionDelArbol.getVectorACambiar1().elementAt(i).toString());
                    setHuff(getHuff() + "   ");
                    setTramaBin(getTramaBin() + ConstruccionDelArbol.getVectorACambiar1().elementAt(i).toString());
                }
                System.out.println(getHuff());

                break;

            default:
                System.out.println("ingrese un orden correcto");
        }
//       System.out.println("\n \n \n getTramaBin "+getTramaBin());
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
