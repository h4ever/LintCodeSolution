package solutions.carl.hashtable;

import org.junit.Test;

import java.util.Arrays;

public class TwoSum1Test {
    @Test
    public void test(){
        TwoSum1 twoSum1 = new TwoSum1();
        int[] nums = {3,2,4};
        System.out.println(Arrays.asList(twoSum1.twoSum(nums,6)));

    }
}
