package solutions.carl.string;

import java.util.ArrayList;
import java.util.List;

public class MultiFactors {
    public static List<int[]> getMultiFactors(int a) {
        List<int[]> factors = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                factors.add(new int[]{i, a / i});
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        int a = 1440;
        List<int[]> factors = getMultiFactors(a);
        System.out.println("Factors of " + a + ":");
        for (int[] factor : factors) {
            System.out.println(factor[0] + " * " + factor[1] + " = " + a);
        }
    }
}
