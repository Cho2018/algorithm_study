import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);   
        int min = citations[0];
        int max = citations[citations.length - 1];
        
        for (int i = min; i <= max; i++) {
            if (min >= citations.length) {
                return citations.length;
            }
            
            int count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) {
                    count++;
                }
            }
            
            if (count >= i) {
                if (i > answer) {
                    answer = i;
                }
            }
        }
        
        return answer;
    }
}
