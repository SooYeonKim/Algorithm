import java.util.*;

public class 양과_늑대 {
    
    int[] info;
    List<Integer>[] list;
    int answer;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        list = new ArrayList[info.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            list[edges[i][0]].add(edges[i][1]);
        }
        
        List<Integer> candidate = new ArrayList<>();
        candidate.add(0);
        dfs(0, 0, 0, candidate);
        return answer;
    }
    
    private void dfs(int loc, int wolf, int sheep, List<Integer> candidate) {
        if (info[loc] == 0) {
            answer = Math.max(answer, sheep + 1);
            sheep++;
        } else {
            if (wolf + 1 < sheep) {
                wolf++;
            } else {
                return;
            }
        }
        
        List<Integer> newCandidate = new ArrayList<>();
        newCandidate.addAll(candidate);
        for (int i = 0; i < list[loc].size(); i++) {
            newCandidate.add(list[loc].get(i));
        }
        newCandidate.remove(Integer.valueOf(loc));
        
        for (int i = 0; i < newCandidate.size(); i++) {
            dfs(newCandidate.get(i), wolf, sheep, newCandidate);
        }
    }
}
