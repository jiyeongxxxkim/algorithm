import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] score = new int[n+1][n+1];
        for(int[] result : results){
            int win = result[0];
            int lose = result[1];
            score[win][lose] = 1;
            score[lose][win] = -1;
            
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(score[i][k]==1&&score[k][j]==1){
                        score[i][j] = 1;
                        score[j][i] = -1;
                    }
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            int count = 0;
            for(int j=1;j<=n;j++){
                if(score[i][j]!=0)count++;
            }
            if(count==(n-1)){
                answer++;
            }
        }
        
        return answer;
    }
}