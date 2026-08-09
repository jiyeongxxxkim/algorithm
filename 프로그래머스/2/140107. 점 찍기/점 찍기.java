class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        // x 좌표를 a * k (0, k, 2k, 3k ...)로 늘려가며 탐색
        for (long x = 0; x <= d; x += k) {
            // 원점과의 거리가 d 이하인 최대 y 좌표 구하기
            // x^2 + y^2 <= d^2  =>  y^2 <= d^2 - x^2  =>  y <= sqrt(d^2 - x^2)
            long maxY = (long) Math.sqrt((long) d * d - x * x);
            
            // y 좌표 역시 k의 배수만 가능하므로, 0부터 maxY까지 찍을 수 있는 점의 개수
            answer += (maxY / k) + 1;
        }
        
        return answer;
    }
}