import java.util.*;

public class 수식_최대화 {
    
    List<Long> numList;
    List<Character> opList;
    char[] op = {'+', '-', '*'};
    char[] selected;
    boolean[] visited;
    long answer;
    
    public long solution(String expression) {
        numList = new ArrayList<>();
        opList = new ArrayList<>();
        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                num += c;
            } else {
                numList.add(Long.parseLong(num));
                num = "";
                opList.add(c);
            }
        }
        numList.add(Long.parseLong(num));
        
        selected = new char[3];
        visited = new boolean[3];
        permutation(0);
        
        return answer;
    }
    
    private void permutation(int cnt) {
        if (cnt == 3) {
            List<Long> tempNumList = new ArrayList<>();
            List<Character> tempOpList = new ArrayList<>();
            for (Long l : numList) {
                tempNumList.add(l);
            }
            for (Character c : opList) {
                tempOpList.add(c);
            }
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < tempOpList.size(); j++) {
                    if (tempOpList.get(j) == selected[i]) {
                        switch(tempOpList.get(j)) {
                            case '+':
                                tempNumList.set(j, tempNumList.get(j) + tempNumList.get(j+1));
                                break;
                            case '-':
                                tempNumList.set(j, tempNumList.get(j) - tempNumList.get(j+1));
                                break;
                            case '*':
                                tempNumList.set(j, tempNumList.get(j) * tempNumList.get(j+1));
                                break;
                        }
                        
                        tempNumList.remove(j+1);
                        tempOpList.remove(j);
                        j--;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(tempNumList.get(0)));
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            selected[cnt] = op[i];
            permutation(cnt + 1);
            visited[i] = false;
        }
    }
}
