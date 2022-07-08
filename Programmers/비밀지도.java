
public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int temp = arr1[i] | arr2[i];
            String str = Integer.toBinaryString(temp);
            str = str.replace("1", "#");
            str = str.replace("0", " ");

            String sTemp = "";
            for (int j = 0; j < n - str.length(); j++) {
                sTemp += " ";
            }
            sTemp += str;
            answer[i] = sTemp;
        }
        return answer;
    }
}
