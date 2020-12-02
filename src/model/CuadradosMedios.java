package model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CuadradosMedios {

    private BigInteger Xi;
    private BigInteger Xi2;
    private short extension;
    private BigInteger extraccion;
    private float Ri;
    private int max;
    private int tam;
    private float Ni;

    private List<String> list;
    private List<Double> ni;
    private List<Double> ri;

    public CuadradosMedios() {
        this.list = new ArrayList<>();
        this.ni = new ArrayList<>();
        this.ri = new ArrayList<>();
    }

    public void metodo(int iter, int a, int b) {
        int s = 1;
        calcMax(Xi);
        while (s <= iter) {
            Xi2 = this.Xi.pow(2);
            String aux = String.valueOf(Xi2);
            extension = (short) aux.length();
            extraccion = extractMedios(aux);
            Ri = Float.valueOf(String.valueOf(extraccion));
            Ri = (float) (Ri / Math.pow(10, tam));
            Ni = a + ((b - a) * this.Ri);
            list.add(s + "-" + Xi + "-" + Xi2 + "-" + extension + "-" + extraccion + "-" + Ri + "-" + Ni);
            Xi = extraccion;
            ni.add((double) Ni);
            ri.add((double) Ri);
            s++;
        }
    }

    private BigInteger extractMedios(String x) {
        StringBuilder num = new StringBuilder(x);
        while (num.length() < max) {
            num.insert(0, "0");
        }
        int start = (num.length() - tam) / 2;
        return new BigInteger(num.substring(start, start + tam));
    }

    private void calcMax(BigInteger x) {
        BigInteger y = x.pow(2);
        max = String.valueOf(y).length();
        tam = String.valueOf(x).length();
    }

    public List<String> getList() {
        return list;
    }

    public BigInteger getXi() {
        return Xi;
    }

    public BigInteger getXi2() {
        return Xi2;
    }

    public short getExtension() {
        return extension;
    }

    public BigInteger getExtraccion() {
        return extraccion;
    }

    public int getMax() {
        return max;
    }

    public int getTam() {
        return tam;
    }

    public List<Double> getNi() {
        return ni;
    }

    public List<Double> getRi() {
        return ri;
    }

    public void setXi(BigInteger Xi) {
        this.Xi = Xi;
    }

}
