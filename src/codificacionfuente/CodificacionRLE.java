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
public class CodificacionRLE {


//hola perro

    ArrayList<ArrayList<Integer>> matriz = new ArrayList<ArrayList<Integer>>();
    private String MostrarMatriz = "";
    private String codificacionVertical= "";
    private String MostrarcodificacionVertical = "";
    private String tasaDeComprecionVertical= "";
    private String codificacionHorizontal= "";
    private String MostrarcodificacionHorizontal = "";
    private String tasaDeComprecionHorizontal= "";
    private String codificacionZigzag= "";
    private String MostrarcodificacionZigzag = "";
    private String tasaDeComprecionZigzag= "";
    private String tamañoMatriz = "35x35";

public void clear(){
    MostrarMatriz = "";
    MostrarcodificacionHorizontal = "";
    MostrarcodificacionZigzag = "";
    MostrarcodificacionVertical = "";
    codificacionVertical = "";
    tasaDeComprecionVertical = "";
    codificacionHorizontal = "";
    tasaDeComprecionHorizontal = "";
    codificacionZigzag = "";
    tasaDeComprecionZigzag = "";
    tamañoMatriz = "35x35";
    matriz.clear();
}

    public void Inniciar() {
        System.out.println("recorrerVertical \t" + recorrerVertical());
        setCodificacionVertical(codificacion(contarRepeticiones(recorrerVertical()), "v"));
        setTasaDeComprecionVertical(tasaDeComprecion(recorrerVertical(), getCodificacionVertical()));
        System.out.println("recorrerHorizontal \t" + recorrerHorizontal());
        setCodificacionHorizontal(codificacion(contarRepeticiones(recorrerHorizontal()), "h"));
        setTasaDeComprecionHorizontal(tasaDeComprecion(recorrerHorizontal(), getCodificacionHorizontal()));
        String[] parts = tamañoMatriz.split("x");
        int filas = Integer.valueOf(parts[0]);
        if (filas > 2) {
            System.out.println("recorrerZigzag \t \t" + recorrerZigzag());
            setCodificacionZigzag(codificacion(contarRepeticiones(recorrerZigzag()), "z"));
            setTasaDeComprecionZigzag(tasaDeComprecion(recorrerZigzag(), getCodificacionZigzag()));
        }
}

    public void insertarMatriz(String fila) {
        String[] parts = tamañoMatriz.split("x");
        int filas = Integer.valueOf(parts[0]);
        int columnas = Integer.valueOf(parts[1]);

        int count = 0;
        for (int a = 0; a < filas; a++) {
            ArrayList<Integer> n = new ArrayList<Integer>();
            for (int b = 0; b < columnas; b++) {
//                Random random = new Random();
//                int value = random.nextInt((max + 1) + min) + min;
//                n.add(value);
//                System.out.print((value) + " ");
                //System.out.println("fila.charAt(count) "+fila);
                MostrarMatriz=getMostrarMatriz()+"  "+fila.charAt(count);
                n.add(Integer.valueOf(String.valueOf(fila.charAt(count))));
                System.out.print(Integer.valueOf(String.valueOf(fila.charAt(count))) + " ");
                count++;
            }
            System.out.println();
            MostrarMatriz=getMostrarMatriz()+"\n";
            matriz.add(n);
        }
    }

    public void crearMatriz() {
        String[] parts = tamañoMatriz.split("x");
        int filas = Integer.valueOf(parts[0]);
        int columnas = Integer.valueOf(parts[1]);
        int max = 1;
        int min = 0;

        System.out.println("Matriz Creada Aleatoria de " + filas + "x" + columnas);
        int total = filas * columnas;
        String total1 = "";
        String cambio = "0";
        while (total1.length() - 1 <= total) {
            Random random = new Random();
            int rand = random.nextInt((17 + 1) + 7) + 7;
            if (cambio == "0") {
                int count = 0;
                while (count <= rand) {
                    total1 = total1 + "0";
                    count++;
                }
                cambio = "1";
            } else {
                int count = 0;
                while (count <= rand) {
                    total1 = total1 + "1";
                    count++;
                }
                cambio = "0";
            }
        }

        total1 = total1.substring(0, total);

        int count = 0;
        for (int a = 0; a < filas; a++) {
            ArrayList<Integer> n = new ArrayList<Integer>();
            for (int b = 0; b < columnas; b++) {
//                Random random = new Random();
//                int value = random.nextInt((max + 1) + min) + min;
//                n.add(value);
//                System.out.print((value) + " ");
                MostrarMatriz=getMostrarMatriz()+"  "+total1.charAt(count);
                n.add(Integer.valueOf(String.valueOf(total1.charAt(count))));
                System.out.print(Integer.valueOf(String.valueOf(total1.charAt(count))) + " ");
                count++;
            }
            MostrarMatriz=getMostrarMatriz()+"\n";
            System.out.println();
            matriz.add(n);
        }
    }

