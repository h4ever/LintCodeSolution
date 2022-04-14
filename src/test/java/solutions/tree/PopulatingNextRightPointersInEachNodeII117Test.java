package solutions.tree;

import solutions.tree.PopulatingNextRightPointersInEachNodeII117;
import structure.TreeLinkNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class PopulatingNextRightPointersInEachNodeII117Test {

    @Test
    public void connect() {
        PopulatingNextRightPointersInEachNodeII117 testInstance = new PopulatingNextRightPointersInEachNodeII117();
        TreeLinkNode left = new TreeLinkNode(2,new TreeLinkNode(4),new TreeLinkNode(5),null);
        TreeLinkNode right = new TreeLinkNode(3,null,new TreeLinkNode(7),null);
        TreeLinkNode root = new TreeLinkNode(1,left,right,null);

        testInstance.connect(root);
    }
}