
public class 롤케이크_자르기 {
    public int solution(int[] topping) {
        int[] array1 = new int[10001];
        int[] array2 = new int[10001];
        int cnt1 = 0;
        int cnt2 = 0;
        
        for (int i = 0; i < topping.length; i++) {
            int num = topping[i];
            if (array1[num] == 0) cnt1++;
            array1[num]++;
        }
        
        int answer = 0;
        for (int i = 0; i < topping.length; i++) {
            int num = topping[i];
            array1[num]--;
            if (array1[num] == 0) cnt1--;
            if (array2[num] == 0) cnt2++;
            array2[num]++;
            
            if (cnt1 == cnt2) answer++;
        }
        
        return answer;
    }
}
