import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // 시간 초 
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int temp = stack.peek();
                stack.pop();
                answer[temp] = i - temp;
            }
            
            stack.push(i);
        } 
        
        while (!stack.isEmpty()) {
            int temp = stack.peek();
            stack.pop();
            answer[temp] = n - 1 - temp;
        }
        
        return answer;
    }
}
