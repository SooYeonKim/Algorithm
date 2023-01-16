import java.util.*;

public class 이모티콘_할인행사 {
    
    int[][] users;
    int[] emoticons, selected;
    int[] sale = {10, 20, 30, 40};
    List<Emoticon> list;
    
    class Emoticon implements Comparable<Emoticon> {
        int cnt;
        int money;
        
        public Emoticon(int cnt, int money) {
            this.cnt = cnt;
            this.money = money;
        }
        
        @Override
        public int compareTo(Emoticon o) {
            if (o.cnt == this.cnt) {
                return o.money - this.money;
            }
            return o.cnt - this.cnt;
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        selected = new int[emoticons.length];
        list = new ArrayList<>();
        
        selectSale(0);
        Collections.sort(list);
        
        int[] answer = new int[2];
        answer[0] = list.get(0).cnt;
        answer[1] = list.get(0).money;
        return answer;
    }
    
    private void selectSale(int cnt) {
        if (cnt == emoticons.length) {
            cal();
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            selected[cnt] = sale[i];
            selectSale(cnt + 1);
        }
    }
    
    private void cal() {
        int cnt = 0;
        int money = 0;
        for (int i = 0; i < users.length; i++) {
            int percent = users[i][0];
            int price = users[i][1];
            int sum = 0;
            for (int j = 0; j < emoticons.length; j++) {
                if (selected[j] >= percent) {
                    sum += (emoticons[j] * (100 - selected[j]) / 100);
                }
            }
            
            if (sum >= price) {
                cnt++;
            } else {
                money += sum;
            }
        }
        
        list.add(new Emoticon(cnt, money));
    }
}
