package solutions.binarysearch;

public class ArrangingCoins441 {
    public static int arrangeCoins(int n) {
        long l = 0, r = n;
        while (l < r) {
            long m = (l + r +1) / 2;
            if ((1 + m) * m /2 <= n) l = m;
            else r = m-1;
        }
        return (int) l;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(11));
    }
}
