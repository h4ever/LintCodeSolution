package solutions.top100liked;

import org.junit.Test;

import static org.junit.Assert.*;

public class Permutations46Test {
        @Test
        public void test(){
            Permutations46 p = new Permutations46();
            int[] nums = {1,2,5,6};
            System.out.println(p.permute(nums));
        }
}