
public class 둘만의_암호 {
    public String solution(String s, String skip, int index) {
        boolean[] check = new boolean[26];
        for (int i = 0; i < skip.length(); i++) {
            check[skip.charAt(i) - 'a'] = true;
        }
        
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            int temp = index;
            while (temp-- > 0) {
                if (++num >= 26) num %= 26;
                if (check[num]) temp++;
            }
            
            answer += (char)('a' + num);
        }
        return answer;
    }
}
