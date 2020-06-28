package main.java.solutions.hashtable;

public class BullsAndCows299 {
    /*
    You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.

Please note that both secret number and friend's guess may contain duplicate digits.
     */
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        int len = secret.length(),bulls = 0,cows = 0;
        for(int i=0;i<len;i++){
            if(secret.charAt(i)==guess.charAt(i)) bulls++;
            else{
                if(nums[secret.charAt(i)-'0']<0) cows++;
                if(nums[guess.charAt(i)-'0']>0) cows++;
                nums[secret.charAt(i)-'0'] ++;
                nums[guess.charAt(i)-'0'] --;
            }
        }
        return bulls +"A" + cows + "B";
    }
}
