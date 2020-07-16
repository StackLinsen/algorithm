package com.linsen.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lane.lin
 * @Description 判断二分图
 * 给定一个无向图graph，当这个图为二分图时返回true。
 *
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 *
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since 2020/7/16
 */
public class IsBipartite {

    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid = true;

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        IsBipartite isBipartite = new IsBipartite();
        System.out.println(isBipartite.solution_2(graph));
    }


    /**
     * 深度优先搜索
     * 时间复杂度：O(N + M):其中N和M分别是无向图中的点数和边数
     * 空间复杂度：O(N):存储节点颜色的数组需要O(N)空间，深度搜索中，栈的最大深度为N，需要O(N)的空间
     * @param graph
     * @return
     */
    public boolean solution(int[][] graph){
        int length = graph.length;
        color = new int[length];
        for(int i = 0; i < length && valid; ++i){
            if(color[i] == UNCOLORED){
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    /**
     * 广度优先搜索
     * @param graph
     * @return
     */
    public Boolean solution_2(int[][] graph){
        int n = graph.length;
        color = new int[n];

        for(int i = 0; i < n && valid; ++i){
            if(color[i] == UNCOLORED){
                gfs(i, RED, graph);
            }
        }
        return valid;
    }

    public void dfs(int i, int c, int[][] graph){
        color[i] = c;
        int cNei = c == RED ? GREEN : RED;
        for(int nei : graph[i]){
            if(color[nei] == UNCOLORED){
                color[nei] = cNei;
            }else if(color[nei] != cNei){
                valid = false;
                return;
            }
        }
    }

    public void gfs(int i, int c, int[][] graph){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i);
        color[i] = RED;
        while(!queue.isEmpty()){
            int node = queue.poll();
            int cNei = color[node] == RED ? GREEN : RED;
            for(int nei : graph[node]){
                if(color[nei] == UNCOLORED){
                    queue.offer(nei);
                    color[nei] = cNei;
                }else if(color[nei] != cNei){
                    valid = false;
                    return;
                }
            }
        }
    }
}
