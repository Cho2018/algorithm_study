import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        double dtemp = Math.sqrt(n);
        int itemp = (int)dtemp;
        
        if (dtemp == itemp) {
            answer = (long)Math.pow(itemp + 1, 2);
        } else {
            return -1;
        }
        
        return answer;
    }
}
