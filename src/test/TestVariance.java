package test;

import java.util.ArrayList;
import java.util.List;

public class TestVariance {

    private Utils utils;

    public TestVariance() {
        utils = new Utils();
    }

    public TestVariance(String x) {
        utils = new Utils();
    }

    private double getAverage(List<Double> RiValues) {
        double result = 0;
        for (int i = 0; i < RiValues.size(); i++) {
            result += RiValues.get(i);
        }
        return result / RiValues.size();
    }

    private double getVariance(List<Double> RiValues) {
        double total = 0;
        for (int i = 0; i < RiValues.size(); i++) {
            total += (Math.pow(RiValues.get(i) - getAverage(RiValues), 2));
        }
        return total / (getN(RiValues) - 1);
    }

    void fill(List<Double> RiValues) {
        for (int i = 0; i < 50; i++) {
            RiValues.add(Math.random());
        }
    }

    public double getN(List<Double> RiValues) {
        return RiValues.size();
    }

    public void ver(ArrayList<Double> values) {
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i) + ",");
        }
    }

    public double getChi2Upper(List<Double> RiValues) {
        return utils.getSuperiorInterval().get(RiValues.size() - 1);
    }

    public double getChi2lower(List<Double> RiValues) {
        return utils.getInferiorInterval().get(RiValues.size() - 1);
    }

    public double getSuperiorLimit(List<Double> RiValues) {
        return getChi2Upper(RiValues) / (12 * (RiValues.size() - 1));
    }

    public double getInferiorLimit(List<Double> RiValues) {
        return getChi2lower(RiValues) / (12 * (RiValues.size() - 1));
    }

    public boolean isSatisfactory(List<Double> RiValues) {
        return getSuperiorLimit(RiValues) > getVariance(RiValues) && getInferiorLimit(RiValues) < getVariance(RiValues) ? true : false;
    }
}
