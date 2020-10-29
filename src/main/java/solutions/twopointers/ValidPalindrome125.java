package main.java.solutions.twopointers;

public class ValidPalindrome125 {
    /*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.
     */
    public boolean isPalindrome(String s) {
        String t = s.toLowerCase();
        int i=0,j=t.length()-1;
        while (i<j){
            if(!Character.isLetterOrDigit(t.charAt(i))){
                i++;continue;
            }
            if(!Character.isLetterOrDigit(t.charAt(j))){
                j--;continue;
            }
            if(t.charAt(i)!=t.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
