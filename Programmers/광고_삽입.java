
public class 광고_삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = convertToInt(play_time);
        int advTime = convertToInt(adv_time);
        int[] count = new int[playTime];
        
        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            String[] sArray = log.split("-");
            
            int sTime = convertToInt(sArray[0]);
            int eTime = convertToInt(sArray[1]);
            for (int j = sTime; j < eTime; j++) {
                count[j]++;
            }
        }
        
        int maxIdx = 0;
        long maxSum = 0;
        long sum = 0;
        for (int i = 0; i < advTime; i++) {
            sum += count[i];
        }
        maxSum = sum;
        
        for (int i = advTime; i < playTime; i++) {
            sum += (count[i] - count[i - advTime]);
            
            if (sum > maxSum) {
                maxIdx = i - advTime + 1;
                maxSum = sum;
            }
        }
        
        String answer = convertToString(maxIdx);
        return answer;
    }
    
    private int convertToInt(String log) {
        String[] sArray = log.split(":");
        int time = Integer.parseInt(sArray[0]) * 3600 + Integer.parseInt(sArray[1]) * 60 + Integer.parseInt(sArray[2]);
        
        return time;
    }
    
    private String convertToString(int time) {
        String str = "";
        
        int hour = time / 3600;
        time -= (time / 3600) * 3600;
        if (hour < 10) {
            str += "0" + hour + ":";
        } else {
            str += hour + ":";
        }
        
        int minute = time / 60;
        time -= (time / 60) * 60;
        if (minute < 10) {
            str += "0" + minute + ":";
        } else {
            str += minute + ":";
        }
        
        if (time < 10) {
            str += "0" + time;
        } else {
            str += time;
        }
        
        return str;
    }
}
