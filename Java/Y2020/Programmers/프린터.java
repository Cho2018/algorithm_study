import java.util.*;

class Solution {
    class Pair {
        int index, priority;
        
        public Pair(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        boolean isExist = false;
        Queue<Pair> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Pair(i, priorities[i]));
        }
        
        while (!queue.isEmpty() && !isExist) {
            Queue<Pair> temp = new LinkedList<>();
            Pair p = queue.poll(); // 가장 맨 앞의 문서 가져오기
            
            // temp를 이용해 현재 문서보다 중요도가 높은 문서가 있는지 확인
            
            // 1. 큐 속에 저장된 문서의 중요도가 현재 문서의 중요도보다 높은 것이 나타날때까지
            // temp에 queue 데이터를 삽입
            while (!queue.isEmpty() && queue.peek().priority <= p.priority) {
                temp.offer(queue.poll());
            }
            
            // 2. 만약 큐가 비지 않았다면, 현재 문서보다 중요도가 높은 문서가 존재하는 것
            // => 다시 p를 큐에 삽입
            if (!queue.isEmpty()) {
                queue.offer(p);
            } else { // 문서 출력. 만약 location과 문서의 index가 같다면 반복을 멈춤
                answer += 1;
                isExist = (location == p.index);
            }
            
            // 3. temp에 저장된 문서들을 다시 큐로 
            while (!temp.isEmpty()) {
                queue.offer(temp.poll());
            }
        }
        
        return answer;
    }
}
