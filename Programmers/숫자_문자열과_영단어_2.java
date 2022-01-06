
public class 숫자_문자열과_영단어_2 {
    
    String[] array = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public int solution(String s) {
        for (int i = 0; i < array.length; i++) {
            s = s.replace(array[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);
    }
}
