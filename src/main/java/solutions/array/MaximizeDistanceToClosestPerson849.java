package main.java.solutions.array;

public class MaximizeDistanceToClosestPerson849 {
    /*
    In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to closest person.
Constraints:

    2 <= seats.length <= 20000
    seats contains only 0s or 1s, at least one 0, and at least one 1.

     */
    public int maxDistToClosest(int[] seats) {
        int cnt0 = 0 ,ans = 0;
        int i = 0 , j = seats.length-1;
        for(;i<seats.length&&seats[i]==0;i++);
        for(;j>=0&&seats[j]==0;j--);
        for(int p = i;p<j;p++){
            if(seats[p]==0){
                cnt0++;
                if(cnt0>ans){
                    ans = cnt0;
                }
            }else{
                cnt0 = 0;
            }
        }
        return Math.max((ans+1)/2,Math.max(i,seats.length-j-1));


    }
}
