
public class 서울에서_김서방_찾기 {
    public String solution(String[] seoul) {
        int idx = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                idx = i;
            }
        }
        
        String answer = "김서방은 " + idx + "에 있다";
        return answer;
    }
}
