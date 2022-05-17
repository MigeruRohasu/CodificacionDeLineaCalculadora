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

    protected ArrayList<ArrayList<Integer>> matriz = new ArrayList<ArrayList<Integer>>();
    protected String MostrarMatriz = "";
    protected String codificacionVertical = "";
    protected String MostrarcodificacionVertical = "";
    protected String tasaDeComprecionVertical = "";
    protected String codificacionHorizontal = "";
    protected String MostrarcodificacionHorizontal = "";
    protected String tasaDeComprecionHorizontal = "";
    protected String codificacionZigzag = "";
    protected String MostrarcodificacionZigzag = "";
    protected String tasaDeComprecionZigzag = "";
    protected String tamañoMatriz = "35x35";

    private String MostrarBitBandera = "";
    private String MostrarByteBandera = "";
    private String MostrarByteAnticipado = "";

    public void clear() {
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
        MostrarBitBandera = "";
        getMatriz().clear();
        MostrarByteBandera = "";
        MostrarByteAnticipado = "";
    }

    public void IniciarV1() {
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

    public void IniciarV2(String tipo) {
        String[] parts = tamañoMatriz.split("x");
        int filas = Integer.valueOf(parts[0]);
        if (tipo == "z") {
            if (filas > 2) {
                System.out.println("recorrerZigzag \t \t" + recorrerZigzag());
                bitBandera(contarRepeticiones(recorrerZigzag()));
                byteBandera(contarRepeticiones(recorrerZigzag()));
                byteAnticipado(contarRepeticiones(recorrerZigzag()));
            }
        } else if (tipo == "h") {
                System.out.println("recorrerHorizontal \t" + recorrerHorizontal());
                bitBandera(contarRepeticiones(recorrerHorizontal()));
                byteBandera(contarRepeticiones(recorrerHorizontal()));
                byteAnticipado(contarRepeticiones(recorrerHorizontal()));
        } else if (tipo == "v") {
                System.out.println("recorrerVertical \t \t" + recorrerVertical());
                bitBandera(contarRepeticiones(recorrerVertical()));
                byteBandera(contarRepeticiones(recorrerVertical()));
                byteAnticipado(contarRepeticiones(recorrerVertical()));
        }

    }

    public void IniciarV3(String fila) {
        
        int columnas= fila.length();
        ArrayList<Integer> n = new ArrayList<Integer>();
        for (int i = 0; i < fila.length(); i++) {
                        n.add(Integer.valueOf(String.valueOf(fila.charAt(i))));
        }
        matriz.add(n);
        System.out.println("recorrerHorizontal \t" + recorrerHorizontal());
        setCodificacionHorizontal(codificacion(contarRepeticiones(recorrerHorizontal()), "h"));
        setTasaDeComprecionHorizontal(tasaDeComprecion(recorrerHorizontal(), getCodificacionHorizontal()));
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
        int max = 17;
        int min = 7;
        Random random = new Random();

        System.out.println("Matriz Creada Aleatoria de " + filas + "x" + columnas);
        int total = filas * columnas;
        String total1 = "";
        int count1 = 0;
        while (count1 <= total) {
            int rand1 = random.nextInt((max + 1) + min) + min;
            int rand2 = random.nextInt((100 + 1) + 0) + 0;
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

    protected String recorrerVertical() {
        String tramaVertical = "";
        for (int b = 0; b < getMatriz().get(0).size(); b++) {
            for (int a = 0; a < getMatriz().size(); a++) {
                ArrayList<Integer> n = new ArrayList<Integer>();
                tramaVertical = tramaVertical + String.valueOf(getMatriz().get(a).get(b)) + " ";
            }
        }
        return tramaVertical;
    }

    protected String recorrerZigzag() {
        String tramaZigzag = "";
        int y = 0;
        int x = 0;
        int diagonal = 0;
        tramaZigzag = tramaZigzag + String.valueOf(getMatriz().get(y).get(x)) + " ";
        while (y != getMatriz().size() - 1 || x != getMatriz().get(0).size() - 1) {
//movimientos hacia la derecha o hacia abajo
            if (y == 0 && x == getMatriz().get(0).size() - 1) {
                y++;
            } else if (x == 0 && y == getMatriz().size() - 1) {
                x++;
            } else if (y == 0 || y == getMatriz().size() - 1) {
                x++;
            } else if (x == 0 || x == getMatriz().get(0).size() - 1) {
                y++;
            }
            tramaZigzag = tramaZigzag + String.valueOf(getMatriz().get(y).get(x)) + " ";

//movimientos en diagonal
            if (diagonal == 0) {
                while (y < getMatriz().size() - 1 && x > 0) {
                    x--;
                    y++;
                    tramaZigzag = tramaZigzag + String.valueOf(getMatriz().get(y).get(x)) + " ";
                }
                diagonal = 1;
            } else {
                while (x < getMatriz().get(0).size() - 1 && y > 0) {
                    x++;
                    y--;
                    tramaZigzag = tramaZigzag + String.valueOf(getMatriz().get(y).get(x)) + " ";
                }
                diagonal = 0;
            }

        }
        return tramaZigzag;
    }

    private ArrayList<ArrayList<String>> contarRepeticiones(String mensaje1) {
        ArrayList<ArrayList<String>> countRepeticiones = new ArrayList<ArrayList<String>>();
        mensaje1 = mensaje1 + "x";
        String[] mensaje = mensaje1.split(" ");
        int count = 0;
        String comp = mensaje[0];
        for (int i = 0; i < mensaje.length; i++) {
            if (comp.equals(mensaje[i])) {
                count++;
            } else {
                ArrayList<String> n = new ArrayList<String>();
                n.add(comp);
                n.add(String.valueOf(count));
                countRepeticiones.add(n);
                count = 1;
                comp = mensaje[i];
            }
        }
        System.out.println("codificacion \t" + countRepeticiones);
        return countRepeticiones;
    }

    private String codificacion(ArrayList<ArrayList<String>> mensaje, String tipo) {
        int numMayor = 0;
        String res = "";
        for (int i = 0; i < mensaje.size(); i++) {
            if (Integer.valueOf(mensaje.get(i).get(1)) > numMayor) {
                numMayor = Integer.valueOf(mensaje.get(i).get(1));
            }
        }
        for (int i = 0; i < mensaje.size(); i++) {
            res = res + mensaje.get(i).get(0);
            if (tipo == "z") {
                MostrarcodificacionZigzag = MostrarcodificacionZigzag + "  " + mensaje.get(i).get(0) + "  ";
            }
            if (tipo == "h") {
                MostrarcodificacionHorizontal = MostrarcodificacionHorizontal + "  " + mensaje.get(i).get(0) + "  ";
            }
            if (tipo == "v") {
                MostrarcodificacionVertical = MostrarcodificacionVertical + "  " + mensaje.get(i).get(0) + "  ";
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

    private void bitBandera(ArrayList<ArrayList<String>> mensaje) {
        int numMayor = 0;
        for (int i = 0; i < mensaje.size(); i++) {
            if (Integer.valueOf(mensaje.get(i).get(1)) > numMayor) {
                numMayor = Integer.valueOf(mensaje.get(i).get(1));
            }
        }
        for (int i = 0; i < mensaje.size(); i++) {
            if (Integer.valueOf(mensaje.get(i).get(0)) > numMayor) {
                numMayor = Integer.valueOf(mensaje.get(i).get(0));
            }
        }
        String binNumMayor = Integer.toBinaryString(numMayor);
        String bin;
        for (int i = 0; i < mensaje.size(); i++) {
            if ("1" != mensaje.get(i).get(1)) {
                MostrarBitBandera = MostrarBitBandera + "1 ";
                bin = Integer.toBinaryString(Integer.valueOf(mensaje.get(i).get(1)));
                while (bin.length() < binNumMayor.length()) {
                    bin = "0" + bin;
                }
                MostrarBitBandera = MostrarBitBandera + bin;
                MostrarBitBandera = MostrarBitBandera + "\n";
            }
            MostrarBitBandera = MostrarBitBandera + "0 ";
            bin = Integer.toBinaryString(Integer.valueOf(mensaje.get(i).get(0)));
            while (bin.length() < binNumMayor.length()) {
                bin = "0" + bin;
            }
            MostrarBitBandera = MostrarBitBandera + bin;
            MostrarBitBandera = MostrarBitBandera + "\n";
        }
    }

    private void byteBandera(ArrayList<ArrayList<String>> mensaje) {
        int numMayor = 0;
        for (int i = 0; i < mensaje.size(); i++) {
            if (Integer.valueOf(mensaje.get(i).get(1)) > numMayor) {
                numMayor = Integer.valueOf(mensaje.get(i).get(1));
            }
        }
        for (int i = 0; i < mensaje.size(); i++) {
            if (Integer.valueOf(mensaje.get(i).get(0)) > numMayor) {
                numMayor = Integer.valueOf(mensaje.get(i).get(0));
            }
        }
        String binNumMayor = Integer.toBinaryString(numMayor);
        String bin;
        String unos = "1";
        for (int i = 0; i < mensaje.size(); i++) {
            if ("1" != mensaje.get(i).get(1)) {
                while (unos.length() < binNumMayor.length()) {
                    unos = "1" + unos;
                }
                MostrarByteBandera = getMostrarByteBandera() + unos;
                MostrarByteBandera = getMostrarByteBandera() + "\n";
                bin = Integer.toBinaryString(Integer.valueOf(mensaje.get(i).get(1)));
                while (bin.length() < binNumMayor.length()) {
                    bin = "0" + bin;
                }
                MostrarByteBandera = getMostrarByteBandera() + bin;
                MostrarByteBandera = getMostrarByteBandera() + "\n";
            }
            bin = Integer.toBinaryString(Integer.valueOf(mensaje.get(i).get(0)));
            while (bin.length() < binNumMayor.length()) {
                bin = "0" + bin;
            }
            MostrarByteBandera = getMostrarByteBandera() + bin;
            MostrarByteBandera = getMostrarByteBandera() + "\n";
        }
    }

    private void byteAnticipado(ArrayList<ArrayList<String>> mensaje) {
        int numMayor = 0;
        for (int i = 0; i < mensaje.size(); i++) {
            if (Integer.valueOf(mensaje.get(i).get(1)) > numMayor) {
                numMayor = Integer.valueOf(mensaje.get(i).get(1));
            }
        }
        for (int i = 0; i < mensaje.size(); i++) {
            if (Integer.valueOf(mensaje.get(i).get(0)) > numMayor) {
                numMayor = Integer.valueOf(mensaje.get(i).get(0));
            }
        }
        String binNumMayor = Integer.toBinaryString(numMayor);
        String bin = "";
        ArrayList<String> anticipado1 = new ArrayList<String>();
        String anticipado = "";
        for (int i = 0; i < mensaje.size(); i++) {
            if ("1" != mensaje.get(i).get(1)) {
                anticipado = anticipado + "10";

                bin = Integer.toBinaryString(Integer.valueOf(mensaje.get(i).get(1)));
                while (bin.length() < binNumMayor.length()) {
                    bin = "0" + bin;
                }
                anticipado1.add(bin);
                bin = Integer.toBinaryString(Integer.valueOf(mensaje.get(i).get(0)));
                while (bin.length() < binNumMayor.length()) {
                    bin = "0" + bin;
                }
                anticipado1.add(bin);
            } else {
                anticipado = anticipado + "0";
                anticipado1.add(mensaje.get(i).get(0));
            }
        }

        System.out.println("anticipado " + anticipado);
        System.out.println("anticipado1 " + anticipado1);
        while (true) {
            try {
                MostrarByteAnticipado = getMostrarByteAnticipado() + anticipado.substring(0, binNumMayor.length()) + "\n";
                anticipado.substring(binNumMayor.length());
            } catch (Exception e) {
                MostrarByteAnticipado = getMostrarByteAnticipado() + anticipado + "\n";
            }

            try {
                for (int i = 0; i < binNumMayor.length(); i++) {
                    MostrarByteAnticipado = getMostrarByteAnticipado() + anticipado1.get(0) + "\n";
                    anticipado1.remove(0);
                }
                System.out.println("anticipado1 " + anticipado1.size());
            } catch (Exception e) {
                for (int i = 0; i < anticipado1.size(); i++) {
                    MostrarByteAnticipado = getMostrarByteAnticipado() + anticipado1.get(i) + "\n";
                }
                System.out.println("entre1");
                break;
            }
        }
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

    /**
     * @return the MostrarBitBandera
     */
    public String getMostrarBitBandera() {
        return MostrarBitBandera;
    }

    /**
     * @return the MostrarByteBandera
     */
    public String getMostrarByteBandera() {
        return MostrarByteBandera;
    }

    /**
     * @return the MostrarByteAnticipado
     */
    public String getMostrarByteAnticipado() {
        return MostrarByteAnticipado;
    }

    /**
     * @return the matriz
     */
    public ArrayList<ArrayList<Integer>> getMatriz() {
        return matriz;
    }
}
