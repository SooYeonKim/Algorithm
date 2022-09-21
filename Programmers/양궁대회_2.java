
public class 양궁대회_2 {
    
    int n, result;
    int[] aArr, rArr, answer;
    
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.aArr = info;
        result = -1;
        rArr = new int[11];
        answer = new int[11];
        
        recursion(0, n);
        
        if (result == -1) {
            return new int[]{-1};
        } else {
            return answer;
        }
    }
    
    public void recursion(int cnt, int arrow) {
        if (cnt == 11) {
            int aScore = 0;
            int rScore = 0;
            for (int i = 0; i < 11; i++) {
                if (aArr[i] > rArr[i]) {
                    aScore += (10 - i);
                } else if (aArr[i] == rArr[i] && aArr[i] != 0) {
                    aScore += (10 - i);
                } else if (aArr[i] < rArr[i]) {
                    rScore += (10 - i);
                }
            }
            
            if (rScore > aScore && result < rScore - aScore) {
                result = rScore - aScore;
                for (int i = 0; i < 11; i++) {
                    answer[i] = rArr[i];
                }
            }
            
            return;
        }
        
        for (int i = arrow; i >= 0; i--) {
            rArr[10 - cnt] = i;
            recursion(cnt + 1, arrow - i);
        }
    }
}
