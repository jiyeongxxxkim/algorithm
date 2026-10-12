import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxal = 0;
        int maxco = 0;
        
        for(int[] p:problems){
            maxal = Math.max(maxal, p[0]);
            maxco = Math.max(maxco, p[1]);
        }
        
        alp = Math.min(alp, maxal);
        cop = Math.min(cop, maxco);
        
        int[][] dp = new int[maxal+2][maxco+2];
        for(int i=0;i<=maxal;i++){
            Arrays.fill(dp[i], 999999999);
        }
        dp[alp][cop] = 0;
        
        for(int i=alp;i<=maxal;i++){
            for(int j=cop;j<=maxco;j++){
                if(dp[i][j] == 999999999) continue;
                if(i+1<=maxal){
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                }
                if(j+1<=maxco){
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                }
                for(int[] p:problems){
                    int reqAlp = p[0], reqCop = p[1];
                    int rwdAlp = p[2], rwdCop = p[3], cost = p[4];
                    
                    if (i >= reqAlp && j >= reqCop) {
                        int nextAlp = Math.min(maxal, i + rwdAlp);
                        int nextCop = Math.min(maxco, j + rwdCop);
                        
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + cost);
                    }
                }
            }
        }
        
        return dp[maxal][maxco];
    }
}