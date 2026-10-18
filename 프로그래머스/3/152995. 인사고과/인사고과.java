import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int ya = scores[0][0];
        int yb = scores[0][1]; 
        int answer = 1;
        
        Arrays.sort(scores, (a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            return b[0]-a[0];
        });
        
        int maxv = -1;
        for(int i=0;i<scores.length;i++){
            int[] sco = scores[i];
            
            if(sco[1] < maxv) {
                if(sco[0] == ya && sco[1] == yb) {
                    return -1; 
                }
            } 
            else {
                maxv = Math.max(maxv, sco[1]);

                if(sco[0] + sco[1] > (ya+yb)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}