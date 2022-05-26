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
public class CodificacionDPCM {

    private ArrayList<ArrayList<Integer>> matriz2 = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> matriz = new ArrayList<ArrayList<Integer>>();
    private String MostrarMatriz = "";
    private String MostrarMatriz2 = "";
    private String tamañoMatriz = "35x35";
    private String tramaBin = "";
    private String codificacion = "";

    public void clear() {
        matriz2.clear();
        matriz.clear();
        MostrarMatriz = "";
        MostrarMatriz2 = "";
        tamañoMatriz = "35x35";
        tramaBin = "";
        codificacion = "";

    }

    public void Iniciar() {

        recorrerHorizontal();
        codificar();
    }

    public void codificar() {
        int a = 0;
        int b = 0;
        String stringMatriz2 = "";
        for (int y = 0; y < getMatriz().size(); y++) {
            ArrayList<Integer> n = new ArrayList<Integer>();
            for (int x = 0; x < getMatriz().get(0).size(); x++) {
                a = b;
                b = getMatriz().get(y).get(x);
                int res;
                res = b - a;
                n.add(res);
                if (res < 0) {
                    res = res * (-1);
                }
                stringMatriz2 = stringMatriz2 + res + " ";
                MostrarMatriz2 = getMostrarMatriz2() + res + "\t";
            }
            MostrarMatriz2 = getMostrarMatriz2() + "\n";
            getMatriz2().add(n);
        }

        String stringMayor[] = stringMatriz2.split(" ");
        int mayor = 0;
        for (int i = 1; i < stringMayor.length; i++) {
            if (Integer.valueOf(stringMayor[i]) > mayor) {
                mayor = Integer.valueOf(stringMayor[i]);
            }
        }
        String binNumMayor = Integer.toBinaryString(mayor);
        for (int y = 0; y < getMatriz2().size(); y++) {
            for (int x = 0; x < getMatriz2().get(0).size(); x++) {
                int z = getMatriz2().get(y).get(x);
                if (getMatriz2().get(y).get(x) < 0) {
                    z = z * (-1);
                }
                String bin = Integer.toBinaryString(z);

                while (bin.length() < binNumMayor.length()) {
                    bin = "0" + bin;
                }

                String bin2 = bin;
                if (getMatriz2().get(y).get(x) < 0) {
                    bin = "1" + bin;
                    bin2 = "1 " + bin2 + "\n";
                } else {
                    bin = "0" + bin;
                    bin2 = "0 " + bin2 + "\n";
                }
                codificacion = getCodificacion() + bin2;
                tramaBin = getTramaBin() + bin;

            }
        }
        //System.out.println("codificacion " + "\n " + getCodificacion());
        codificacion = codificacion.substring(2, codificacion.length());
        tramaBin = tramaBin.substring(1, tramaBin.length());
    }

    public void insertarMatriz(String fila) {
        String[] parts = tamañoMatriz.split("x");
        int filas = Integer.valueOf(parts[0]);
        int columnas = Integer.valueOf(parts[1]);

        int count = 0;
        String[] total2 = fila.split(" ");
        for (int a = 0; a < filas; a++) {
            ArrayList<Integer> n = new ArrayList<Integer>();
            for (int b = 0; b < columnas; b++) {
                MostrarMatriz = getMostrarMatriz() + total2[count] + "\t";
                n.add(Integer.valueOf(total2[count]));
                System.out.print(Integer.valueOf(total2[count]) + " ");
                count++;
            }
            MostrarMatriz = getMostrarMatriz() + "\n";
            System.out.println();
            getMatriz().add(n);
        }
        System.out.println("matriz " + getMatriz());
    }

    public void crearMatriz() {
        String[] parts = tamañoMatriz.split("x");
        int filas = Integer.valueOf(parts[0]);
        int columnas = Integer.valueOf(parts[1]);
        int max = 20;
        int min = 7;

        int max2 = 100;
        int min2 = 50;
        Random random = new Random();
        Random random2 = new Random();

        System.out.println("Matriz Creada Aleatoria de " + filas + "x" + columnas);
        int total = filas * columnas;
        String total1 = "";
        int count1 = 0;
        while (count1 <= total) {
            int rand1 = random.nextInt((max + 1) + min) + min;
            int rand2 = random2.nextInt((max2 + 1) + min2) + min2;
            int count = 0;
            while (count <= rand1) {
                total1 = total1 + String.valueOf(rand2) + " ";
                count++;
                count1++;
            }
        }

        int count = 0;
        String[] total2 = total1.split(" ");
        for (int a = 0; a < filas; a++) {
            ArrayList<Integer> n = new ArrayList<Integer>();
            for (int b = 0; b < columnas; b++) {
                MostrarMatriz = getMostrarMatriz() + total2[count] + "\t";
                n.add(Integer.valueOf(total2[count]));
                System.out.print(Integer.valueOf(total2[count]) + " ");
                count++;
            }
            MostrarMatriz = getMostrarMatriz() + "\n";
            System.out.println();
            getMatriz().add(n);
        }
        System.out.println("matriz " + getMatriz());
    }

    protected String recorrerHorizontal() {
        String tramaHorizontal = "";
        for (int a = 0; a < getMatriz().size(); a++) {
            ArrayList<Integer> n = new ArrayList<Integer>();
            for (int b = 0; b < getMatriz().get(0).size(); b++) {
                tramaHorizontal = tramaHorizontal + String.valueOf(getMatriz().get(a).get(b)) + " ";
            }
        }
        return tramaHorizontal;
    }

// pendeinte de arreglo
    private String tasaDeComprecion(String total, String resultantes) {
        int total1 = (total.length());
        int resultantes1 = (resultantes.length());
        System.out.println("tamaños  " + total.length() + "  " + resultantes.length());
        double res = total.length() - resultantes.length();
        res = res / total.length();
        res = res * 100;
        System.out.println("tasaDeComprecion  " + res);
        return String.valueOf(res);
    }

    /**
     * @return the matriz
     */
    public ArrayList<ArrayList<Integer>> getMatriz() {
        return matriz;
    }

    /**
     * @return the MostrarMatriz
     */
    public String getMostrarMatriz() {
        return MostrarMatriz;
    }

    /**
     * @param tamañoMatriz the tamañoMatriz to set
     */
    public void setTamañoMatriz(String tamañoMatriz) {
        this.tamañoMatriz = tamañoMatriz;
    }

    /**
     * @return the matriz2
     */
    public ArrayList<ArrayList<Integer>> getMatriz2() {
        return matriz2;
    }

    /**
     * @return the tramaBin
     */
    public String getTramaBin() {
        return tramaBin;
    }

    /**
     * @return the codificacion
     */
    public String getCodificacion() {
        return codificacion;
    }

    /**
     * @return the MostrarMatriz2
     */
    public String getMostrarMatriz2() {
        return MostrarMatriz2;
    }
}
