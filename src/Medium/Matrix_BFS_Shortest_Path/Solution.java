package Medium.Matrix_BFS_Shortest_Path;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPath(int[][] grid) {
        return bfs(grid);
    }

    public int bfs(int[][] grid){
        final int ROWS= grid.length;
        final int COLS=grid[0].length;
        int[][] visited=new int[ROWS][COLS];
        Queue<int[]> queue=new LinkedList<>();
        int length=0;
        queue.offer(new int[]{0,0});
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}}; // up, down, right, left
        while(!queue.isEmpty()){
            int n=queue.size();
            for (int i=0;i<n;i++){
                int[] coordinates= queue.poll();
                int x=coordinates[0];
                int y=coordinates[1];
                if(Math.min(x,y)<0 ||
                        x>=ROWS ||
                        y>=COLS ||
                        visited[x][y]==1 ||
                        grid[x][y]==1
                )
                    continue;
                if(x==ROWS-1 && y==COLS-1) return length;
                visited[x][y]=1;
                for (int[] dir : directions){
                    queue.offer(new int[]{x+dir[0],y+dir[1]});
                }
            }
            length++;
        }
        return visited[ROWS-1][COLS-1]==1 ? length : -1;
    }
}
