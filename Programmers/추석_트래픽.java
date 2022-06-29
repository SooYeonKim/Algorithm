
public class 추석_트래픽 {
    public int solution(String[] lines) {
        double[][] timeArr = new double[lines.length][2];
        for (int i = 0; i < lines.length; i++) {
            String[] temp = lines[i].split(" ");
            String[] tArr = temp[1].split(":");
            double endTime = Double.parseDouble(tArr[0]) * 3600 + Double.parseDouble(tArr[1]) * 60 + Double.parseDouble(tArr[2]);
            double startTime = endTime - Double.parseDouble(temp[2].split("s")[0]) + 0.001;
            timeArr[i][0] = startTime;
            timeArr[i][1] = endTime;
        }
        
        int answer = 0;
        for (int i = 0; i < lines.length; i++) {
            double endTime = timeArr[i][1];
            int cnt = 0;
            for (int j = i; j < lines.length; j++) {
                double startTime = timeArr[j][0];
                if (startTime < endTime + 1) {
                    cnt++;
                }
            }
            
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}
