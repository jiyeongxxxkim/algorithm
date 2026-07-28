import java.util.*;
class Solution {
    boolean[][] pillar;
    boolean[][] beam;
    int n;
    boolean pchk(int x, int y){
        if(x>0&&beam[x-1][y])return true;
        if(beam[x][y])return true;
        if(y==0)return true;
        if(y>0&&pillar[x][y-1])return true;
        return false;
    }
    boolean bchk(int x, int y){
        if(y>0&&pillar[x][y-1])return true;
        if(y>0&&pillar[x+1][y-1])return true;
        if(x>0&&beam[x-1][y]&&beam[x+1][y])return true;
        return false;
    }
    boolean allchk(){
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(pillar[i][j]&&!pchk(i,j))return false;
                if(beam[i][j]&&!bchk(i,j))return false;
            }
        }
        return true;
    }
    public int[][] solution(int n, int[][] build_frame) {
        
        this.n=n;
        pillar = new boolean[n+2][n+2];
        beam = new boolean[n+2][n+2];
        
        for(int[] build:build_frame){
            if(build[2]==0){
                if(build[3]==1){
                    pillar[build[0]][build[1]]=true;
                    if(!allchk())pillar[build[0]][build[1]]=false;
                }else{
                    pillar[build[0]][build[1]]=false;
                    if(!allchk())pillar[build[0]][build[1]]=true;
                }
            }else{
                if(build[3]==1){
                    beam[build[0]][build[1]]=true;
                    if(!allchk())beam[build[0]][build[1]]=false;
                }else{
                    beam[build[0]][build[1]]=false;
                    if(!allchk())beam[build[0]][build[1]]=true;
                }
            }
        }
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(pillar[i][j])result.add(new int[]{i,j,0});
                if(beam[i][j])result.add(new int[]{i,j,1});
            }
        }
        result.sort((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int[][] answer = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}