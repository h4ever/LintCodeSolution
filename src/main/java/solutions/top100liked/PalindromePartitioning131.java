package solutions.top100liked;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partition(res,new ArrayList<>(),s);
        return res;
    }

    private void partition(List<List<String>> res,List<String> palindromes, String s){
        if(s==null||s.length()==0){
            res.add(new ArrayList<>(palindromes));
        }
        for(int i=1;i<=s.length();i++){
            if(!isPalindrome(s.substring(0,i))) continue;
            palindromes.add(s.substring(0,i));
            partition(res,palindromes,s.substring(i));
            palindromes.remove(palindromes.size()-1);
        }
    }

    private static boolean isPalindrome(String s){
        if(s==null||s.length()==0) return false;
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }else{
                l++;
                r--;
            }
        }
        return true;
    }

}
