class Solution {
    long gcd(long a, long b){
        if(b==0)return a;
        return gcd(b, a%b);
    }
    public long solution(int w, int h) {
        long W = (long) w;
        long H = (long) h;
        
        return (W * H) - (W + H - gcd(w, h));
    }
    
  
}