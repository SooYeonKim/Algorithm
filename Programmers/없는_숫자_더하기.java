
public class 없는_숫자_더하기 {
    public int solution(int[] numbers) {
        boolean[] check = new boolean[10];
        for (int i = 0; i < numbers.length; i++) {
            check[numbers[i]] = true;
        }
        
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            if (!check[i]) answer += i;
        }
        return answer;
    }
}
