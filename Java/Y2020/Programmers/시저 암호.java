import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            
            if (temp >= 65 && temp <= 90) { // 대문자
                temp += n;
                
                if (temp > 90) {
                    temp -= 26;
                }
            } else if (temp >= 97 && temp <= 122) { // 소문자
                temp += n;
                
                if (temp > 122) {
                    temp -= 26;
                }
            }
            
            sb.append(temp);
        }
        
        answer = sb.toString();
        return answer;
    }
}
