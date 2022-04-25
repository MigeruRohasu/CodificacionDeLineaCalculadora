package codificacionfuente;

import java.util.*;
public class OrdenFila {

    private Vector<Integer> VectorACambiar0 = new Vector<Integer>();
    private Vector<String> VectorACambiar1 = new Vector<String>();

    public void setFila(Vector<Integer> IngresoLetras, Vector<Integer> IngresoNumeros) {

        Vector<String> BinLetras = new Vector<String>();
        ArrayList<Vector<Integer>> fila = new ArrayList<Vector<Integer>>();
        int derecha[] = {0, 0};
        int total = 0;
        int izquierda[] = {0, 0};
        String memori;

        total = 0;
        izquierda[0] = 0;
        derecha[0] = 0;
        System.out.println();
        System.out.println();
        System.out.println();
        for (int i = 0; i <= (IngresoLetras.size() - 1); i++) {
            total = total + IngresoNumeros.elementAt(i);
        }

        for (int i = 0; i <= (IngresoLetras.size() - 1); i++) {
            izquierda[0] = izquierda[0] + IngresoNumeros.elementAt(i);

            if (izquierda[0] > (total / 2) && i > 0) {
                izquierda[0] = izquierda[0] - IngresoNumeros.elementAt(i);
                izquierda[1] = i - 1;
                break;
            } else if (izquierda[0] > (total / 2) && i == 0) {
                izquierda[0] = izquierda[0] - IngresoNumeros.elementAt(i);
                izquierda[1] = 0;
            }
        }

        for (int i = (IngresoLetras.size() - 1); i >= 0; i--) {
            derecha[0] = derecha[0] + IngresoNumeros.elementAt(i);

            if (derecha[0] > (total / 2) && i < (IngresoLetras.size() - 1)) {
                derecha[0] = derecha[0] - IngresoNumeros.elementAt(i);
                derecha[1] = i + 1;
                break;
            } else if (derecha[0] > (total / 2) && i == (IngresoLetras.size() - 1)) {
                derecha[0] = derecha[0] - IngresoNumeros.elementAt(i);
                derecha[1] = 0;
            }
        }

        //System.out.println("total= " + total + "\n" + "derecha= " + derecha[0] + " " + derecha[1] + "\n" + "izquierda= " + izquierda[0] + " " + izquierda[1]);

//llena fila
        if (derecha[0] > izquierda[0]) {
            System.out.println("tome derecha");

            //System.out.println("entreeeeeee  "+fila.get(ii).elementAt(1)+" "+fila.get(ii).elementAt(0));
            if ((IngresoLetras.size() - 1) - 0 > 1) {
                izquierda[1] = izquierda[1] + 1;
            }
            for (int i = 0; i <= (derecha[1] - 1); i++) {
                memori = "0";
                BinLetras.add(memori);
            }
            for (int i = derecha[1]; i <= (IngresoLetras.size() - 1); i++) {
                memori = "1";
                BinLetras.add(memori);
            }
        }
        if (derecha[0] < izquierda[0] || derecha[0] == izquierda[0]) {
            System.out.println("tome izquierda");

            if (((IngresoLetras.size() - 1) - 0) > 1) {
                derecha[1] = derecha[1] - 1;

            }

            for (int i = 0; i <= izquierda[1]; i++) {
                memori = "0";
                BinLetras.add(memori);
            }
            for (int i = izquierda[1] + 1; i <= (IngresoLetras.size() - 1); i++) {
                memori = "1";
                BinLetras.add(memori);
            }
        }
        //System.out.println("total= " + total + "\n" + "derecha= " + derecha[0] + " " + derecha[1] + "\n" + "izquierda= " + izquierda[0] + " " + izquierda[1]);
        //System.out.println(IngresoLetras + "\n" + IngresoNumeros + "\n" + BinLetras);;

        Vector<Integer> memo1 = new Vector<Integer>();
        if (0 < izquierda[1]) {
            Vector<Integer> memo3 = new Vector<Integer>();
            memo3.addElement(0);
            memo3.addElement(izquierda[1]);
            fila.add(memo3);
        }
        memo1.clear();
        //System.out.println("voy a operar "+fila.get(ii).elementAt(1)+"-"+ derecha[1]+">"+1);
        if ((IngresoLetras.size() - 1) > derecha[1]) {
            Vector<Integer> memo4 = new Vector<Integer>();
            memo4.clear();
            memo4.addElement(derecha[1]);
            memo4.addElement((IngresoLetras.size() - 1));
            fila.add(memo4);
        }


        for (int ii = 0; ii < fila.size(); ii++) {
            total = 0;
            izquierda[0] = 0;
            derecha[0] = 0;
            System.out.println();
            System.out.println();
            System.out.println();
            //System.out.println("toca realizar " + ii);
            for (int i = fila.get(ii).elementAt(0); i <= fila.get(ii).elementAt(1); i++) {
                total = total + IngresoNumeros.elementAt(i);
            }

            for (int i = fila.get(ii).elementAt(0); i <= fila.get(ii).elementAt(1); i++) {
                izquierda[0] = izquierda[0] + IngresoNumeros.elementAt(i);

                if (izquierda[0] > (total / 2) && i > fila.get(ii).elementAt(0)) {
                    izquierda[0] = izquierda[0] - IngresoNumeros.elementAt(i);
                    izquierda[1] = i - 1;
                    break;
                } else if (izquierda[0] > (total / 2) && i == fila.get(ii).elementAt(0)) {
                    izquierda[0] = izquierda[0] - IngresoNumeros.elementAt(i);
                    izquierda[1] = fila.get(ii).elementAt(0);
                }
            }

            for (int i = fila.get(ii).elementAt(1); i >= fila.get(ii).elementAt(0); i--) {
                derecha[0] = derecha[0] + IngresoNumeros.elementAt(i);

                if (derecha[0] > (total / 2) && i < fila.get(ii).elementAt(1)) {
                    derecha[0] = derecha[0] - IngresoNumeros.elementAt(i);
                    derecha[1] = i + 1;
                    break;
                } else if (derecha[0] > (total / 2) && i == fila.get(ii).elementAt(1)) {
                    derecha[0] = derecha[0] - IngresoNumeros.elementAt(i);
                    derecha[1] = fila.get(ii).elementAt(0);
                }
            }

            //System.out.println("total= " + total + "\n" + "derecha= " + derecha[0] + " " + derecha[1] + "\n" + "izquierda= " + izquierda[0] + " " + izquierda[1]);

//llena fila
            if (derecha[0] > izquierda[0]) {
                System.out.println("tome derecha");

                //System.out.println("entreeeeeee  "+fila.get(ii).elementAt(1)+" "+fila.get(ii).elementAt(0));
                //System.out.println("comparararrrrrrr   " + derecha[1] + "   " + izquierda[1]);
                if ((fila.get(ii).elementAt(1) - fila.get(ii).elementAt(0)) > 1 && derecha[1] != (izquierda[1] + 1)) {
                    izquierda[1] = izquierda[1] + 1;
                    //System.out.println("                                   1      entreeeeeeeeeeeeeeeeeeeeeeee");
                }
                //System.out.println("comparararrrrrrr   " + derecha[1] + "   " + izquierda[1]);
                for (int i = fila.get(ii).elementAt(0); i <= (derecha[1] - 1); i++) {
                    memori = BinLetras.elementAt(i) + "0";
                    BinLetras.setElementAt(memori, i);
                }
                for (int i = derecha[1]; i <= fila.get(ii).elementAt(1); i++) {
                    memori = BinLetras.elementAt(i) + "1";
                    BinLetras.setElementAt(memori, i);
                }
            }
            if (derecha[0] < izquierda[0] || derecha[0] == izquierda[0]) {
                //System.out.println("tome izquierda");

                //System.out.println("comparararrrrrrr   " + derecha[1] + "   " + izquierda[1]);
                if ((fila.get(ii).elementAt(1) - fila.get(ii).elementAt(0)) > 1 && derecha[1] - 1 != izquierda[1]) {
                    derecha[1] = derecha[1] - 1;
                    //System.out.println("                                    2     entreeeeeeeeeeeeeeeeeeeeeeee");
                }
                //System.out.println("comparararrrrrrr   " + derecha[1] + "   " + izquierda[1]);
                for (int i = fila.get(ii).elementAt(0); i <= izquierda[1]; i++) {
                    memori = BinLetras.elementAt(i) + "0";
                    BinLetras.setElementAt(memori, i);
                }
                for (int i = izquierda[1] + 1; i <= fila.get(ii).elementAt(1); i++) {
                    memori = BinLetras.elementAt(i) + "1";
                    BinLetras.setElementAt(memori, i);
                }
            }
            //System.out.println(IngresoLetras + "\n" + IngresoNumeros + "\n" + BinLetras);;

            //Vector<Integer> memo1 = new Vector<Integer>();
            if (fila.get(ii).elementAt(0) < izquierda[1]) {
                Vector<Integer> memo3 = new Vector<Integer>();
                memo3.addElement(fila.get(ii).elementAt(0));
                memo3.addElement(izquierda[1]);
                fila.add(memo3);
            }
            memo1.clear();

            if (fila.get(ii).elementAt(1) > derecha[1]) {
                Vector<Integer> memo4 = new Vector<Integer>();
                memo4.clear();
                memo4.addElement(derecha[1]);
                memo4.addElement(fila.get(ii).elementAt(1));
                fila.add(memo4);
            }

            //System.out.println("Vector por realizar \n" + fila);

        }

        VectorACambiar0.clear();
        VectorACambiar1.clear();
        VectorACambiar0.addAll(IngresoLetras);
        VectorACambiar1.addAll(BinLetras);

        

    }

    public Vector<Integer> getVectorACambiar0() {
        return VectorACambiar0;
    }

    public Vector<String> getVectorACambiar1() {
        return VectorACambiar1;
    }
}
