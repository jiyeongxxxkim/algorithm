import java.util.*;
class Solution {
    boolean smatch(String total, String m){
        if(total.contains(m))return true;
        return false;
    }
    public String solution(String m, String[] musicinfos) {
        int[] answerint = {-1,0};
        for(int j=0;j<musicinfos.length;j++){
            String music = musicinfos[j];
            String[] msplit = music.split(",");
            String remusic = msplit[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#","g").replace("A#", "a");
            int len = remusic.length();
            int musicTime = Integer.parseInt(msplit[1].split(":")[0])*60+Integer.parseInt(msplit[1].split(":")[1])-Integer.parseInt(msplit[0].split(":")[0])*60-Integer.parseInt(msplit[0].split(":")[1]);
            StringBuilder sb  = new StringBuilder();
            int index = 0;
            for(int i=0;i<musicTime;i++){
                index = index%len;
                sb.append(remusic.charAt(index++));
            }
            m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#","g").replace("A#", "a");
            if(smatch(sb.toString(), m)){
                if(answerint[0]==-1||answerint[1]<musicTime){
                    answerint[0] = j;answerint[1] = musicTime;
                }
            }
        }
        if(answerint[0]!=-1)return musicinfos[answerint[0]].split(",")[2];
        return "(None)";
    }
}