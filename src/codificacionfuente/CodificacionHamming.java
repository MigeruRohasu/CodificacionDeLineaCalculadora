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
public class CodificacionHamming {

    private ArrayList<String> linea = new ArrayList<String>();
    private ArrayList<ArrayList<String>> matriz = new ArrayList<ArrayList<String>>();
    private String mostrarFP = "\n";
    private String tramaBin = "";
    private String check3="";

    public void clear() {
        check3="";
        linea.clear();
        matriz.clear();
        mostrarFP = "\n";
        tramaBin = "";
    }

    public void Iniciar(String fila) {
        codificar(fila);
    }

    public void codificar(String fila) {
        System.out.println("mensaje que entra " + fila);
        clear();
        int count = 0;
        int potencias2 = 1;
        while (count < fila.length()) {
            if (linea.size() == potencias2 - 1) {
                //System.out.println("entre <<<<===============");
                linea.add(" ");
                potencias2 = potencias2 * 2;
            } else {
                linea.add(fila.substring(count, count + 1));
                count++;
            }
        }

        potencias2 = 1;
        for (int i = 0; i < linea.size(); i++) {
            if (linea.get(i) == " ") {
                ArrayList<String> n = new ArrayList<String>();
                int estado = 1;
                count = 1;
                int pariedad = 0;
                for (int a = 0; a < linea.size(); a++) {
                    if (count == potencias2) {
                        if (estado == 0) {
                            estado = 1;
                        } else {
                            estado = 0;
                        }
                        count = 0;
                    }
                    if (estado == 1) {
                        n.add("-");
                    } else {
                        n.add(linea.get(a));
                    }
                    count++;
                    if (n.get(a).equals("1")) {
                        pariedad++;
                    }
                }
                if (pariedad % 2 == 0) {
                    pariedad = 0;
                } else {
                    pariedad = 1;
                }

                for (int a = 0; a < linea.size(); a++) {
                    if (linea.get(a) == " ") {
                        linea.set(a, String.valueOf(pariedad));
                        break;
                    }
                }
                n.set(n.indexOf(" "), String.valueOf(pariedad));

                matriz.add(n);
                potencias2 = potencias2 * 2;
            }
        }
        tramaBin = "";
        for (int i = 0; i < linea.size(); i++) {
            tramaBin = getTramaBin() + linea.get(i);
        }
        System.out.println("mensaje de salida " + getTramaBin());
        mostrarMatriz(matriz);
    }

    private void mostrarMatriz(ArrayList<ArrayList<String>> matriz) {
        mostrarFP = "\n";
        for (int a = 0; a < matriz.size(); a++) {
            mostrarFP=mostrarFP+ "Fp"+(a+1)+"\t";
            for (int b = 0; b < matriz.get(0).size(); b++) {
                mostrarFP = getMostrarFP() + matriz.get(a).get(b) + "\t";
            }
            mostrarFP = getMostrarFP() + "\n";
        }
        System.out.println("mostrarFP " + getMostrarFP());
    }

    public void simularError(String fila, String errorSimulado) {
        int error = Integer.valueOf(errorSimulado);
        tramaBin = "";
        for (int i = 0; i < fila.length(); i++) {
            if (i == error) {
                if (fila.charAt(i) == '0') {
                    tramaBin = getTramaBin() + "1";
                } else {
                    tramaBin = getTramaBin() + "0";
                }
            } else {
                tramaBin = getTramaBin() + fila.charAt(i);
            }
        }
    }

    public void decodificar(String fila) {
        System.out.println("mensaje que entra " + fila);
        clear();
        int count = 0;
        int potencias2 = 1;
        String check = "";

        linea.clear();
//-----------------------------------------------------------------------------
        for (int i = 0; i < fila.length(); i++) {
            if (i == potencias2 - 1) {
                //System.out.println("entre <<<<===============");
                check = fila.charAt(i) + check;
                potencias2 = potencias2 * 2;
            } else {
                linea.add(String.valueOf(fila.charAt(i)));
            }
        }
        System.out.println("linea " + linea);
        count = 0;
        fila = "";
        while (count < linea.size()) {
            fila = fila + linea.get(count);
            count++;
        }
        linea.clear();
        System.out.println("fila " + fila);
        System.out.println("check " + check);

//-----------------------------------------------------------------------------
        potencias2 = 1;
        count = 0;
        while (count < fila.length()) {
            if (linea.size() == potencias2 - 1) {
                //System.out.println("entre <<<<===============");
                linea.add(" ");
                potencias2 = potencias2 * 2;
            } else {
                linea.add(fila.substring(count, count + 1));
                count++;
            }
        }
//-----------------------------------------------------------------------------

        potencias2 = 1;
        String check2 = "";
        for (int i = 0; i < linea.size(); i++) {
            if (linea.get(i) == " ") {
                ArrayList<String> n = new ArrayList<String>();
                int estado = 1;
                count = 1;
                int pariedad = 0;
                for (int a = 0; a < linea.size(); a++) {
                    if (count == potencias2) {
                        if (estado == 0) {
                            estado = 1;
                        } else {
                            estado = 0;
                        }
                        count = 0;
                    }
                    if (estado == 1) {
                        n.add("-");
                    } else {
                        n.add(linea.get(a));
                    }
                    count++;
                    if (n.get(a).equals("1")) {
                        pariedad++;
                    }
                }
                if (pariedad % 2 == 0) {
                    pariedad = 0;
                    check2 = String.valueOf(pariedad) + check2;
                } else {
                    pariedad = 1;
                    check2 = String.valueOf(pariedad) + check2;
                }

                for (int a = 0; a < linea.size(); a++) {
                    if (linea.get(a) == " ") {
                        linea.set(a, String.valueOf(pariedad));
                        break;
                    }
                }
                n.set(n.indexOf(" "), String.valueOf(pariedad));

                matriz.add(n);
                potencias2 = potencias2 * 2;
            }
        }
        tramaBin = "";
        for (int i = 0; i < linea.size(); i++) {
            tramaBin = getTramaBin() + linea.get(i);
        }
        System.out.println("mensaje de salida " + getTramaBin());
        System.out.println("check2 " + check2);
        mostrarMatriz(matriz);

        check3="";
        for (int i = 0; i < check2.length(); i++) {
            if (check2.charAt(i) == check.charAt(i)) {
                check3 = getCheck3() + "0";
            } else {
                check3 = getCheck3() + "1";
            }
        }
        System.out.println("check3 " + getCheck3());
    }

    /**
     * @return the mostrarFP
     */
    public String getMostrarFP() {
        return mostrarFP;
    }

    /**
     * @return the tramaBin
     */
    public String getTramaBin() {
        return tramaBin;
    }

    /**
     * @return the check3
     */
    public String getCheck3() {
        return check3;
    }
}
