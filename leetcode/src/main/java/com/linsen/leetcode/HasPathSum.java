package com.linsen.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.List;

/**
 * @author lane.lin
 * @Description 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * @since 2020/7/7
 */
public class HasPathSum {

    public static void main(String[] args) {
        TreeNode level0TreeNode = new TreeNode(5);
        TreeNode level1TreeNode1 = new TreeNode(4);
        TreeNode level1TreeNode2 = new TreeNode(8);
        level0TreeNode.left = level1TreeNode1;
        level0TreeNode.right = level1TreeNode2;

        TreeNode level2TreeNode1 = new TreeNode(11);
        TreeNode level2TreeNode2 = new TreeNode(13);
        TreeNode level2TreeNode3 = new TreeNode(4);
        level1TreeNode1.left = level2TreeNode1;
        level1TreeNode2.left = level2TreeNode2;
        level1TreeNode2.right = level2TreeNode3;

        TreeNode level3TreeNode1 = new TreeNode(7);
        TreeNode level3TreeNode2 = new TreeNode(2);
        TreeNode level3TreeNode3 = new TreeNode(1);
        level2TreeNode1.left = level3TreeNode1;
        level2TreeNode1.right = level3TreeNode2;
        level2TreeNode3.right = level3TreeNode3;
        System.out.println(solution(level0TreeNode, 22));
    }

    /**
     * 采用递归法将路径上的值都累加到叶子节点
     *
     * @param root
     * @param sum
     * @return
     */
    public static boolean solution(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        if (null == root.left && null == root.right) {
            if (root.val == sum) {
                return true;
            }
        }
//        return solution(root.left, sum - root.val) || solution(root.right, sum - root.val);

        boolean leftResult = false;
        if (null != root.left) {
            root.left.val += root.val;
            leftResult = solution(root.left, sum);
        }
        boolean rightResult = false;
        if (null != root.right) {
            root.right.val += root.val;
            rightResult = solution(root.right, sum);
        }
        return leftResult || rightResult;
    }

    /**
     * 广度优先搜索
     * @param root
     * @param sum
     * @return
     */
    public static boolean solution_2(TreeNode root, int sum){
        // TODO: 2020/7/7
        return false;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
