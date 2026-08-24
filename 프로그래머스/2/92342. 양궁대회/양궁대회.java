class Solution {
    int maxdiff = 0;
    int[] maxarr = {-1};
    int calscore(int[] r, int[] a){
        int rs = 0;
        int ra = 0;
        for(int i=0;i<11;i++){
            if(r[i]!=0)rs+=(10-i);
            else if(r[i]!=a[i]) ra += (10-i);
        }return rs-ra;
    }
    void dfs(int idx, int leftarr, int[] arr, int[] apeach){
        if(idx==11||leftarr==0){
            arr[10]+=leftarr;
            int diff = calscore(arr, apeach);
            
            if(diff>0){
                if(diff>maxdiff){
                    maxdiff = diff;
                    maxarr = arr.clone();
                }else if(diff==maxdiff){
                    for(int i=10;i>=0;i--){
                        if(arr[i]>maxarr[i]){
                            maxarr = arr.clone();
                            break;
                        }else if(arr[i]<maxarr[i]){
                            break;
                        }
                    }
                }
            }
            
            arr[10] -= leftarr;
            return;
        }
        if(leftarr>apeach[idx]){
            arr[idx] = apeach[idx]+1;
            dfs(idx+1, leftarr-apeach[idx]-1, arr, apeach);
            arr[idx] = 0;
        }
        arr[idx] = 0;
        dfs(idx+1, leftarr, arr, apeach);
    }
    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        dfs(0, n, ryan, info);
        
        return maxarr;
    }
}