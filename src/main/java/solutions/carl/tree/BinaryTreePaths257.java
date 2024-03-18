package solutions.carl.tree;


import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
    /*
    给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

叶子节点 是指没有子节点的节点。

     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root,paths,new StringBuilder());
        return paths;
    }

    public void binaryTreePaths(TreeNode root, List<String> paths, StringBuilder path){

        path.append(root.val);

        if(root.left==null&&root.right==null){
            paths.add(path.toString());
        }else{
            path.append("->");
            if(root.left!=null){
                int len = path.length();
                binaryTreePaths(root.left,paths,path);
                path.setLength(len);
            }
            if(root.right!=null){
                int len = path.length();
                binaryTreePaths(root.right,paths,path);
                path.setLength(len);
            }
        }

    }
}
