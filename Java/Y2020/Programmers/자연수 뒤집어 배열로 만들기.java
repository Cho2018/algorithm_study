import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        
        while (n != 0) {
            list.add((int)(n % 10));
            n /= 10;
            i++;
        }
        
        answer = new int[i];
        for (int j = 0; j < list.size(); j++) {
            answer[j] = list.get(j);
        }
        
        return answer;
    }
}
