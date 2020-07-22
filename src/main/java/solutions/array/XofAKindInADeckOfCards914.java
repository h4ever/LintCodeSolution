package main.java.solutions.array;

import java.util.HashMap;
import java.util.Map;

public class XofAKindInADeckOfCards914 {
    /*
    In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

    Each group has exactly X cards.
    All the cards in each group have the same integer.
Constraints:

    1 <= deck.length <= 10^4
    0 <= deck[i] < 10^4

     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] bucket = new int[10001];
        for (int card : deck)
            bucket[card]++;

        int X = 0;
        for (int val : bucket)
            if (val!=0){
                X = gcd(X ,val);
            }

        return X>1;
    }

    public boolean hasGroupsSizeX2(int[] deck) {
        Map<Integer,Integer> stat = new HashMap<>();
        for(int a:deck) stat.put(a,stat.getOrDefault(a,0)+1);
        int res = 0;
        for(int a:stat.values()) res = gcd(res,a);
        return res>1;
    }

    public int gcd(int a,int b){
        return b>0?gcd(b,a%b):a;
    }
}
