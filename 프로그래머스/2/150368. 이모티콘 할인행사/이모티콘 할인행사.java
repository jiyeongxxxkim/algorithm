import java.util.*;
class Solution {
    int[] currentDiscounts; 
    int[] rates = {10, 20, 30, 40};
    int maxPlus = 0;
    int maxSales = 0;
    void dfs(int[][] users, int[] emoticons, int depth){
        if(depth==emoticons.length){
            calculator(users, emoticons);
            return;
        }
        for(int i=0;i<4;i++){
            currentDiscounts[depth] = rates[i];
            dfs(users, emoticons, depth+1);
        }
    }
    void calculator(int[][] users, int[] emoticons){
        int pluscont = 0;
        int sales = 0;
        for(int[] user:users){
            int discount = user[0];
            int maxsale = user[1];
            int usersalesum = 0;
            for(int i=0;i<emoticons.length;i++){
                if(currentDiscounts[i]>=discount)usersalesum += emoticons[i]*(100-currentDiscounts[i])/100;
            }
            if(usersalesum>=maxsale){
                pluscont++;
            }else{
                sales += usersalesum;
            }
        }if(maxPlus<pluscont){
            maxPlus = pluscont;
            maxSales = sales;
        }else if(maxPlus==pluscont){
            maxSales = Math.max(maxSales, sales);
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        currentDiscounts = new int[emoticons.length]; 
        
        dfs(users, emoticons, 0);
        answer[0] = maxPlus;
        answer[1] = maxSales;
        return answer;
    }
}