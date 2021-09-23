package main.java.solutions.math;

import java.util.ArrayList;
import java.util.List;

public class CombinationAndPrime1666 {
    public static boolean isPrime(int n){
        if(n < 2) return false;
        if(n == 2) return true;
        if(n%2==0) return false;
        for(int i = 3; i*i <= n; i += 2){
            if(n%i == 0) return false;
        }
        return true;
    }
    public static int getWays(int[] a, int k) {
        // Write your code here
        int ans = 0;
        List<List<Integer>> combinations = new ArrayList<>();
        dfs(a,k,0,new ArrayList<>(),combinations);
        System.out.println(combinations);
        for(List<Integer> combination:combinations){
            int sum = combination.stream().mapToInt(Integer::intValue).sum();
            if(isPrime(sum)) ans++;
        }
        return ans;
    }
    public static void dfs(int[]a, int k,int start,List<Integer> combination ,List<List<Integer>> combinations){
        if(0==k){
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for(int i=start;i<a.length-k+1;i++){//a.length-i>=k 待选择的元素个数不能小于目前combination的空位k
            combination.add(a[i]);
            dfs(a,k-1,i+1,combination,combinations);
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] a ={3,6,7,12};
        int k=3;
        System.out.println(getWays(a,k));
    }
    private static String encrypt(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                if(Character.isLowerCase(ch)){
                    if(ch=='z') sb.append('A');
                    else sb.append(Character.toUpperCase(ch +1));
                }else{
                    if(ch=='Z') sb.append('a');
                }
            }
        }
        return sb.toString();
    }

}
