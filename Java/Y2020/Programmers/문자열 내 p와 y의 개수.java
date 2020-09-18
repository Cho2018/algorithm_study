import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        //[실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println("Hello Java");
        
        String temp = s.toLowerCase();
        int count_p = 0, count_y = 0;
        
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == 'p') {
                count_p++;
            } else if (temp.charAt(i) == 'y') {
                count_y++;
            }
        }
        
        if (count_p != count_y) {
            return false;
        }

        return answer;
    }
}
