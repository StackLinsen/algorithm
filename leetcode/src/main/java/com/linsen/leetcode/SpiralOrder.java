package com.linsen.leetcode;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *
 */
public class SpiralOrder {

    /**
     *  将矩阵四条边，从外到内顺时针 == “上边界从坐到右，右边界从上到下，下边界从右到左，左边界从下到上”
     *  每一次遍历改变四条边控制的变量
     * @param matrix
     * @return
     */
    int[] solution(int[][] matrix) {
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int buttom = matrix.length - 1;
        int x = 0;
        int[] res = new int[(right + 1) * (buttom + 1)];

        while (true) {
            //从左到右循环
            for (int i = left; i <= right; i++) {
                res[x++] = matrix[top][i];
            }
            if (++top > buttom) {
                //退出循环
                break;
            }
            //从上到下循环
            for(int i = top; i <= buttom; i++){
                res[x++] = matrix[i][right];
            }
            if(--right < left){
                break;
            }
            //从又到左循环
            for(int i = right; i >= left; i--){
                res[x++] = matrix[buttom][i];
            }
            if(--buttom < top){
                break;
            }
            //从下到上循环
            for(int i = buttom; i >= top; i--){
                res[x++] = matrix[i][left];
            }
            if(++left > right){
                break;
            }

            if (left > right) {
                break;
            }
        }
        return res;
    }
}
