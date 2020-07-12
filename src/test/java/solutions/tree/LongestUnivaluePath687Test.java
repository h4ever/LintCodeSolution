package test.java.solutions.tree;

import main.java.solutions.tree.LongestUnivaluePath687;
import main.java.structure.TreeNode;
import org.junit.Test;

public class LongestUnivaluePath687Test {
    /*
                    3
             3           3
          4     3     2     4
        4   4       2   2     5
                  2   1   2    5
     */

    @Test
    public void longestUnivaluePath() {

        LongestUnivaluePath687 testInstance2 = new LongestUnivaluePath687();
        TreeNode root = generateTestData();
        testInstance2.longestUnivaluePath(root);
    }

    public static TreeNode generateTestData(){
        TreeNode root=new TreeNode(3);
        TreeNode l =new TreeNode(3);
        TreeNode r =new TreeNode(3);
        TreeNode ll =new TreeNode(4);
        TreeNode lr =new TreeNode(3);
        TreeNode lll =new TreeNode(4);
        TreeNode llr =new TreeNode(4);
        TreeNode rl =new TreeNode(2);
        TreeNode rll =new TreeNode(2);
        TreeNode rlr =new TreeNode(2);
        TreeNode rlrr =new TreeNode(2);
        TreeNode rlll =new TreeNode(2);
        TreeNode rllr =new TreeNode(1);
        TreeNode rr =new TreeNode(4);
        TreeNode rrr =new TreeNode(5);
        TreeNode rrrr =new TreeNode(5);
        root.left=l;root.right=r;
        l.left=ll;l.right=lr;
        ll.left=lll;ll.right=llr;
        r.left=rl;rl.left=rll;
        rl.right=rlr;rlr.right=rlrr;
        rll.left=rlll;rll.right=rllr;
        r.right=rr;rr.right=rrr;
        rrr.right=rrrr;
        return root;
    }
}