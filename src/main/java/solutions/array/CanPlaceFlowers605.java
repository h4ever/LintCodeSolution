package solutions.array;

public class CanPlaceFlowers605 {
    /*
    Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int runSum = 0;
        int p=0;
        while(p<flowerbed.length){
            if(flowerbed[p]==1){
                p+=2;continue;
            }
            if(p==0){
                if(flowerbed[1]==0){
                    runSum++;
                    p+=2;
                }else{
                    p++;
                }
            }else if(p==flowerbed.length-1){
                if(flowerbed[flowerbed.length-2]==0) {
                    runSum++;
                }
                p++;
            }else if(flowerbed[p-1]==0&&flowerbed[p+1]==0){
                runSum++;p+=2;
            }else{
                p++;
            }
            if(runSum==n) return true;
        }
        return false;
    }

    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {
                //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0.
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if(next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        return count == n;
    }
}