    private String recorrerHorizontal() {
        String tramaHorizontal = "";

        for (int a = 0; a < matriz.size(); a++) {
            ArrayList<Integer> n = new ArrayList<Integer>();
            for (int b = 0; b < matriz.get(0).size(); b++) {
                tramaHorizontal = tramaHorizontal + String.valueOf(matriz.get(a).get(b));
            }
        }
        return tramaHorizontal;
    }

    private String recorrerVertical() {
        String tramaVertical = "";
        for (int b = 0; b < matriz.get(0).size(); b++) {
            for (int a = 0; a < matriz.size(); a++) {
                ArrayList<Integer> n = new ArrayList<Integer>();

                tramaVertical = tramaVertical + String.valueOf(matriz.get(a).get(b));
            }
        }
        return tramaVertical;
    }

    private String recorrerZigzag() {
        String tramaZigzag = "";
        int y = 0;
        int x = 0;
        //System.out.println(matriz.get(y).get(x) +"  ("+x+" "+y+")");
        tramaZigzag = tramaZigzag + String.valueOf(matriz.get(y).get(x));
        while (y != matriz.size() - 1 || x != matriz.get(0).size() - 1) {

            //se mueve 1 vez
            if (y == 0 && x == matriz.get(0).size() - 1) {
                y++;
            } else if (x == 0 && y == matriz.size() - 1) {
                x++;
            } else if (y == 0 || y == matriz.size() - 1) {
                x++;
            } else if (x == 0 || x == matriz.get(0).size() - 1) {
                y++;
            }
            //System.out.println(matriz.get(y).get(x) +"  ("+x+" "+y+")");
            tramaZigzag = tramaZigzag + String.valueOf(matriz.get(y).get(x));

            //se mueve en diagonal abajo a la izquierda
            while (y < matriz.size() - 1 && x > 0) {
                x--;
                y++;
                //System.out.println(matriz.get(y).get(x) +"  ("+x+" "+y+")");
                tramaZigzag = tramaZigzag + String.valueOf(matriz.get(y).get(x));
            }

            //se mueve 1 vez
            if (y == 0 && x == matriz.get(0).size() - 1) {
                y++;
            } else if (x == 0 && y == matriz.size() - 1) {
                x++;
            } else if (y == 0 || y == matriz.size() - 1) {
                x++;
            } else if (x == 0 || x == matriz.get(0).size() - 1) {
                y++;
            }
            //System.out.println(matriz.get(y).get(x) +"  ("+x+" "+y+")");
            tramaZigzag = tramaZigzag + String.valueOf(matriz.get(y).get(x));

            //se mueve en diagonal arriba a la derecha
            while (x < matriz.get(0).size() - 1 && y > 0) {
                x++;
                y--;
                //System.out.println(matriz.get(y).get(x) +"  ("+x+" "+y+")");
                tramaZigzag = tramaZigzag + String.valueOf(matriz.get(y).get(x));
            }
        }
        return tramaZigzag;
    }

    private ArrayList<ArrayList<String>> contarRepeticiones(String mensaje) {
        ArrayList<ArrayList<String>> codificacion = new ArrayList<ArrayList<String>>();
        //System.out.println("MESNAJE \t \t" + mensaje);
        mensaje = mensaje + " ";
        int count = 0;
        char comp = mensaje.charAt(0);
        for (int i = 0; i < mensaje.length(); i++) {
            //System.out.println("comp == mensaje.charAt(i)  "+comp+"  "+mensaje.charAt(i));
            if (comp == mensaje.charAt(i)) {
                count++;
            } else {
                ArrayList<String> n = new ArrayList<String>();
                n.add(String.valueOf(comp));
                n.add(String.valueOf(count));
                codificacion.add(n);
                count = 1;
                comp = mensaje.charAt(i);
            }
        }
        System.out.println("codificacion \t" + codificacion);
        return codificacion;
    }

