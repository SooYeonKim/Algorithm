
public class 혼자서_하는_틱택토 {
    
    char[][] array;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(String[] board) {
        array = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                array[i] = board[i].toCharArray();
            }
        }
        
        int cntO = 0;
        int cntX = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'O') {
                    cntO++;
                } else if (board[i].charAt(j) == 'X') {
                    cntX++;
                }
            }
        }
        
        if (cntO < cntX || cntO - cntX > 1) {
            return 0;
        } else if (check('O') > 0 && check('X') > 0) {
            return 0;
        } else if (check('O') > 0 && cntO == cntX) {
            return 0;
        } else if (check('X') > 0 && cntO == cntX + 1) {
            return 0;
        }
        
        return 1;
    }
    
    private int check(char c) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (array[i][0] == c && array[i][1] == c && array[i][2] == c) cnt++;
            if (array[0][i] == c && array[1][i] == c && array[2][i] == c) cnt++;
        }
        if (array[0][0] == c && array[1][1] == c && array[2][2] == c) cnt++;
        if (array[2][0] == c && array[1][1] == c && array[0][2] == c) cnt++;
        
        return cnt;
    }
}
