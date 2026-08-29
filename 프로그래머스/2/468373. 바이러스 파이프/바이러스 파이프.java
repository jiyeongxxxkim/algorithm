import java.util.*;
class Solution {
    List<int[]> course;
    int k;
    List<int[]>[] graph;
    boolean[] infections;
    void dfs(int depth, int[] arr){
        if(depth==k){
            course.add(arr.clone());
            return;
        }
        for(int i=1;i<4;i++){
            if(arr[depth-1]!=i){
                arr[depth] = i;
                dfs(depth+1, arr);
            }
        }  
    }
    int bfs(int start, int[] cou, int n){
        boolean[] infections = new boolean[n + 1];
        infections[start] = true;
        int type = -1;
        for(int i=0;i<cou.length;i++){
            type = cou[i];
            
            Queue<Integer> q = new LinkedList<>();
        
            for(int node = 1;node<=n;node++){
                if(infections[node])q.add(node);
            }

            while(!q.isEmpty()){
                int cur = q.poll();

                for(int[] nt:graph[cur]){
                    int next = nt[0];
                    int nexttype = nt[1];

                    if(!infections[next]&&nexttype==type){
                        infections[next] = true;
                        q.add(next);
                    }
                }
            }
            
        }
        
        
        int count = 0;
        for(boolean chk:infections){
            if(chk)count++;
        }
        return count;
    }
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;
        this.k = k;
        course = new ArrayList<>();
        for(int i=1;i<4;i++){
            int[] arr = new int[k];
            arr[0] = i;
            dfs(1, arr);
        }
        graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int type = edge[2];
            graph[u].add(new int[]{v, type});
            graph[v].add(new int[]{u, type});
        }
        
        int maxinfection = 0;
        
        for(int[] cou:course){
            maxinfection = Math.max(maxinfection, bfs(infection, cou, n));
        }
        
        return maxinfection;
    }
}