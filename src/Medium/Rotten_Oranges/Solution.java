package Medium.Rotten_Oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        final int ROWS= grid.length;
        final int COLS=grid[0].length;
        int countOnes=0;
        Queue<int[]> queue=new LinkedList<>();
        for (int i=0;i<ROWS;i++){
            for (int j=0;j<COLS;j++){
                if (grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1)
                    countOnes++;

            }
        }
        return bfs(grid,queue,ROWS,COLS,countOnes);
    }

    public int bfs(int[][] grid, Queue<int[]> queue, int rows, int cols,int countOnes){
        if(countOnes==0) return 0;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}}; // up, down, right, left
        int minutes=0;
        int[][] visited=new int[rows][cols];
        while(!queue.isEmpty()){
            int n=queue.size();
            for (int i=0;i<n;i++){
                int[] coordinates= queue.poll();
                int x=coordinates[0];
                int y=coordinates[1];
                if(Math.min(x,y)<0 ||
                        x>=rows ||
                        y>=cols ||
                        grid[x][y]==0 ||
                        visited[x][y]==1
                )
                    continue;
                visited[x][y]=1;
                if(grid[x][y]==1){
                    countOnes--;
                    grid[x][y]=2;
                }

                for (int[] dir : directions){
                    queue.offer(new int[]{x+dir[0],y+dir[1]});
                }
            }
            minutes++;
        }
        System.out.println("Ones: "+countOnes + " Minutes: "+minutes);
        return countOnes==0 ? minutes-2 : -1;
    }

}
