class Solution {
    public long solution(int w, int h) {
        long W = (long) w;
        long H = (long) h;
        
        return (W * H) - (W + H - gcd(w, h));
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}