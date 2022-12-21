
public class 푸드_파이트_대회 {
    public String solution(int[] food) {
        int[] cnt = new int[food.length];
        for (int i = 1; i < food.length; i++) {
            cnt[i] = food[i] / 2;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append(i);
            }
        }
        
        sb.append("0");
        
        for (int i = food.length - 1; i >= 1; i--) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}
