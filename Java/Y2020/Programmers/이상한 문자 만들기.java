import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int count = 0;
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("");
        
        for (String str : arr) {
            count = str.contains(" ")? 0 : count + 1;
            sb.append(count % 2 == 0? str.toLowerCase() : str.toUpperCase());
        }
        
        answer = sb.toString();
        return answer;
    }
}
