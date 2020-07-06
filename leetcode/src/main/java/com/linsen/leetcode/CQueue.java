package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author lane.lin
 * @Description
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since 2020/6/30
 */
public class CQueue {
    private Stack mainStack;
    private Stack subStack;

    public CQueue() {
        mainStack = new Stack<Integer>();
        subStack = new Stack<Integer>();
    }

    public void appendTail(int value) {
        mainStack.push(value);
    }

    /**
     * todo 可以再优化一下，不需要每次再返回mainStack
     * @return
     */
    public int deleteHead() {
        //先将mainStack的所有元素出栈到subStock中，然后出栈并删除subStock中的一个元素

        if(mainStack.empty()){
            return -1;
        }
        while (!mainStack.empty()){
            subStack.push(mainStack.pop());
        }
        int result = (Integer) subStack.pop();
        //再将subStock出栈到mainStock中
        while(!subStack.empty()){
            mainStack.push(subStack.pop());
        }
        return result;
    }

    static class Solution{

        public static void main(String[] args) {
            CQueue cQueue = new CQueue();
            cQueue.appendTail(1);
            cQueue.appendTail(2);
            System.out.println(cQueue.deleteHead());

            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.add(1);
            linkedList.add(2);
        }
    }
}
