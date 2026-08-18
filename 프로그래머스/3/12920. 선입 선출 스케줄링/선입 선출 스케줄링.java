class Solution {
    public int solution(int n, int[] cores) {
        if(cores.length>=n)return n;
        
        int maxcore = 0;
        for(int c:cores)maxcore = Math.max(maxcore, c);
        
        long left = 0;
        long right = (n/cores.length)*maxcore;
        long time = right;
        
        while(left<=right){
            long mid = (left+right)/2;
            long work = cores.length;
            for(int c:cores){
                work += (mid/c);
            }
            if(work>=n){
                time = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        long work = cores.length;
        for(int c:cores){
            work += (time-1)/c;
        }
        for(int i=0;i<cores.length;i++){
            if(time%cores[i]==0){ 
                work++;
                if(work==n){
                return i+1;
            }
            }
        }
        return 0;
    }
}