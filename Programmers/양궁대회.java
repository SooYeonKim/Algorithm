
public class 양궁대회 {
    
    boolean flag;
    int total;
    int result;
    int[] info;
    int[] rCnt;
    int[] answer;
    
    public int[] solution(int n, int[] info) {
        this.total = n;
        this.info = info;
        rCnt = new int[info.length];
        answer = new int[info.length];
        
        recursion(0, n);
        
        if (!flag) {
            return new int[]{-1};
        } else {
            return answer;
        }
    }
    
    public void recursion(int cnt, int n) {     
        if (cnt == 11) {
            int aTotal = 0;
            int rTotal = 0;
            for (int i = 0; i < 10; i++) {
                if (!(info[i] == 0 && rCnt[i] == 0)) {
                    if (info[i] >= rCnt[i]) {
                        aTotal += (10 - i);
                    } else {
                        rTotal += (10 - i);
                    }
                }
            }
            
            if (result < rTotal - aTotal) {
                flag = true;
                result = rTotal - aTotal;
                
                int count = 0;
                for (int i = 0; i < 11; i++) {
                    answer[i] = rCnt[i];
                    count += rCnt[i];
                }
                
                if (count < total) {
                    answer[10] += total - count;
                }
            }
            
            return;
        }
        
        if (n >= info[10 - cnt] + 1) {
            rCnt[10 - cnt] = info[10 - cnt] + 1;
            recursion(cnt + 1, n - (info[10 - cnt] + 1));
            rCnt[10 - cnt] = 0;
        }
        
        recursion(cnt + 1, n); 
    }
}
