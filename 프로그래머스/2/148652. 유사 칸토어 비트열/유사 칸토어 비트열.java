class Solution {
    
    // 1번째 글자부터 x번째 글자까지 포함된 '1'의 개수를 구하는 함수
    public long count(long x) {
        // x가 5 이하일 때는 패턴 "11011"을 기준으로 하드코딩된 값을 반환
        if (x <= 5) {
            int[] base = {0, 1, 2, 2, 3, 4};
            return base[(int)x];
        }
        
        // x를 덮을 수 있는 가장 큰 5의 거듭제곱(p5)과, 그 구간에 들어있는 1의 개수(p4)를 찾음
        long p5 = 1;
        long p4 = 1;
        
        while (p5 <= x / 5) {
            p5 *= 5;
            p4 *= 4;
        }
        
        // 전체 구간을 5등분 했을 때, 현재 x가 몇 번째 덩어리에 속하는지 계산
        long chunk = x / p5; 
        long rem = x % p5;   
        
        if (chunk < 2) {
            // 0, 1번째 덩어리 (모두 '1' 패턴)
            return chunk * p4 + count(rem);
        } else if (chunk == 2) {
            // 2번째 덩어리는 전부 '0'이므로 남은 나머지를 더할 필요 없음
            return chunk * p4; 
        } else {
            // 3, 4번째 덩어리 (2번째 덩어리가 0이므로, chunk에서 1을 빼고 계산)
            return (chunk - 1) * p4 + count(rem);
        }
    }
    
    public int solution(int n, long l, long r) {
        // r까지의 1의 개수에서 (l-1)까지의 1의 개수를 빼면 [l, r] 구간의 1의 개수가 나옴
        // 차이의 최댓값은 천만(10,000,000)이므로 int로 형변환해도 안전함
        return (int)(count(r) - count(l - 1));
    }
}