import java.util.*;
class Solution {
    int n;
    boolean buildchk(boolean[][]kd, boolean[][]bo){
        for(int x=0;x<=n;x++){
            for(int y=0;y<=n;y++){
                if(kd[x][y]){
                    if(!kdchk(x,y, kd, bo))return false;
                }
                if(bo[x][y]){
                    if(!bochk(x,y,kd,bo))return false;
                }
            }
        }
        return true;
    }
    boolean kdchk(int x, int y, boolean[][] kd, boolean[][] bo){
        if (y == 0) return true;
        if (y > 0 && kd[x][y - 1]) return true;
        if (bo[x][y] || (x > 0 && bo[x - 1][y])) return true;
        return false;
    }
    boolean bochk(int x, int y, boolean[][]kd, boolean[][]bo){
        if (y > 0 && kd[x][y - 1]) return true;
        if (x < n && y > 0 && kd[x + 1][y - 1]) return true;
        if (x > 0 && x < n && bo[x - 1][y] && bo[x + 1][y]) return true;
        return false;
    }
    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        boolean[][] kd = new boolean[n+1][n+1];
        boolean[][] bo = new boolean[n+1][n+1];
        int x=-1, y=-1;
        int type = -1, op = -1;
        boolean stepchk = true;
        for(int[] build:build_frame){
            x = build[0];
            y = build[1];
            type = build[2];
            op = build[3];
            if (type == 0) {
                kd[x][y] = (op == 1);
                if (!buildchk(kd, bo)) {
                    kd[x][y] = (op == 0);
                }
            } else {
                bo[x][y] = (op == 1);
                if (!buildchk(kd, bo)) {
                    bo[x][y] = (op == 0);
                }
            }
        }
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(kd[i][j])arr.add(new int[]{i, j, 0});
                if(bo[i][j])arr.add(new int[]{i, j, 1});
            }
        }
        int[][] answer = new int[arr.size()][3];
        for(int i=0;i<arr.size();i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}