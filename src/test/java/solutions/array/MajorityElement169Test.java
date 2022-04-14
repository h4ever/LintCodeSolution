package solutions.array;

import solutions.array.MajorityElement169;
import org.junit.Test;

import static org.junit.Assert.*;

public class MajorityElement169Test {

    @Test
    public void majorityElement() {
        int[] nums = {0,2,3,2,2,3,2,3,1,1,2,1,2,1,2,2,2};
        MajorityElement169.majorityElement(nums);
    }
}