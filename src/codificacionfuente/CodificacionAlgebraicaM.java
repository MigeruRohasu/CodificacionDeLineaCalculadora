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
public class CodificacionAlgebraicaM {

    /**
     * @return the base
     */
    public int getBase() {
        return base;
    }

    private String mensaje="";
    private String mensajeDecimal="";
    private String mensajeDecimalUltimoCorte="";
    private String tramaBin="";
    private int L;
    private int base;
    private Organizar organizar = new Organizar();
    private ArrayList<Vector<Integer>> mensajeArray = new ArrayList<Vector<Integer>>();

    public void iniciar() {
        Vector<Integer> countMensaje = new Vector<Integer>();

        for (int i = 0; i < mensaje.length(); i++) {
            char character = mensaje.charAt(i);
            int ascii = (int) character;
            Vector<Integer> n = new Vector<Integer>();
            n.addElement(ascii);
            countMensaje.add(ascii);
            mensajeArray.add(n);
            System.out.print(character + "=" + ascii + "   ");
        }
        organizar.contar(countMensaje);
        L = mensajeArray.size();
        base = organizar.getVectorCambioLetras().size();
        mensajeDecimal = "0.";

        for (int i = 0; i < mensajeArray.size(); i++) {
            for (int j = 0; j < organizar.getVectorCambioLetras().size(); j++) {
                if (mensajeArray.get(i).elementAt(0) == organizar.getVectorCambioLetras().elementAt(j)) {
                    mensajeArray.get(i).add(j);
                    mensajeDecimal = mensajeDecimal + j;
                }
            }
        }
        System.out.println("mensaje Decimal " + mensajeDecimal);
        //base2ToBaseX("0.00001",5);
        tramaBin = baseXToBase2(mensajeDecimal, getBase());
    }

    public String baseXToBase2(String mensaje, int base) {
        String base2 = "0.";
        String base10 = "";
        // de base x a base 10
        double count = 0;
        int count1 = 1;
        for (int i = 2; i < mensaje.length(); i++) {
            //System.out.println("Math.pow  "+base+" "+(-(count1))+" "+mensaje.charAt(i)+" "+Math.pow(base, -(count1))+"  "+mensaje.charAt(i)+"  "+Math.pow(base, -(count1)) *Character.getNumericValue(mensaje.charAt(i)));       
            count = count + (Math.pow(base, -(count1)) * Character.getNumericValue(mensaje.charAt(i)));
            count1++;
        }
        base10 = String.valueOf(count);
        System.out.println("base10 " + base10);

        // de base 10 a base 2
        boolean band = true;
        double comp = Double.valueOf(base10) * 2;
        String mensajeDecimal_1 = "0.";
        for (int i = 0; i < mensajeArray.size() - 1; i++) {
            mensajeDecimal_1 = mensajeDecimal_1 + String.valueOf(mensajeArray.get(i).elementAt(1));
        }
        System.out.println("mensajeDecimal_1 " + mensajeDecimal_1);

        for (int i = 0; i < 20; i++) {
            if (comp < 1) {
                base2 = base2 + "0";
            } else {
                base2 = base2 + "1";
                comp = comp - 1;
            }
            //System.out.println("comparacion "+Double.valueOf(base2ToBaseX(base2,base))+"  >  "+Double.valueOf(mensajeDecimal_1));
            if (Double.valueOf(base2ToBaseX(base2, base)) > Double.valueOf(mensajeDecimal_1)) {
                break;
            }
            comp = comp * 2;

        }
        System.out.println("base2 " + base2);
        return base2;
    }

    public String base2ToBaseX(String mensaje, int base) {

        System.out.println("\n \nentre a base2ToBaseX " + mensaje + " " + base);
        String baseX;
        String base10;
//de base 2 a base 10
        double count = 0;
        int count1 = 1;
        for (int i = 2; i < mensaje.length(); i++) {
            //System.out.println("Math.pow  "+2+" "+(-(count1))+" = "+Math.pow(2, -(count1))+" "+Character.getNumericValue(mensaje.charAt(i))+"  "+(Math.pow(2, -(count1)) * Character.getNumericValue(mensaje.charAt(i))));       

            count = count + (Math.pow(2, -(count1)) * Character.getNumericValue(mensaje.charAt(i)));
            count1++;
        }
        base10 = String.valueOf(count);
        System.out.println("base10 " + base10);
        System.out.println("");
        mensajeDecimalUltimoCorte = base10;
//de base 10 a base x
        boolean band = true;
        baseX = "0.";
        for (int i = 0; i < mensajeDecimal.length() - 2; i++) {

            base10 = String.valueOf(Double.valueOf(base10) * (double) base);
            baseX = baseX + base10.substring(0, base10.indexOf('.'));
            base10 = String.valueOf(Double.valueOf(base10) - Double.valueOf(base10.substring(0, base10.indexOf('.'))));

        }
        System.out.println("basex " + baseX);
        return baseX;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the tramaBin
     */
    public String getTramaBin() {
        return tramaBin;
    }

    /**
     * @return the mensajeDecimalUltimoCorte
     */
    public String getMensajeDecimalUltimoCorte() {
        return mensajeDecimalUltimoCorte;
    }
}
