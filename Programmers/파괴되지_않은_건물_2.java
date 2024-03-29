
public class 파괴되지_않은_건물_2 {
    public int solution(int[][] board, int[][] skill) {
        int[][] prefixSum = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if (type == 1) degree *= -1;
            
            prefixSum[r1][c1] += degree;
            prefixSum[r2 + 1][c1] -= degree;
            prefixSum[r1][c2 + 1] -= degree;
            prefixSum[r2 + 1][c2 + 1] += degree;
        }
        
        for (int i = 0; i < board.length + 1; i++) {
            for (int j = 1; j < board[0].length + 1; j++) {
                prefixSum[i][j] += prefixSum[i][j-1];
            }
        }
        
        for (int j = 0; j < board[0].length + 1; j++) {
            for (int i = 1; i < board.length + 1; i++) {
                prefixSum[i][j] += prefixSum[i-1][j];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + prefixSum[i][j] >= 1) answer++;
            }
        }
        return answer;
    }
}
