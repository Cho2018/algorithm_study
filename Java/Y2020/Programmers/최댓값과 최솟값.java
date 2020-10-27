import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }
        
        Collections.sort(list);
        sb.append(list.get(0)).append(" ").append(list.get(list.size() - 1));
        
        answer = sb.toString();
        return answer;
    }
}
