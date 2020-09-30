import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        
        if (arr.length == 1) {
            return new int[] {-1};
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        
        list.remove(list.indexOf(min));
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
