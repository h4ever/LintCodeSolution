package solutions;

import solutions.SubarraySumEqualsK560;
import org.junit.Test;

import java.util.List;

public class SubarraySumEqualsK560Test {

	@Test
	public void subarraySum() {
		int[] nums = {1,2,3,-1,2,1,3,-2,5,-2,3,0,1,2};
		int[] nums2 = {1,2,1};
		SubarraySumEqualsK560 testInstance  = new SubarraySumEqualsK560();
		System.out.println(testInstance.subarraySum(nums, 4));
		List<List<Integer>> res = testInstance.subarraySum3(nums, 4);
		System.out.println(res);
		for(List<Integer> ij:res){
			for(int i=ij.get(0);i<ij.get(1)+1;i++){
				System.out.print(nums[i]+",");
			}
			System.out.println();
		}
		
		//System.out.println(testInstance.subarraySum2(nums, 3));
		//System.out.println(testInstance.subarraySum2(nums, 5));
	}

}
