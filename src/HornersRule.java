
public class HornersRule {
    public static void main(String[] args) {
        int[] poly = {2,-6,2,-1};
        int x = 3;
        int n = poly.length;
        System.out.printf("The value of the polynomial at x=%d is %d", x, horner(poly, n, x));
        
    }
    public static int horner(int poly[], int n, int x){
        int result = 0;
        for(int i = 0; i < n; i++) result = result*x+poly[i];
        return result;
    }
}