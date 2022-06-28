import java.util.*;

public class 후보키 {
    
    String[][] relation;
    Set<Integer> result;
    int N;
    int target;
    int[] selected;
    
    public int solution(String[][] relation) {
        this.relation = relation;
        result = new HashSet<>();
        N = relation[0].length;
        
        for (int i = 1; i < N+1; i++) {
            target = i;
            selected = new int[i];
            combination(0, 0);
        }
        
        return result.size();
    }
    
    //키 조합
    private void combination(int cnt, int start) {
        if (cnt == target) {
            if (!isUnique()) return;
            
            int num = 0;
            for (int i = 0; i < selected.length; i++) {
                num |= 1 << selected[i];
            }
            if (!isMin(num)) return;
            
            result.add(num);
            return;
        }
        
        for (int i = start; i < N; i++) {
            selected[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }
    
    //유일성 체크
    private boolean isUnique() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            String str = "";
            for (int j = 0; j < selected.length; j++) {
                str += relation[i][selected[j]];
            }
            
            if (set.contains(str)) return false;
            set.add(str);
        }
        
        return true;
    }
    
    //최소성 체크
    private boolean isMin(int num) {
        for(Integer i : result) {
            if ((i & num) == i) return false;
        }
        
        return true;
    }
}
