class Solution {
    int result =0;
    int n;
    int trycnt;
    int[][] q;
    int[] ans;
    void dfs(int start, int depth, int[] arr){
        if(depth==5){
            if(chk(arr))result++;
            return;
        }
        for(int i=start;i<=n;i++){
            arr[depth] = i;
            dfs(i+1, depth+1, arr);
        }
    }
    boolean chk(int[] input){
        boolean codechk = true;
        for(int i=0;i<trycnt;i++){
            int cnt = 0;
            int[] codearr = q[i];
            for(int code=0;code<5;code++){
                for(int inputcnt = 0;inputcnt<5;inputcnt++){
                    if(codearr[code]==input[inputcnt])cnt++;
                }
            }if(cnt!=ans[i]){
                codechk = false;
                break;
            }
        }
        return codechk;
    }
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        int[] arr = new int[5];
        this.n = n;
        this.trycnt = ans.length;
        this.q = q.clone();
        this.ans = ans.clone();

        dfs(1,0,arr);
        return result;
    }
}