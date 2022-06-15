
public class 행렬_테두리_회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] array = new int[rows][columns];
        int idx = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = idx++;
            }
        }
        
        int[] answer = new int[queries.length];
        for (int t = 0; t< queries.length; t++) {
            int x1 = queries[t][0] - 1;
            int y1 = queries[t][1] - 1;
            int x2 = queries[t][2] - 1;
            int y2 = queries[t][3] - 1;
            
            int min = array[x1][y1];
            int temp = array[x1][y1];
            for (int i = x1; i < x2; i++) {
                array[i][y1] = array[i+1][y1];
                min = Math.min(min, array[i][y1]);
            }
            for (int i = y1; i < y2; i++) {
                array[x2][i] = array[x2][i+1];
                min = Math.min(min, array[x2][i]);
            }
            for (int i = x2; i > x1; i--) {
                array[i][y2] = array[i-1][y2];
                min = Math.min(min, array[i][y2]);
            }
            for (int i = y2; i > y1; i--) {
                array[x1][i] = array[x1][i-1];
                min = Math.min(min, array[x1][i]);
            }
            if (y2 > y1) {
                array[x1][y1+1] = temp;
            }
            
            answer[t] = min;
        }
        
        return answer;
    }
}
