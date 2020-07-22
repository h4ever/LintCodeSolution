package test.java.solutions.array;

import main.java.solutions.array.SortArrayByParityII922;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortArrayByParityII922Test {

    @Test
    public void sortArrayByParityII() {
        int[] A = {4,2,5,7};
        SortArrayByParityII922.sortArrayByParityII(A);
        System.out.println(Arrays.toString(A));
    }
}