import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int x = commands[i][0];
            int y = commands[i][1];
            int k = commands[i][2];
            
            for (int j = x; j <= y; j++) {
                list.add(array[j - 1]);
            }
            
            Collections.sort(list);
            
            answer[i] = list.get(k - 1);
        }
        
        return answer;
    }
}
