import java.util.*;
class Solution {
    int[] stoi;
    int[] atoi;
    int[] btoi;
    int[][] graph;
    int n;
    void bfs(int[] arr, int start){
        arr[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            int cost = arr[cur];
            for(int g=1;g<=n;g++){
                if(graph[cur][g]!=0&&arr[g]>(cost+graph[cur][g])){
                    arr[g] = cost+graph[cur][g];
                    q.add(g);
                }
            }
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        stoi = new int[n+1];
        atoi = new int[n+1];
        btoi = new int[n+1];
        this.n = n;
        for(int i=1;i<=n;i++){
            stoi[i] = Integer.MAX_VALUE;
            atoi[i] = Integer.MAX_VALUE;
            btoi[i] = Integer.MAX_VALUE;
        }
        
        graph = new int[n+1][n+1];
        for(int[]f:fares){
            int st = f[0];
            int en = f[1];
            int co = f[2];
            
            graph[st][en] = co;
            graph[en][st] = co;
        }
        
        bfs(stoi, s);
        bfs(atoi, a);
        bfs(btoi, b);
        
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int sum = stoi[i]+atoi[i]+btoi[i];
            if(answer>sum)answer = sum;
        }
        
        
        return answer;
    }
}