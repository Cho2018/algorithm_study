import java.util.*;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int real_x = x;
        int temp = 0;
        
        while (x != 0) {
            temp += (x % 10);
            x /= 10;
        }
        
        if (real_x % temp != 0) {
            return false;
        }
        
        return answer;
    }
}
