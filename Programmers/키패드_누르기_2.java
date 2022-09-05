
public class 키패드_누르기_2 {
    public String solution(int[] numbers, String hand) {
        int[][] array = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        String answer = "";
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            if (num == 1 || num == 4 || num == 7) {
                answer += "L";
                left[0] = array[num][0];
                left[1] = array[num][1];
            } else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                right[0] = array[num][0];
                right[1] = array[num][1];
            } else {
                int ld = Math.abs(array[num][0] - left[0]) + Math.abs(array[num][1] - left[1]);
                int rd = Math.abs(array[num][0] - right[0]) + Math.abs(array[num][1] - right[1]);
                
                if (ld < rd) {
                    answer += "L";
                    left[0] = array[num][0];
                    left[1] = array[num][1];
                } else if (ld > rd) {
                    answer += "R";
                    right[0] = array[num][0];
                    right[1] = array[num][1];
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        left[0] = array[num][0];
                        left[1] = array[num][1];
                    } else {
                        answer += "R";
                        right[0] = array[num][0];
                        right[1] = array[num][1];
                    }
                }
            }
        }
        return answer;
    }
}
