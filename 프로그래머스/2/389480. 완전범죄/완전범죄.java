import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 999999);
        dp[0] = 0;
        for(int[] ins:info){
            int afill = ins[0];
            int bfill = ins[1];
            int[] ndp = new int[n];
            Arrays.fill(ndp, 999999);
            for(int i=0;i<n;i++){
                if(dp[i]==999999)continue;
                int na1 = i+afill;
                int nb1 = dp[i];
                if (na1 < n && nb1 < m) {
                    ndp[na1] = Math.min(ndp[na1], nb1);
                }
                
                int na2 = i;
                int nb2 = dp[i]+bfill;
                if (na2 < n && nb2 < m) {
                    ndp[na2] = Math.min(ndp[na2], nb2);
                }
            }
            dp = ndp;
        }
        for(int i=0;i<n;i++){
            if(dp[i]!=999999) return i;
        }
        return -1;
    }
}