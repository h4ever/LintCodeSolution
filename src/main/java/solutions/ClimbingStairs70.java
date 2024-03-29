package solutions;

public class ClimbingStairs70 {
	public int climbStairs(int n) {
        if(n<=3) return n;
        int one_step_before=2;
        int two_steps_before=1;
        int all_ways=0;
        for(int i=3;i<=n;i++){
            all_ways=one_step_before+two_steps_before;
            two_steps_before=one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
}
