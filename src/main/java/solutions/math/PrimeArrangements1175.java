package solutions.math;

import java.math.BigInteger;
import java.util.Arrays;

public class PrimeArrangements1175 {
    /*
    Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)

(Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)

Since the answer may be large, return the answer modulo 10^9 + 7.
     */
    static int MOD = 1_000_000_007;

    public int numPrimeArrangements(int n) {
        int noOfPrime = countPrimes(n);
        BigInteger x = factorial(noOfPrime);
        BigInteger y = factorial(n - noOfPrime);
        return x.multiply(y).mod(BigInteger.valueOf(MOD)).intValue();
    }

    //sieve_of_eratosthenes
    public static int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, 2, n + 1, true);
        for (int i = 2; i * i <= n; i++)
            if (prime[i])
                for (int j = i * i; j <= n; j += i)
                    prime[j] = false;
        int cnt = 0;
        for (int i = 0; i < prime.length; i++)
            if (prime[i])
                cnt++;

        return cnt;
    }

    public static BigInteger factorial(int n) {
        BigInteger fac = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac.mod(BigInteger.valueOf(MOD));
    }

}
