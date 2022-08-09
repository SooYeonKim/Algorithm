import java.util.*;

public class 파일명_정렬 {
    public String[] solution(String[] files) {
        String[][] array = new String[files.length][3];
        
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            String HEAD = "";
            String NUMBER = "";
            String TAIL = "";
            
            int idx = 0;
            while (idx < file.length()) {
                char c = file.charAt(idx);
                if (c >= '0' && c <= '9') {
                    break;
                }
                
                HEAD += c;
                idx++;
            }
            
            while (idx < file.length()) {
                char c = file.charAt(idx);
                if (c < '0' || c > '9') {
                    break;
                }
                
                NUMBER += c;
                idx++;
            }
            
            while (idx < file.length()) {
                char c = file.charAt(idx);
                TAIL += c;
                idx++;
            }
            
            array[i][0] = HEAD;
            array[i][1] = NUMBER;
            array[i][2] = TAIL;
        }
        
        Arrays.sort(array, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].toLowerCase().equals(o2[0].toLowerCase())) {
                    return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
                }
                
                return o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
            }
        });
        
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = array[i][0] + array[i][1] + array[i][2];
        }
        return answer;
    }
}
