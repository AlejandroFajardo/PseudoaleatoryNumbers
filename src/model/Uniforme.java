package model;

import java.util.ArrayList;
import java.util.List;
import test.Utils;

public class Uniforme {

    private List<String> list;
    private List<Double> list2;
    private List<String> list3;
    private List<Double> ri;
    private List<Double> ni;
    private Utils utils;

    public Uniforme() {
        this.utils = new Utils();
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        ri = new ArrayList<>();
        ni = new ArrayList<>();
    }

    public void generar(int iterations, int a, int b) {
        int x = 1;
        double aux = 0;
        double aux2 = 0;
        while (x <= iterations) {
            aux = (double) Math.random();
            aux2 = a + (b - a) * aux;
            list.add(aux + "-" + aux2);
            list2.add(aux2);
            x++;
        }
        this.cutListNi();
        this.cutListRi();
    }

    public void chi2() {
        double max = this.list2.get(0);
        double min = this.list2.get(0);
        for (int i = 0; i < list2.size(); i++) {
            if (this.list2.get(i) > max) {
                max = this.list2.get(i);
            }
            if (this.list2.get(i) < min) {
                min = this.list2.get(i);
            }
        }
        int x = 1;
        double inicial = min;
        double finals = (min + (max - min) / 8);
        float fresperada = (float) 15 / 7;
        float frobtenida = Float.parseFloat(String.valueOf(this.utils.getChi().get(x)));
        float chi = (float) Math.pow((frobtenida - fresperada), 2) / fresperada;
        list3.add(x + "-" + inicial + "-" + finals + "-" + frobtenida + "-" + fresperada + "-" + chi);
        while (x <= 7) {
            inicial = finals;
            finals = (double) (inicial + (max - min) / 8);
            list3.add(x + "-" + inicial + "-" + finals + "-" + frobtenida + "-" + fresperada + "-" + chi);
            x++;
        }
    }

    private void cutListRi() {
        String[] x = null;
        for (int i = 0; i < list.size(); i++) {
            x = this.list.get(i).split("-");
            this.ri.add(Double.valueOf(x[0]));
        }
    }

    private void cutListNi() {
        String[] x = null;
        for (int i = 0; i < list.size(); i++) {
            x = this.list.get(i).split("-");
            this.ni.add(Double.valueOf(x[1]));
        }
    }

    public List<String> getList() {
        return list;
    }

    public List<String> getList3() {
        return list3;
    }

    public List<Double> getRi() {
        return ri;
    }

    public List<Double> getNi() {
        return ni;
    }
}
