import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        for(int i=0;i<k;i++){
            q.add(0);
        }
        int curserver = 0;
        int player = 0;
        for(int i=0;i<24;i++){
            curserver -= q.poll();
            player = players[i];
            if(player>=(curserver+1)*m){
                q.add((player/m-curserver));
                answer+=(player/m-curserver);
                curserver = player/m;
            }else{
                q.add(0);
            }
        }
        return answer;
    }
}