import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (int j = 3; j <= Math.sqrt(sum); j++) {
            if (sum % j == 0) {
                int i = sum / j;
                
                if ((i - 2) * (j - 2) == yellow) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        return answer;
    }
}
