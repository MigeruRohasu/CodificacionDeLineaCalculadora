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
    private String mostrarFP="\n";
    private String mensaje="";

    public void Iniciar(String fila) {
        codificar(fila);
    }

    public void codificar(String fila) {
        int count = 0;
        int potencias2 = 1;
        while (count < fila.length()) {
            if (linea.size() == potencias2 - 1) {
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
        mensaje = "";
        for (int i = 0; i < linea.size(); i++) {
            mensaje = mensaje + linea.get(i);
        }
        System.out.println("mensaje "+mensaje);
        mostrarMatriz(matriz);
    }

    private void mostrarMatriz(ArrayList<ArrayList<String>> matriz){
        for(int a=0;a<matriz.size();a++){
            for(int b=0;b<matriz.get(0).size();b++){        
                mostrarFP=mostrarFP+matriz.get(a).get(b)+"\t";
            }
            mostrarFP=mostrarFP+"\n";
        }
        System.out.println("mostrarFP "+mostrarFP);
    }

    public void simularError(String fila, String errorSimulado) {
        int error = Integer.valueOf(errorSimulado);
        mensaje = "";
        for (int i = 0; i < fila.length(); i++) {
            if (i == error) {
                if (fila.charAt(i) == '0') {
                    mensaje = mensaje + "1";
                } else {
                    mensaje = mensaje + "0";
                }
            } else {
                mensaje = mensaje + fila.charAt(i);
            }
        }
    }
}
