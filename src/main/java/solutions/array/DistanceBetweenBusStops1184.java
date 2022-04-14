package solutions.array;

import java.util.Arrays;

public class DistanceBetweenBusStops1184 {
    /*
    A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.

The bus goes along both directions i.e. clockwise and counterclockwise.

Return the shortest distance between the given start and destination stops.
Constraints:

    1 <= n <= 10^4
    distance.length == n
    0 <= start, destination < n
    0 <= distance[i] <= 10^4
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = Arrays.stream(distance).sum();
        int clockwise = 0;
        if(start>destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        for(int i=start;i<destination;i++)clockwise += distance[i];
        return Math.min(clockwise,sum-clockwise);
    }
}
