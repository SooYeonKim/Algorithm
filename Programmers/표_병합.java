import java.util.*;

public class 표_병합 {
    
    int[] parentArr;
    String[] valueArr;
    List<String> list;
    
    public String[] solution(String[] commands) {
        parentArr = new int[2501];
        valueArr = new String[2501];
        list = new ArrayList<>();
        
        for (int i = 1; i <= 2500; i++) {
            parentArr[i] = i;
            valueArr[i] = "";
        }
        
        for (int i = 0; i < commands.length; i++) {
            String[] sArr = commands[i].split(" ");
            String cmd = sArr[0];
            
            if (cmd.equals("UPDATE") && sArr.length == 4) {
                int r = Integer.parseInt(sArr[1]);
                int c = Integer.parseInt(sArr[2]);
                String value = sArr[3];
                
                int parent = find(50 * (r - 1) + c);
                valueArr[parent] = value;
            } else if (cmd.equals("UPDATE") && sArr.length == 3) {
                String value1 = sArr[1];
                String value2 = sArr[2];
                
                for (int j = 1; j <= 2500; j++) {
                    if (valueArr[j].equals(value1)) {
                        valueArr[j] = value2;
                    }
                }
            } else if (cmd.equals("MERGE")) {
                int r1 = Integer.parseInt(sArr[1]);
                int c1 = Integer.parseInt(sArr[2]);
                int r2 = Integer.parseInt(sArr[3]);
                int c2 = Integer.parseInt(sArr[4]);
                
                int parent1 = find(50 * (r1 - 1) + c1);
                int parent2 = find(50 * (r2 - 1) + c2);
                String value1 = valueArr[parent1];
                String value2 = valueArr[parent2];
                
                if (parent1 == parent2) continue;
                
                String value = value2;
                if (!value1.equals("")) value = value1;
                
                union(parent1, parent2);
                valueArr[parent2] = "";
                valueArr[parent1] = value;
            } else if (cmd.equals("UNMERGE")) {
                int r = Integer.parseInt(sArr[1]);
                int c = Integer.parseInt(sArr[2]);
                
                int parent = find(50 * (r - 1) + c);
                String value = valueArr[parent];
                valueArr[parent] = "";
                
                List<Integer> removeList = new ArrayList<>();
                for (int j = 1; j <= 2500; j++) {
                    if (find(j) == parent) {
                        removeList.add(j);
                    }
                }
                for (int j = 0; j < removeList.size(); j++) {
                    int temp = removeList.get(j);
                    parentArr[temp] = temp;
                }
                
                valueArr[50 * (r - 1) + c] = value;
            } else if (cmd.equals("PRINT")) {
                int r = Integer.parseInt(sArr[1]);
                int c = Integer.parseInt(sArr[2]);
                
                int parent = find(50 * (r - 1) + c);
                if (valueArr[parent].length() != 0) {
                    list.add(valueArr[parent]);
                } else {
                    list.add("EMPTY");
                }
            }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private int find(int a) {
        if (a == parentArr[a]) return a;
        return parentArr[a] = find(parentArr[a]);
    }
    
    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if (pa != pb) {
            parentArr[pb] = pa;
        }
    }
}
