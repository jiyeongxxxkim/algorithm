import java.util.*;
class Solution {
    int getpoint(String minr, int gok){
        if(gok==0)return 1;
        else if(gok==1){
            if(minr.equals("diamond"))return 5;
            else return 1;
        }else{
            if(minr.equals("diamond"))return 25; 
            else if(minr.equals("iron"))return 5;
            else return 1;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int maxlen = 0;
        for(int p:picks)maxlen+=p;
        maxlen *= 5;
        maxlen = Math.min(maxlen, minerals.length);
        int[][] point = new int[minerals.length/5+1][3];
        for(int i=0;i<maxlen;i++){
            point[i/5][0] += getpoint(minerals[i],0);
            point[i/5][1] += getpoint(minerals[i],1);
            point[i/5][2] += getpoint(minerals[i],2);
        }
        Arrays.sort(point, (a,b)->{
            return b[2]-a[2];
        });
        
        for(int i=0;i<point.length;i++){
            if(picks[0]!=0){
                answer += point[i][0];
                picks[0]--;
            }else if(picks[1]!=0){
                answer += point[i][1];
                picks[1]--;
            }else if(picks[2]!=0){
                answer += point[i][2];
                picks[2]--;
            }
        }
        
        return answer;
    }
}