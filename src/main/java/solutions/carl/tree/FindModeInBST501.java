package solutions.carl.tree;

import structure.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class FindModeInBST501 {
    /*
        给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。

        如果树中有不止一个众数，可以按 任意顺序 返回。

        假定 BST 满足如下定义：

        结点左子树中所含节点的值 小于等于 当前节点的值
        结点右子树中所含节点的值 大于等于 当前节点的值
        左子树和右子树都是二叉搜索树
     */
    Integer pre = null;
    int frequency = 1, maxFrequency = 1;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            updateMaxFrequence(root);
            pre = root.val;
            root = root.right;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }




    public void findModeDfs(TreeNode root){
        if(root==null){
            return;
        }
        findModeDfs(root.left);

        updateMaxFrequence(root);
        pre = root.val;
        findModeDfs(root.right);
    }

    public int[] findMode2(TreeNode root) {
        findModeDfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void updateMaxFrequence(TreeNode root){
        if(pre==null||pre!=root.val){
            frequency = 1;
        }else{
            frequency ++;
        }

        if(frequency>maxFrequency){
            maxFrequency = frequency;
            list.clear();
            list.add(root.val);
        }else if(frequency==maxFrequency){
            list.add(root.val);
        }
    }

    public void updateMaxFrequenceErr(TreeNode root){
        if(pre!=null){
            if(root.val==pre) {
                frequency++;
                if(frequency>maxFrequency){
                    maxFrequency = frequency;
                    list.clear();
                    list.add(pre);
                }else if(frequency==maxFrequency){
                    list.add(pre);
                }
            }else{
                frequency = 1;
                if(maxFrequency == 1){
                    list.add(root.val);
                }
            }
        }else{
            list.add(root.val);
        }

    }
}
