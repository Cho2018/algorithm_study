import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}
