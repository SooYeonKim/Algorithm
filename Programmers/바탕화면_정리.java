
public class 바탕화면_정리 {
    public int[] solution(String[] wallpaper) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char c = wallpaper[i].charAt(j);
                if (c == '#') {
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i + 1);
                    maxC = Math.max(maxC, j + 1);
                }
            }
        }
        
        int[] answer = new int[4];
        answer[0] = minR;
        answer[1] = minC;
        answer[2] = maxR;
        answer[3] = maxC;
        return answer;
    }
}
