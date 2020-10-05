import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int s : scoville) {
            queue.offer(s);
        }
        
        while (queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            } else {
                queue.offer(queue.poll() + (queue.poll() * 2));
                answer++;
            }
        }
        
        return answer;
    }
}
