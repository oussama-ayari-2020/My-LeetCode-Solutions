package Medium.Spiral_Matrix_III;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> res=new ArrayList<>();
        int[][] directions=new int[][]{
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };
        int steps=1;
        int i=0;
        while(res.size()<(rows*cols)){
            for(int k=0;k<2;k++){
                for(int j=0;j<steps;j++){
                    if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols)
                        res.add(new int[]{rStart,cStart});
                    rStart+=directions[i][0];
                    cStart+=directions[i][1];
                }
                i=(i+1)%4;
            }
            steps++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
