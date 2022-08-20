
public class 숫자_문자열과_영단어_3 {
    public int solution(String s) {
        String[] numArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i <= 9; i++) {
            s = s.replace(numArr[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);
    }
}
