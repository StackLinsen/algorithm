package com.linsen.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lane.lin
 * @Description TODO
 * @since 2020/6/18
 */
public class RecoverFromPreorder {

    public Codec.TreeNode solution(String S){
        Deque<Codec.TreeNode> path = new LinkedList<Codec.TreeNode>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            while (S.charAt(pos) == '-') {
                //代表‘-’的数量
                ++level;
                ++pos;
            }
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                //字符串获取数字一个一个的取，前面的没经过一位的增加都需要*10
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            Codec.TreeNode node = new Codec.TreeNode(value);
            //level=当前节点深度=栈的size
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    //当前节点是上一个节点的左节点
                    path.peek().left = node;
                }
            } else {
                while (level != path.size()) {
                    //remove
                    path.pop();
                }
                //don't remove
                // 当前节点是从根节点到上一个节点路径中的某个节点的右子节点(但是不包括上一个节点)
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }
}
