class Solution {
    long calcu(int n, long idx){
        
        if(n==0)return 1;
        if(idx<0)return 0;
        
        long p5 = (long)Math.pow(5, n-1);
        long p4 = (long)Math.pow(4, n-1);
        
        long chunck = idx/p5;
        long remain = idx%p5;
        
        if(chunck<2){
            return p4*chunck+calcu(n-1, remain);
        }else if(chunck==2){
            return p4*chunck;
        }else{
            return p4*(chunck-1)+calcu(n-1, remain);
        }
    }
    public int solution(int n, long l, long r) {
        int answer = 0;
        answer = (int)(calcu(n, r-1)-calcu(n, l-2));
        return answer;
    }
}