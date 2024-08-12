package Medium.Magic_Squares_In_Grid;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows-2; i++) {
            for (int j = 0; j < cols-2; j++) {
                if(isMagicSquare(i,j,grid))
                    count++;
            }
        }
    return count;
    }

    private boolean isMagicSquare(int r, int c, int[][] grid) {
        int[] isPresent=new int[9];
        //Calculate Initial Sum
        int uniqS=0;
        for(int i=c;i<c+3;i++)
            uniqS+=grid[r][i];
        //test if each value in 3x3 grid is distinct and in range 1-9
        for(int i=r;i<r+3;i++){
            int sum=0;
            for (int j=c;j<c+3;j++){
                int num=grid[i][j];
                if(num>=1 && num<=9){
                    isPresent[num-1]++;
                    if(isPresent[num-1]>1)
                        return false;
                }else return false;
                sum+=grid[i][j];
            }
            if(sum!=uniqS) return false;
        }
        //Check Column Sums
        for(int i=c;i<c+3;i++){
            int s=0;
            for (int j=r;j<r+3;j++){
                s+=grid[j][i];
            }
            if(s!=uniqS) return false;
        }

        int[][] diag1=new int[][]{
                {0,0},
                {1,1},
                {2,2}
        };
        int s=0;
        for(int[] dir : diag1){
            s+=grid[r+dir[0]][c+dir[1]];
        }
        if(s!=uniqS) return false;
        int[][] diag2=new int[][]{
                {0,2},
                {1,1},
                {2,0}
        };
        s=0;
        for(int[] dir : diag2){
            s+=grid[r+dir[0]][c+dir[1]];
        }
        return s == uniqS;
    }

}
