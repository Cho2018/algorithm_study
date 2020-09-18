import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        //int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            } else {
                count++;
            }
        }
        
        if (count == arr.length) {
            list.add(-1);
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
