package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lane.lin
 * @Description 给定一个 N 叉树，返回其节点值的前序遍历。
 * 前序遍历：根->左->右
 * @since 2020/7/7
 */
public class Preorder {

    public static void main(String[] args) {
        List<Node> level1Nodes = new ArrayList<>();
        List<Node> level2Nodes = new ArrayList<>();
        Node level2NodeOne = new Node(5, Collections.emptyList());
        Node level2NodeTwo = new Node(6, Collections.emptyList());
        level2Nodes.add(level2NodeOne);
        level2Nodes.add(level2NodeTwo);
        Node level1NodeOne = new Node(3, level2Nodes);
        Node level1NodeTwo = new Node(2, Collections.emptyList());
        Node level1NodeThree = new Node(4, Collections.emptyList());
        level1Nodes.add(level1NodeOne);
        level1Nodes.add(level1NodeTwo);
        level1Nodes.add(level1NodeThree);
        Node node = new Node(1, level1Nodes);
        System.out.println(solution_2(node));
    }


    /**
     * 递归写法
     * @param root
     * @return
     */
    public static List<Integer> solution(Node root){
        if(null == root){
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        //根节点
        result.add(root.val);
        if(null == root.children){
            return Collections.emptyList();
        }
        root.children.forEach(e -> {
            result.addAll(solution(e));
        });
        return result;
    }

    /**
     * 迭代写法
     * 手动维护一个栈
     * @param root
     * @return
     */
    public static List<Integer> solution_2(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(null == root){
            return output;
        }
        //先把根节点压入栈中
        stack.add(root);
        while(!stack.isEmpty()){
            //从栈中取出一个节点表示当前遍历的节点
            Node node = stack.pollLast();
            output.add(node.val);
            //取出当前节点的所有子节点并倒序放入栈中
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
