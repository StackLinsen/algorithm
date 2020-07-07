package com.linsen.leetcode;

/**
 * @author lane.lin
 * @Description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since 2020/7/6
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(solution_2(nums));
    }

    public static int solution(int[][] obstacleGrid){
        int m = obstacleGrid.length - 1;
        int n = obstacleGrid[0].length - 1;
        return fa(obstacleGrid, m, n);
    }

    public static int solution_2(int[][] obstacleGrid){
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

    public static int fa(int[][] obstacleGrid, int m, int n){
        if(obstacleGrid[m][n] == 1){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        int result = 0;
        if(m >= 1){
            result += fa(obstacleGrid, m - 1, n);
        }
        if(n >= 1){
            result += fa(obstacleGrid, m, n - 1);
        }
        return result;
    }
}
