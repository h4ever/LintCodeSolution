package solutions.top100liked;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<String>();
        if(digits.isEmpty()) return res;
        String[] d2l = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res.add("");
        for(int i=0;i<digits.length();i++){
            String ds = d2l[Character.getNumericValue(digits.charAt(i))];
            while(res.peek().length()==i){
                String o = res.remove();
                for(int j=0;j<ds.length();j++){
                    res.add(o+ds.charAt(j));
                }
            }
        }
        return res;
    }
}
