
public class 다트_게임 {
    public int solution(String dartResult) {
        int[] array = new int[3];
        String temp = "";
        int idx = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            if (c == 'S') {
                array[idx++] = Integer.parseInt(temp);
                temp = "";
            } else if (c == 'D') {
                array[idx++] = (int)Math.pow(Integer.parseInt(temp), 2);
                temp = "";
            } else if (c == 'T') {
                array[idx++] = (int)Math.pow(Integer.parseInt(temp), 3);
                temp = "";
            } else if (c == '*') {
                array[idx-1] *= 2;
                if (idx-2 >= 0) array[idx-2] *= 2;
            } else if (c == '#') {
                array[idx-1] *= -1;
            } else {
                temp += c;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += array[i];
        }
        return answer;
    }
}
