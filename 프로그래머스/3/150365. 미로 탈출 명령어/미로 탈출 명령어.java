class Solution {
    char[] direction = {'d', 'l', 'r', 'u'};
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    int n, m, r, c, k;
    String answer = null;
    
    void dfs(int cx, int cy, int dis, StringBuilder sb){
        if(answer!= null)return;
          
        int pathdis = Math.abs(cx-r)+Math.abs(cy-c);
        int minus = k-dis;
        if(minus<pathdis||(minus-pathdis)%2!=0)return;
        
        if(dis==k){
            if(cx==r&&cy==c){
                answer = sb.toString();
            }return;
        }
        
        for(int i=0;i<4;i++){
            int ntx = cx+dx[i];
            int nty = cy+dy[i];
            if(ntx>=1&&ntx<=n&&nty>=1&&nty<=m){
                sb.append(direction[i]);
                dfs(ntx, nty, dis+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;
        
        
        dfs(x, y, 0, new StringBuilder());
        
        
        return answer==null?"impossible":answer;
    }
}