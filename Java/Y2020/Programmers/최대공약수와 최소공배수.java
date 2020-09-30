import java.util.*;

class Solution {
    public int ft_gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        
        return ft_gcd(y, x % y);
    }
    
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int gcd = ft_gcd(n, m);
        answer[0] = gcd;
        answer[1] = (n * m) / gcd;
        
        return answer;
    }
}
