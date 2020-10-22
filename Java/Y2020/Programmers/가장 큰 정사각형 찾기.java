import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;
        
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    int left = board[i][j - 1];
                    int up = board[i - 1][j];
                    int leftUp = board[i - 1][j - 1];
                    
                    int value = Math.min(left, Math.min(up, leftUp));
                    
                    board[i][j] = value + 1;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (max < board[i][j]) {
                    max = board[i][j];
                }
            }
        }
        
        answer = max * max;
        return answer;
    }
}
