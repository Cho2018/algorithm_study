import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        // 윤년 - 2 : 29
        // 1 3 5 7 8 10 12 : 31
        // 4 6 9 11 : 30
        
        int[] day = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] name = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int total = 4;
        int result = 0;
        
        for (int i = 1; i < a; i++) {
            total += day[i];
        }
        
        total += b;
        result = total % 7;
        
        // 145 + 4 = 149 -> 2 
        // 1 + 4 = 5 -> 5
        
        answer = name[result];
        return answer;
    }
}
