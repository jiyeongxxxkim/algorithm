import java.util.*;
class Solution {
    int pluscont = 0;
    int emoticonsales = 0;
    int[] salepercent = {10,20,30,40};
    void dfs(int depth, int[][] users, int[] emoticons, int[] percent){
        if(depth==emoticons.length){
            calcul(percent, users, emoticons);
            return;
        }
        for(int i=0;i<4;i++){
            percent[depth] = salepercent[i];
            dfs(depth+1, users, emoticons, percent);
        }
    }
    void calcul(int[] percent, int[][] users, int[] emoticons){
        int temp_pluscont = 0;
        int temp_emoticonsales =0;
        for(int[] user:users){
            int usersalesum = 0;
            int userpercent = user[0];
            int usersalemax = user[1];
            for(int i=0;i<percent.length;i++){
                if(userpercent<=percent[i]){
                    usersalesum += emoticons[i]*(100-percent[i])/100;
                }
            }
            if(usersalesum >= usersalemax)temp_pluscont++;
            else temp_emoticonsales += usersalesum;
        }
        if(pluscont==temp_pluscont){
            emoticonsales = Math.max(emoticonsales, temp_emoticonsales);
        }else if(pluscont<temp_pluscont){
            pluscont = temp_pluscont;
            emoticonsales = temp_emoticonsales;

        }
        
    }
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        int[] percent = new int[emoticons.length];
        dfs(0, users, emoticons, percent);
        
        answer[0] = pluscont;
        answer[1] = emoticonsales;
        
        return answer;
    }
}