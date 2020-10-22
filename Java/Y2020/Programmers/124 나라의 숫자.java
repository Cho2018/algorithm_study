import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr = {"4", "1", "2"};
        int temp = 0;
        
        while (n > 0) {
            temp = n % 3;
            n = (n - 1) / 3;
            
            answer = arr[temp] + answer;
        }
        
        return answer;
    }
}
