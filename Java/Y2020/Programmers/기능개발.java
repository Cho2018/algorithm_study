import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        ArrayList<Integer> p_list = new ArrayList<>();
        ArrayList<Integer> s_list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            p_list.add(progresses[i]);
            s_list.add(speeds[i]);
        }
        
        while (p_list.size() != 0) {
            for (int i = 0; i < p_list.size(); i++) {
                p_list.set(i, p_list.get(i) + s_list.get(i));
            }
            
            int count = 0;
            while (p_list.size() != 0 && p_list.get(0) >= 100) {
                p_list.remove(0);
                s_list.remove(0);
                count += 1;
            }
            
            if (count > 0) {
                result.add(count);
            }
        }
        
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
