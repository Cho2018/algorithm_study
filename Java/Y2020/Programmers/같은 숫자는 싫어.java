import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        //int[] answer = {};
        
        //[실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println("Hello Java");

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            int pre = arr[i - 1];
            int now = arr[i];
            
            if (pre != now) {
                list.add(now);
            } else {
                continue;
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
