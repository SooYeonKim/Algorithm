import java.util.*;

public class 로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < win_nums.length; i++) {
            set.add(win_nums[i]);
        }
        
        int zeroCnt = 0;
        int winCnt = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCnt++;
            } else {
                if (set.contains(lottos[i])) {
                    winCnt++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = findRanking(winCnt + zeroCnt);
        answer[1] = findRanking(winCnt);
        return answer;
    }
    
    private int findRanking(int cnt) {
        int ranking = 0;
        switch(cnt) {
            case 6:
                ranking = 1;
                break;
            case 5:
                ranking = 2;
                break;
            case 4:
                ranking = 3;
                break;
            case 3:
                ranking = 4;
                break;
            case 2:
                ranking = 5;
                break;
            default:
                ranking = 6;
                break;
        }
        
        return ranking;
    }
}
