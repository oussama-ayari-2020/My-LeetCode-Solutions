package Medium.Matrix_Depth_First_Search;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public int countPaths(int[][] grid) {
        final int ROWS= grid.length;
        final int COLS=grid[0].length;
        int[][] visited=new int[ROWS][COLS];
        return dfs(0,0,grid,visited);
    }

    public int dfs(int x, int y, int[][] grid, int[][] visited){
        final int ROWS= grid.length;
        final int COLS=grid[0].length;
        if(Math.min(x,y)<0
                || x==ROWS
                || y==COLS
                || grid[x][y]==1
                || visited[x][y]==1)
            return 0;
        if(x==ROWS-1 && y==COLS-1)
            return 1;
        int count=0;
        visited[x][y]=1;
        count+=dfs(x+1,y,grid,visited);
        count+=dfs(x-1,y,grid,visited);
        count+=dfs(x,y+1,grid,visited);
        count+=dfs(x,y-1,grid,visited);
        visited[x][y]=0;
        return count;
    }

}
