import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> points = new ArrayList<>();
        
        // 최소/최대 좌표를 저장할 변수 (초기값은 가장 극단적인 값으로 세팅)
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        // 1. 이중 for문을 돌며 모든 직선의 짝을 맞춰 교점 찾기
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                // 오버플로우 방지를 위해 미리 long 타입으로 받기
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                
                // 분모 계산
                long ad_bc = a * d - b * c;
                
                // 분모가 0이면 평행하거나 일치하므로 스킵
                if (ad_bc == 0) continue;
                
                // 분자 계산
                long bf_ed = b * f - e * d;
                long ec_af = e * c - a * f;
                
                // 2. 정수 좌표인지 확인 (나머지 연산)
                if (bf_ed % ad_bc == 0 && ec_af % ad_bc == 0) {
                    long x = bf_ed / ad_bc;
                    long y = ec_af / ad_bc;
                    
                    points.add(new long[]{x, y});
                    
                    // 3. 도화지 크기를 구하기 위해 최소/최대 좌표 갱신
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
            }
        }
        
        // 4. 별을 그릴 2차원 문자열 도화지 생성
        // 너비와 높이 구하기 (좌표는 음수도 있으므로 뺀 다음 +1)
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        
        char[][] grid = new char[height][width];
        
        // 도화지를 모두 '.' 으로 초기화
        for (int i = 0; i < height; i++) {
            Arrays.fill(grid[i], '.');
        }
        
        // 구해둔 정수 교점들에 '*' 찍기
        for (long[] p : points) {
            // 컴퓨터 배열은 위에서 아래로 내려갈수록 y가 커지므로 일반 수학 그래프와 반대로 매핑
            int r = (int) (maxY - p[1]); 
            // x 좌표는 가장 작은 값을 0번 인덱스로 당겨오기
            int c = (int) (p[0] - minX); 
            
            grid[r][c] = '*';
        }
        
        // char[][] 배열을 String[] 배열로 변환하여 반환
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grid[i]);
        }
        
        return answer;
    }
}