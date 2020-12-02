package test;

import java.util.List;

public class TestAverage {

    private static double ALPHA = 0.05;
    private static double Z = 1.96;

    public TestAverage() {
    }

    public double calculateAverage(List<Double> RiValues) {
        double result = 0;
        for (int i = 0; i < RiValues.size(); i++) {
            result += RiValues.get(i);
        }
        return result / RiValues.size();
    }

    public double calculateInverseCumulativeProbability() {
        return 1 - (ALPHA / 2);
    }

    public double calculateInferiorLimit(List<Double> RiValues) {
        return ((double) 1 / 2) - (Z * (1 / Math.sqrt(12 * RiValues.size())));
    }

    public double calculateSuperiorLimit(List<Double> RiValues) {
        return ((double) 1 / 2) + (Z * (1 / Math.sqrt(12 * RiValues.size())));
    }

    public boolean isMeetsCondition(List<Double> RiValues) {
        double ls = calculateSuperiorLimit(RiValues);
        double li = calculateInferiorLimit(RiValues);
        double avg = calculateAverage(RiValues);
        if (avg <= ls && avg >= li) {
            return true;
        }
        return false;
    }
}
