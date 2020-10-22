import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = Integer.bitCount(n);
        int num = n + 1;
        
        while (true) {
            if (count == Integer.bitCount(num)) {
                answer = num;
                break;
            }
            
            num++;
        }
        
        return answer;
    }
}
