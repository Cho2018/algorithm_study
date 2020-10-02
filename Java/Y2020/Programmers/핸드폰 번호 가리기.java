import java.util.*;

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder(phone_number);
        
        for (int i = 0; i < phone_number.length() - 4; i++) {
            sb.setCharAt(i, '*');
        }
        
        answer = sb.toString();
        return answer;
    }
}
