import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < record.length; i++) {
            String[] sArray = record[i].split(" ");
            String cmd = sArray[0];
            String uid = sArray[1];   
            
            if (cmd.equals("Enter") || cmd.equals("Change")) {
                String nickname = sArray[2];
                map.put(uid, nickname);
            }
            if (!cmd.equals("Change")) cnt++;
        }
        
        String[] answer = new String[cnt];
        int idx = 0;
        for (int i = 0; i < record.length; i++) {
            String[] sArray = record[i].split(" ");
            String cmd = sArray[0];
            String uid = sArray[1];
            
            if (cmd.equals("Change")) continue;
            if (cmd.equals("Enter")) {
                answer[idx++] = map.get(uid) + "님이 들어왔습니다.";
            } else {
                answer[idx++] = map.get(uid) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
