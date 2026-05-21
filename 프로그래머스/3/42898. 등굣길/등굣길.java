import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n+1][m+1];
        
        for(int[] p : puddles){
            map[p[1]][p[0]] = -1;
        }   
        for(int r=0;r<=n;r++){
            map[r][0] = 0;
        }
        for(int c=0;c<=m;c++){
                map[0][c] =0;
        }
        
        map[1][1] = 1;
        
        for(int r=1;r<=n;r++){
            for(int c=1;c<=m;c++){
                if(map[r][c] ==0){
                    map[r][c] = (map[r-1][c]%1_000_000_007)+(map[r][c-1]%1_000_000_007);
                }else if(map[r][c]==-1){
                    map[r][c] = 0;
                }
            }
        }
        answer = map[n][m]%1_000_000_007;
        return answer;
    }
}