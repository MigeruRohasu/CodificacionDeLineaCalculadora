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
    private String tramaBin = "";

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

        Vector<Integer> VectorArbolLetra = new Vector<Integer>();
        Vector<Integer> VectorArbolCuenta = new Vector<Integer>();

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
        VectorAscii.addAll(Organizar.getVectorCambioLetras());

        Organizar.quitarEspacios(VectorAscii, Espacio);
        VectorAscii.clear();
        VectorAscii.addAll(Organizar.getVectorCambioLetras());

        
                Organizar.contar(VectorAscii);
                VectorArbolLetra.clear();
                VectorArbolCuenta.clear();
                VectorArbolLetra.addAll(Organizar.getVectorCambioLetras());
                VectorArbolCuenta.addAll(Organizar.getVectorCambioCuenta());
                
//Ordena el vector
                Organizar.mayorAMenor(VectorArbolCuenta, VectorArbolLetra);

                VectorArbolLetra.clear();
                VectorArbolCuenta.clear();
                VectorArbolLetra.addAll(Organizar.getVectorCambioLetras());
                VectorArbolCuenta.addAll(Organizar.getVectorCambioCuenta());

//empieza el arbol
                //System.out.println(VectorArbolLetra + "\n" + VectorArbolCuenta);
                ConstruccionDelArbol.setVectorArbol(VectorArbolLetra, VectorArbolCuenta);

                System.out.println("Codificacion Huffman \n" + ConstruccionDelArbol.getVectorArbolLetras() + "\n" + ConstruccionDelArbol.getVectorACambiar1());

                for (int i = 0; i < ConstruccionDelArbol.getVectorACambiar1().get(0).size(); i++) {
                    setHuff(getHuff() + Character.toString((char) ConstruccionDelArbol.getVectorArbolLetras().elementAt(i).intValue()) + "=  ");
                    setHuff(getHuff() + ConstruccionDelArbol.getVectorACambiar1().get(0).get(i));
                    setHuff(getHuff() + "   ");
                    //setTramaBin(getTramaBin() + ConstruccionDelArbol.getVectorACambiar1().get(0).get(i));
                }
                System.out.println(getHuff());
                for (int a = 0; a < name.length(); a++) {
                    for (int b = 0; b < ConstruccionDelArbol.getVectorArbolLetras().size(); b++) {
                        if (name.charAt(a)==(char) ConstruccionDelArbol.getVectorArbolLetras().elementAt(b).intValue()) {
                            setTramaBin(getTramaBin() + ConstruccionDelArbol.getVectorACambiar1().get(0).get(b));
                        }
                    }
                }
                System.out.println("\n \n \n getTramaBin "+getTramaBin());
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
