
public class 키패드_누르기 {
    public String solution(int[] numbers, String hand) {
        int[][] loc = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        int[] left = {3, 0};
        int[] right = {3, 2};
        String answer = "";
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            if (temp == 1 || temp == 4 || temp == 7) {
                answer += "L";
                left[0] = loc[temp][0];
                left[1] = loc[temp][1];
            } else if (temp == 3 || temp == 6 || temp == 9) {
                answer += "R";
                right[0] = loc[temp][0];
                right[1] = loc[temp][1];
            } else {
                int ld = Math.abs(left[0] - loc[temp][0]) + Math.abs(left[1] - loc[temp][1]);
                int rd = Math.abs(right[0] - loc[temp][0]) + Math.abs(right[1] - loc[temp][1]);
                
                if (ld < rd) {
                    answer += "L";
                    left[0] = loc[temp][0];
                    left[1] = loc[temp][1];
                } else if (ld > rd) {
                    answer += "R";
                    right[0] = loc[temp][0];
                    right[1] = loc[temp][1];
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        left[0] = loc[temp][0];
                        left[1] = loc[temp][1];
                    } else {
                        answer += "R";
                        right[0] = loc[temp][0];
                        right[1] = loc[temp][1];
                    }
                }
            }
        }
        
        return answer;
    }
}