    private String codificacion(ArrayList<ArrayList<String>> mensaje,String tipo) {
        int numMayor = 0;
        String res = "";
        for (int i = 0; i < mensaje.size(); i++) {
            if (Integer.valueOf(mensaje.get(i).get(1)) > numMayor) {
                numMayor = Integer.valueOf(mensaje.get(i).get(1));
            }
        }
        Integer.toBinaryString(numMayor);
        for (int i = 0; i < mensaje.size(); i++) {
            res = res + mensaje.get(i).get(0);
            if (tipo == "z") {
                MostrarcodificacionZigzag =   MostrarcodificacionZigzag +"  "+ mensaje.get(i).get(0)+"  ";
            }
            if (tipo == "h") {
                MostrarcodificacionHorizontal = MostrarcodificacionHorizontal +"  "+ mensaje.get(i).get(0)+"  ";
            }
            if (tipo == "v") {
                MostrarcodificacionVertical = MostrarcodificacionVertical +"  "+ mensaje.get(i).get(0) +"  ";
            }
            String bin = Integer.toBinaryString(Integer.valueOf(mensaje.get(i).get(1)));
            while (bin.length() < Integer.toBinaryString(numMayor).length()) {
                bin = "0" + bin;
            }
            res = res + bin;
            if (tipo == "z") {
                MostrarcodificacionZigzag = MostrarcodificacionZigzag + bin + "\n";
            }
            if (tipo == "h") {
                MostrarcodificacionHorizontal = MostrarcodificacionHorizontal + bin + "\n";
            }
            if (tipo == "v") {
                MostrarcodificacionVertical = MostrarcodificacionVertical + bin + "\n";
            }
        }
        System.out.println("res  " + res);
        return res;
    }

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
     * @return the codificacionVertical
     */
    public String getCodificacionVertical() {
        return codificacionVertical;
    }

    /**
     * @param codificacionVertical the codificacionVertical to set
     */
    public void setCodificacionVertical(String codificacionVertical) {
        this.codificacionVertical = codificacionVertical;
    }

    /**
     * @return the tasaDeComprecionVertical
     */
    public String getTasaDeComprecionVertical() {
        return tasaDeComprecionVertical;
    }

    /**
     * @param tasaDeComprecionVertical the tasaDeComprecionVertical to set
     */
    public void setTasaDeComprecionVertical(String tasaDeComprecionVertical) {
        this.tasaDeComprecionVertical = tasaDeComprecionVertical;
    }

    /**
     * @return the codificacionHorizontal
     */
    public String getCodificacionHorizontal() {
        return codificacionHorizontal;
    }

    /**
     * @param codificacionHorizontal the codificacionHorizontal to set
     */
    public void setCodificacionHorizontal(String codificacionHorizontal) {
        this.codificacionHorizontal = codificacionHorizontal;
    }

    /**
     * @return the tasaDeComprecionHorizontal
     */
    public String getTasaDeComprecionHorizontal() {
        return tasaDeComprecionHorizontal;
    }

    /**
     * @param tasaDeComprecionHorizontal the tasaDeComprecionHorizontal to set
     */
    public void setTasaDeComprecionHorizontal(String tasaDeComprecionHorizontal) {
        this.tasaDeComprecionHorizontal = tasaDeComprecionHorizontal;
    }

    /**
     * @return the codificacionZigzag
     */
    public String getCodificacionZigzag() {
        return codificacionZigzag;
    }

    /**
     * @param codificacionZigzag the codificacionZigzag to set
     */
    public void setCodificacionZigzag(String codificacionZigzag) {
        this.codificacionZigzag = codificacionZigzag;
    }

    /**
     * @return the tasaDeComprecionZigzag
     */
    public String getTasaDeComprecionZigzag() {
        return tasaDeComprecionZigzag;
    }

    /**
     * @param tasaDeComprecionZigzag the tasaDeComprecionZigzag to set
     */
    public void setTasaDeComprecionZigzag(String tasaDeComprecionZigzag) {
        this.tasaDeComprecionZigzag = tasaDeComprecionZigzag;
    }

    /**
     * @param tamañoMatriz the tamañoMatriz to set
     */
    public void setTamañoMatriz(String tamañoMatriz) {
        this.tamañoMatriz = tamañoMatriz;
    }

    /**
     * @return the MostrarMatriz
     */
    public String getMostrarMatriz() {
        return MostrarMatriz;
    }

    /**
     * @return the MostrarcodificacionVertical
     */
    public String getMostrarcodificacionVertical() {
        return MostrarcodificacionVertical;
    }

    /**
     * @return the MostrarcodificacionHorizontal
     */
    public String getMostrarcodificacionHorizontal() {
        return MostrarcodificacionHorizontal;
    }

    /**
     * @return the MostrarcodificacionZigzag
     */
    public String getMostrarcodificacionZigzag() {
        return MostrarcodificacionZigzag;
    }
}
