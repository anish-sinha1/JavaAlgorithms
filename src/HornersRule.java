
public class HornersRule {
    public static void main(String[] args) {
        int[] poly = { -1, 2, -6, 2 };
        int x = 3;
        int n = poly.length;
        System.out.printf("The value of the polynomial at x=%d is %d", x, horner(poly, n, x));

    }

    // Polynomial evaluation
    public static int horner(int poly[], int n, int x) {
        int result = 0;
        for (int i = poly.length; i > 0; i--)
            result = poly[i - 1] + result * x;
        return result;
    }
}