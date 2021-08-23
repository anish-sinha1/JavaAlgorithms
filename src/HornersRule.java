
//This algorithm is faster than the naive polynomial evaluation algorithm but the test polynomials are too small to be able to tell
import java.util.ArrayList;

public class HornersRule {
    public static void main(String[] args) {
        int x = 3;
        double[] poly = { -1, 2, -6, 2 };
        int n = poly.length;
        ArrayList<Double> times = new ArrayList<Double>();
        for (int i = 0; i < 1000; i++) {
            double startTime = System.currentTimeMillis();
            horner(poly, n, x);
            double endTime = System.currentTimeMillis();
            times.add(endTime - startTime);
        }
        Double averageTime = times.stream().mapToDouble(d -> d).average().orElse(0.0);
        System.out.println("Average time: " + averageTime);
    }

    // Polynomial evaluation
    public static double horner(double poly[], int n, int x) {
        double result = 0;
        for (int i = poly.length; i > 0; i--)
            result = poly[i - 1] + result * x;
        return result;
    }
}