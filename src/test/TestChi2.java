package test;

import java.util.ArrayList;
import java.util.List;

public class TestChi2 {

    private List<Double> NiValues;
    private List<Double> intervals;
    private List<Double> frequency;
    private List<Double> chi2List;
    static double INTERVALS = 8;
    private double expectedFrecuency;
    private Utils utils;

    public TestChi2(List<Double> NiValues) {
        this.NiValues = NiValues;
        this.intervals = new ArrayList<Double>();
        this.frequency = new ArrayList<Double>();
        this.chi2List = new ArrayList<Double>();
        this.expectedFrecuency = this.NiValues.size() / INTERVALS;
        utils = new Utils();
        getInterval(minOfNiValues(NiValues), maxOfNiValues(NiValues));
        setFrecuency(intervals);
        getChi2();
    }

    public TestChi2() {
    }

    public void getInterval(double min, double max) {
        double value = min;
        this.intervals.add(value);
        double minInterval = min;
        double delta = max - min;
        while (minInterval < max) {
            value = minInterval + (delta / INTERVALS);
            this.intervals.add(value);
            minInterval = value;
        }
    }

    public double getFrequency(double min, double max, List<Double> values) {
        double total = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) >= min && values.get(i) < max) {
                total++;
            }
        }
        return total;
    }

    public void setFrecuency(List<Double> values) {
        for (int i = 0, j = 1; j < values.size(); i++, j++) {
            this.frequency.add(this.getFrequency(values.get(i), values.get(j), NiValues));
        }
    }

    public double minOfNiValues(List<Double> values) {
        double min = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) < min) {
                min = values.get(i);
            }
        }
        return min;
    }

    public double maxOfNiValues(List<Double> values) {
        double max = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > max) {
                max = values.get(i);
            }
        }
        return max;
    }

    public void getChi2() {
        for (int i = 0; i < this.frequency.size(); i++) {
            chi2List.add(Math.pow(frequency.get(i) - expectedFrecuency, 2) / expectedFrecuency);
        }
    }

    public double sumar() {
        double total = 0;
        for (int i = 0; i < chi2List.size(); i++) {
            total += chi2List.get(i);
        }
        return total;
    }

    public void ver(List<Double> values) {
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
    }

    public boolean isSatisfactory() {
        return sumar() < getDegreesFreedom() ? true : false;
    }

    public double getDegreesFreedom() {
        return utils.getChi().get(chi2List.size() - 1);
    }

}
