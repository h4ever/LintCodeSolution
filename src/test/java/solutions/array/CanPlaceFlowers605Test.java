package test.java.solutions.array;

import main.java.solutions.array.CanPlaceFlowers605;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanPlaceFlowers605Test {

    @Test
    public void canPlaceFlowers() {
        int[] flowerbed = {0,0,1,0,1};
        CanPlaceFlowers605.canPlaceFlowers(flowerbed,1);
    }
}