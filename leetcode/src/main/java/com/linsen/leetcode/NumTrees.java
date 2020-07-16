package com.linsen.leetcode;

/**
 * @author lane.lin
 * @Description 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种
 * @since 2020/7/15
 */
public class NumTrees {

    public static void main(String[] args) {

    }


    /**
     * 用G(n)表示序列为n的二叉搜索树的个数
     * 用F(i，n)表示以i为根，序列为n的二叉搜索树的个数
     * 所以：G(n) = sum(F(i,n))  i = 1->n
     * F(i,n) = G(i-1)*G(n-i)
     * 所以 G(n) = sum(G(i-1) * G(n-i)) i=1->n
     * @param n
     * @return
     */
    public int solution(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        //在每个循环中，i相当于新的n，j就是不断增加的下标
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
