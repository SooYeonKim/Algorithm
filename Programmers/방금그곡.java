import java.util.*;

public class 방금그곡 {
    
    class Music implements Comparable<Music> {
        int no;
        int time;
        String title;
        
        public Music(int no, int time, String title) {
            this.no = no;
            this.time = time;
            this.title = title;
        }
        
        @Override
        public int compareTo(Music o) {
            if (this.time == o.time) {
                return this.no - o.no;
            }
            return o.time - this.time;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        Map<String, String> map = new HashMap<>();
        map.put("C#", "c");
        map.put("D#", "d");
        map.put("F#", "f");
        map.put("G#", "g");
        map.put("A#", "a");
        
        for (String s : map.keySet()) {
            m = m.replace(s, map.get(s));
        }
        
        List<Music> result = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            String[] sTimeArr = info[0].split(":");
            String[] eTimeArr = info[1].split(":");
            int time = Integer.parseInt(eTimeArr[0]) * 60 + Integer.parseInt(eTimeArr[1])
                - (Integer.parseInt(sTimeArr[0]) * 60 + Integer.parseInt(sTimeArr[1]));
            
            for (String s : map.keySet()) {
                info[3] = info[3].replace(s, map.get(s));
            }
            
            String str = "";
            for (int j = 0; j < time; j++) {
                str += info[3].charAt(j % info[3].length());
            } 
            
            if (str.contains(m)) {
                result.add(new Music(i, time, info[2]));
            }
        }
        
        Collections.sort(result);
        
        if (result.size() == 0) {
            return new String("(None)");
        } else {
            return result.get(0).title;
        }
    }
}
