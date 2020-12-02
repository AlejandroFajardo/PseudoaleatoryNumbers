package model;

import java.util.ArrayList;
import java.util.List;

public class CongruenciaLineal {

    private float Ri;
    private float Ni;
    private float Ri2;
    private float Ni2;

    private List<String> list;
    private List<Double> ni;
    private List<Double> ri;

    public CongruenciaLineal() {
        this.list = new ArrayList<>();
        this.ni = new ArrayList<>();
        this.ri = new ArrayList<>();
    }

    public void metodo(int iteraciones, int Xi, int a, int b, int c, int g, int k) {
        int aux = k * 2 + 1;
        int mod = (int) Math.pow(2, g);
        int s = 1;
        while (s <= iteraciones) {
            Xi = (Xi * aux + c) % mod;
            Ri = (float) Xi / (mod - 1);
            Ri2 = (float) Xi / mod;
            Ni = a + (b - a) * Ri;
            Ni2 = a + (b - a) * Ri2;
            list.add(s + "-" + Xi + "-" + Ri + "-" + Ni + "-" + Ri2 + "-" + Ni2);
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

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
