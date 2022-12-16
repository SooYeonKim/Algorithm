
public class 삼총사 {
    
    int[] number;
    int answer;
    
    public int solution(int[] number) {
        this.number = number;
        
        combination(0, 0, 0);
        
        return answer;
    }
    
    private void combination(int cnt, int start, int sum) {
        if (cnt == 3) {
            if (sum == 0) answer++;
            return;
        }
        
        for (int i = start; i < number.length; i++) {
            combination(cnt + 1, i + 1, sum + number[i]);
        }
    }
}
