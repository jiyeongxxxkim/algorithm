import java.util.*;
class Solution {
    int result = 0;
    int n;
    int[][] q;
    int[] ans;
    int[] arr;
    boolean chk(int[] arr){
        for(int i=0;i<q.length;i++){
            int[] chkarr = q[i];
            int cnt = 0;
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(arr[j]==chkarr[k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt!=ans[i])return false;
        }
        return true;
    }
    void dfs(int start, int depth, int[] arr){
        if(depth==5){
            if(chk(arr)){
                result++;
            }return;
        }
        for(int i=start;i<=n;i++){
            arr[depth] = i;
            dfs(i+1, depth+1, arr);
        }
    }
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q.clone();
        this.ans = ans.clone();
        arr = new int[5];
        dfs(1, 0, arr);
        return result;
    }
}