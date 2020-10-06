import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cur_weight = 0;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> dist = new ArrayList<>(); // 각 트럭이 진행한 거리를 나타냄
        
        for (int i = truck_weights.length - 1; i >= 0; i--) {
            stack.push(truck_weights[i]);
        }
        
        for (int i = 0; i < truck_weights.length; i++) {
            dist.add(0);
        }
        
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            
            if (cur_weight + temp > weight) {
                stack.push(temp);
            } else {
                cur_weight += temp;
                queue.offer(temp);
            }
            
            for (int i = 0; i < queue.size(); i++) {
                dist.set(i, dist.get(i) + 1);
            }
            
            if (dist.get(0) >= bridge_length) {
                cur_weight -= queue.poll();
                dist.remove(0);
            }
            
            answer += 1;
        }
        
        int final_left = dist.get(dist.size() - 1);
        answer += (bridge_length - final_left + 1);
        return answer;
    }
}
