import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char p = ' ';
        
        for (char c : s.toCharArray()) {
            if (p == ' ') {
                if (c >= 'a' && c <= 'z') {
                    c -= 32;
                }
            } else if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            
            p = c;
            sb.append(c);
        }
        
        answer = sb.toString();
        return answer;
    }
}
