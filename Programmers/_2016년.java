
public class _2016년 {
    public String solution(int a, int b) {
        int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] array = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int sum = b;
        for (int i = 0; i < a - 1; i++) {
            sum += day[i];
        }
        
        String answer = array[sum % 7];
        return answer;
    }
}
