package Easy.Pass_The_Pillow_2582;

public class Solution {
    public int passThePillow(int n, int time) {
        return time/(n-1)%2 == 0 ? (time%(n-1)+1) : (n-(time%(n-1)));
    }
}
