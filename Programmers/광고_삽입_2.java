
public class 광고_삽입_2 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int pTime = convertToInt(play_time);
        int aTime = convertToInt(adv_time);
        int[] cnt = new int[pTime];
        
        for (int i = 0; i < logs.length; i++) {
            String[] array = logs[i].split("-");
            int sTime = convertToInt(array[0]);
            int eTime = convertToInt(array[1]);
            
            for (int j = sTime; j < eTime; j++) {
                cnt[j]++;
            }
        }
        
        long[] prefixSum = new long[pTime];
        prefixSum[0] = cnt[0];
        for (int i = 1; i < pTime; i++) {
            prefixSum[i] = prefixSum[i-1] + cnt[i];
        }
        
        int idx = 0;
        long maxSum = prefixSum[aTime - 1];
        for (int i = 0; i < pTime - aTime; i++) {
            long sum = prefixSum[i + aTime] - prefixSum[i];
            if (sum > maxSum) {
                idx = i + 1;
                maxSum = sum;
            }
        }
        return convertToString(idx);
    }
    
    private int convertToInt(String str) {
        String[] array = str.split(":");
        int sum = Integer.parseInt(array[0]) * 3600 + Integer.parseInt(array[1]) * 60 + Integer.parseInt(array[2]);
        return sum;
    }
    
    private String convertToString(long num) {
        long hour = num / 3600;
        num -= (3600 * hour);
        long minute = num / 60;
        num -= (60 * minute);
        
        String str = "";
        if (Long.toString(hour).length() == 1) {
            str += "0";
        }
        str += hour + ":";
        if (Long.toString(minute).length() == 1) {
            str += "0";
        }
        str += minute + ":";
        if (Long.toString(num).length() == 1) {
            str += "0";
        }
        str += num;
        return str;
    }
}
