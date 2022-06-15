
public class 신규_아이디_추천 {
    public String solution(String new_id) {
        //1
        String answer = new_id.toLowerCase();
        
        //2
        String temp = "";
        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c - '0' >= 0 && c - '0' <= 9)
               || c == '-' || c == '_' || c == '.') {
                temp += c + "";
            }
        }
        answer = temp;
        
        //3
        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        
        //4
        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        
        //5
        if (answer.length() == 0) {
            answer = "a";
        }
        
        //6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        
        //7
        while (answer.length() <= 2) {
            answer += answer.charAt(answer.length() - 1);
        }
        
        return answer;
    }
}
