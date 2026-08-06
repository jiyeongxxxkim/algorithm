class Solution {
    public long solution(int w, int h) {
        // 전체 정사각형 개수 - 대각선이 지나가는 정사각형 개수
        long W = (long) w;
        long H = (long) h;
        
        return (W * H) - (W + H - gcd(w, h));
    }
    
    // 최대공약수(GCD) 구하기 (유클리드 호제법)
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}