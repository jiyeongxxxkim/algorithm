import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 999999);
        dp[0] = 0;
        for(int[] in:info)
        {
            int afill = in[0];
            int bfill = in[1];
            int[] cdp = new int[n];
            Arrays.fill(cdp, 999999);
            for(int i=0;i<n;i++){
                if(dp[i]==999999)continue;
                int a1 = i+afill;
                int b1 = dp[i];
                if(a1<n&&b1<m){
                    cdp[a1] = Math.min(cdp[a1], b1);
                }
                int a2 = i;
                int b2 = dp[i]+bfill;
                if(a2<n&&b2<m){
                    cdp[a2] = Math.min(cdp[a2], b2);
                }
            }
            dp = cdp;
        }
        for(int i=0;i<n;i++){
                if(dp[i]!=999999)return i;
            }
        return -1;
    }
}