import java.util.*;

class Solution {
    public int solution(int num) {
        int answer = -1;
        int count = 0;
        
        while (++count < 450) {
            if (num == 1) {
                return count - 1;
            } 
            
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
        }
        
        return answer;
    }
}
