package model;

import java.util.ArrayList;
import java.util.List;

public class CongruenciaMultiplicativa {

    private int Xi;
    private float Ri;
    private float Ni;
    private float Ri2;
    private float Ni2;

    private List<String> list;
    private List<Double> ni;
    private List<Double> ri;

    public CongruenciaMultiplicativa() {
        this.list = new ArrayList<>();
        this.ni = new ArrayList<>();
        this.ri = new ArrayList<>();
    }

    public void metodo(int iteraciones, int a, int b, int t, int d) {
        int aux = t * 8 + 3;
        int mod = (int) Math.pow(2, d);
        int s = 1;
        while (s <= iteraciones) {
            Xi = (Xi * aux) % mod;
            Ri = (float) Xi / (mod - 1);
            Ri2 = (float) Xi / mod;
            Ni = a + (b - a) * Ri;
            Ni2 = a + (b - a) * Ri2;
            list.add(s + "-" + Xi + "-" + Ri + "-" + Ni + "-" + this.Ri2 + "-" + this.Ni2);
            ni.add((double) Ni);
            ri.add((double) Ri);
            s++;
        }
    }

    public List<Double> getNi() {
        return ni;
    }

    public List<Double> getRi() {
        return ri;
    }

    public int getXi() {
        return Xi;
    }

    public void setXi(int Xi) {
        this.Xi = Xi;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

}
