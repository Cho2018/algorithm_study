import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int count1 = 0, count2 = 0, count3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) {
                count1++;
            } 
            
            if (answers[i] == two[i % 8]) {
                count2++;
            }
            
            if (answers[i] == three[i % 10]) {
                count3++;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(count1);
        list.add(count2);
        list.add(count3);
        int max = Collections.max(list);
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max) {
                result.add(i + 1);
            }
        }
        
        Collections.sort(result);
        
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
