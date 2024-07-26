package Medium.Number_of_Islands;

public class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        final int ROWS= grid.length;
        final int COLS=grid[0].length;
        for(int i=0;i<ROWS;i++){
            for (int j=0;j<COLS;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int x, int y){
        final int ROWS= grid.length;
        final int COLS=grid[0].length;
        if(Math.min(x,y)<0
                || x==ROWS
                || y==COLS
                || grid[x][y]=='0')
            return ;
        grid[x][y]='0';
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
    }
}
