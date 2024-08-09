package Medium.Max_Area_of_Island;

public class Solution {
    int ROWS=0;
    int COLS=0;
    public int maxAreaOfIsland(int[][] grid) {
        ROWS= grid.length;
        COLS=grid[0].length;
        int count=0;
        for(int i=0;i<ROWS;i++){
            for (int j=0;j<COLS;j++){
                if(grid[i][j]==1)
                    count=Math.max(count,dfs(grid,i,j));
            }
        }
        return count;
    }

    public int dfs(int[][] grid,int x,int y){
        if(Math.min(x,y)<0 ||
                x>=ROWS ||
                y>=COLS ||
                grid[x][y]==0
        )
            return 0;
        grid[x][y]=0;
        return 1+dfs(grid,x+1,y)+dfs(grid,x-1,y)+dfs(grid,x,y+1)+dfs(grid,x,y-1);
    }
}
