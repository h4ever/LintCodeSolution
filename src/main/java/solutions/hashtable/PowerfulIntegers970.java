package main.java.solutions.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers970 {
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> util = new HashSet<>();
        int xm = x==1?bound:(int)(Math.log(bound)/Math.log(x));
        int ym = y==1?bound:(int)(Math.log(bound)/Math.log(y));
        for(int i=0;i<xm+1;i++){
            for(int j=0;j<ym+1;j++){
                int e = (int)(Math.pow(x,i)+Math.pow(y,j));
                if(e<=bound) util.add(e);
            }
        }

        for(Integer e : util){
            ans.add(e);
        }
        return ans;
    }

    public List<Integer> powerfulIntegers2(int x, int y, int bound) {
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                s.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(s);
    }

    public static void main(String[] args) {
        powerfulIntegers(2,1,10);
    }
}
