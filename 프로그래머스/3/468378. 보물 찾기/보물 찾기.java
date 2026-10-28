import java.util.function.Function;
import java.util.*;
class Solution {
    public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        // for(int i = 1; i <= depth.length; i++)
        //     if (excavate.apply(i) == 0) System.out.println(i);
        int n = depth.length;
        int[][] dp = new int[n+2][n+2];
        int[][] opt = new int[n+2][n+2]; 
        
        for(int i=1;i<=n;i++){
            dp[i][i] = depth[i-1];
            opt[i][i] = i;
        }
        
        for(int len=2;len<=n;len++){
            for(int left=1;left<=(n-len+1);left++){
                int right = left+len-1;
                dp[left][right] = Integer.MAX_VALUE;
                for(int k=left;k<=right;k++){
                    int wrcase = Math.max(dp[left][k-1], dp[k+1][right]);
                    int curcost = wrcase+depth[k-1];
                    if(dp[left][right]>curcost){
                        dp[left][right] = curcost;
                        opt[left][right] = k;
                    }
                }
            }
        }
        int left = 1;
        int right = n;
        while(left<=right){
            int k = (left==right)?left:opt[left][right];
            int cost = excavate.apply(k);
            if(cost==0)return k;
            else if(cost==-1)right = k-1;
            else left = k+1;
        }
        
        return 0;
    }
}