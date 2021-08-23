import java.util.ArrayList;

public class NaivePolynomial {
    public static void main(String[] args) {
        double[] poly = { -1, 2, -6, 2 };
        ArrayList<Double> times = new ArrayList<Double>();
        int x = 3;
        for (int i = 0; i < 1000; i++) {
            double startTime = System.currentTimeMillis();
            naivePolynomialEvaluationAlgorithm(poly, x);
            double endTime = System.currentTimeMillis();
            times.add(endTime - startTime);
        }
        Double averageTime = times.stream().mapToDouble(d -> d).average().orElse(0.0);
        System.out.println("Average time: " + averageTime);
    }

    public static double naivePolynomialEvaluationAlgorithm(double[] poly, double x) {
        double result = 0;
        for (int i = 0; i < poly.length; i++) {
            result = result + poly[i] * Math.pow(3, i);
        }
        return result;
    }
}
