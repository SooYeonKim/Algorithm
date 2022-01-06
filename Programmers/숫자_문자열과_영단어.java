
public class 숫자_문자열과_영단어 {
    
    String[] array = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public int solution(String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                answer += Character.toString(s.charAt(i));
            } else {
                for (int j = 0; j < array.length; j++) {
                    if (s.charAt(i) != array[j].charAt(0)) continue;
                    if (s.charAt(i+1) != array[j].charAt(1)) continue;
                    
                    answer += Integer.toString(j);
                    i += (array[j].length() - 1);
                    break;
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
}
