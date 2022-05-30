package codificacionfuente;

import java.util.*;

public class CodificacionAritmetica {

    /**
     * @return the tramaBin
     */
    public String getTramaBin() {        
        setTramaBin(binarioDecimal(valorCodificar).substring(2));
        return tramaBin;
    }

    /**
     * @param tramaBin the tramaBin to set
     */
    public void setTramaBin(String tramaBin) {
        this.tramaBin = tramaBin;
    }

    //ArrayList<Vector<Double>> probabilidad = new ArrayList<Vector<Double>>();
    public ArrayList<Vector<Double>> linea = new ArrayList<Vector<Double>>();
    private Vector<Double> variablesDecodificar = new Vector<Double>();
    public double valorCodificar;
    public String stringlinea;
    public String stringDecodificar;
    private String tramaBin="";

    public boolean mayorA1=false;

    public String binario;

    public void clean() {
        linea.clear();
        variablesDecodificar.clear();
        valorCodificar = 0;
        stringlinea = "";
        stringDecodificar = "";
    }

    public void addProbabilidad(double ascii, double prob) {
        Vector<Double> letra = new Vector<Double>();
        boolean band = true;
        double redon;
        if (linea.isEmpty()) {
            letra.add(ascii);
            letra.add((double) 0);
            letra.add(prob);
            linea.add(letra);
        } else {
            for (int i = 0; i < linea.size(); i++) {
                if (linea.get(i).elementAt(0) == ascii) {
                    band = false;
                }
            }
            if (band) {
                letra.add(ascii);
                letra.add(linea.get(linea.size() - 1).elementAt(2));
                //letra.add(    (linea.get(linea.size() - 1).elementAt(2) + prob));
                redon = linea.get(linea.size() - 1).elementAt(2) + prob;
                redon = Math.round(redon * 1000000.0) / 1000000.0;
                letra.add(redon);
                linea.add(letra);
            }
        }
        if (linea.get(linea.size() - 1).elementAt(2) > 1) {
            linea.remove(linea.size() - 1);
                mayorA1=true;
            System.out.println("Se borro la letra");
        }
        System.out.println(linea);
    }

    public boolean verificar(String name) {
        for (int i = 0; i < name.length(); i++) {
            for (int ii = 0; ii < linea.size(); ii++) {
                if (linea.get(ii).elementAt(0) != (double) name.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void iniciar(String name) {
        System.out.println("entre a iniciar "+name+linea);
        double aActual = 0;
        double bActual = 1;

        double memo1;
        double memo2;

        double redon;
        System.out.println("linea "+linea);
        for (int j = 0; j < name.length(); j++) {
            for (int i = 0; i < linea.size(); i++) {
                if ((double) name.charAt(j) == linea.get(i).elementAt(0)) {
                    redon = aActual + (bActual - aActual) * linea.get(i).elementAt(1);
                    redon = Math.round(redon * 100000000.0) / 100000000.0;
                    memo1 = redon;

                    redon = aActual + (bActual - aActual) * linea.get(i).elementAt(2);
                    redon = Math.round(redon * 100000000.0) / 100000000.0;
                    memo2 = redon;
                    aActual = memo1;
                    bActual = memo2;
                    //System.out.println("opero  "+(bActual - aActual));
                    System.out.println("Actual " + name.charAt(j) + "=  " + aActual + "  " + bActual + "\n");
                }
            }
        }
        valorCodificar = aActual;
        System.out.println("");
        //decBin(valorCodificar);
    }

    public void decodificar(String name) {
        System.out.println("entre a decodificar");
        int count=0;
        stringDecodificar="Variable Despues de Decodificar\n";
        double a = valorCodificar;
        double aActual = 0;
        double bActual = 1;
        boolean band = true;

        getVariablesDecodificar().clear();
        for (int j =0;j<name.length();j++) {
            for (int i = 0; i < linea.size(); i++) {
                if (linea.get(i).elementAt(1) <= a && linea.get(i).elementAt(2) > a) {
                    aActual = linea.get(i).elementAt(1);
                    bActual = linea.get(i).elementAt(2);
                    getVariablesDecodificar().add(linea.get(i).elementAt(0));
                    double cambio = linea.get(i).elementAt(0);
                    stringDecodificar= stringDecodificar+String.valueOf((char)cambio)+" = ";
                }
            }
            stringDecodificar= stringDecodificar+a+"\n";
            a = (a - aActual) / (bActual - aActual);
            a = Math.round(a * 100000000.0) / 100000000.0;
            
            
            System.out.println(stringDecodificar);
        }
    }

    public Vector<Double> getVariablesDecodificar() {
        return variablesDecodificar;
    }

    public void clearlinea() {
        linea.clear();
    }

    public void addMensaje(String name) {
        int nameLenght = name.length();
        Vector<Integer> VectorAscii = new Vector<Integer>(nameLenght);

        Organizar Organizar = new Organizar();

        for (int i = 0; i < nameLenght; i++) {
            char character = name.charAt(i);
            int ascii = (int) character;
            VectorAscii.addElement(ascii);
            System.out.print(character + "=" + ascii + "   ");
        }
        Organizar.contar(VectorAscii);
        System.out.println("");
        System.out.println("");
        double ascii;
        double prob;
        for (int i = 0; i < Organizar.getVectorCambioLetras().size(); i++) {
            ascii = (double) Organizar.getVectorCambioLetras().elementAt(i);
            prob = (double) Organizar.getVectorCambioCuenta().elementAt(i);
            prob = prob / nameLenght;
            addProbabilidad(ascii, prob);
        }
    }

    public String binarioDecimal(double valor) {
        int bit;
        String binario = "0.";
        while(valor%1 != 0.0){
            valor = valor * 2;
            bit = (int)valor;
            valor = valor - bit;
            binario = binario + String.valueOf(bit);
        }
        return binario;
    }


    public String getStringlinea() {
        stringlinea = "";
        for (int i = 0; i < linea.size(); i++) {
            double a = linea.get(i).elementAt(0);
            char b = (char) a;
            stringlinea = stringlinea + b + " [ " + linea.get(i).elementAt(1) + " , " + linea.get(i).elementAt(2) + " )\n";
        }
        return stringlinea;
    }

    public String getStringlinea1() {
        stringlinea = "";
        for (int i = 0; i < linea.size(); i++) {
            double a = linea.get(i).elementAt(0);
            char b = (char) a;
            stringlinea = stringlinea + b + " [ " + linea.get(i).elementAt(1) + " , " + linea.get(i).elementAt(2) + " )      ";
        }
        return stringlinea;
    }
    public String getStringDecodificar() {
        return stringDecodificar;
    }
}
