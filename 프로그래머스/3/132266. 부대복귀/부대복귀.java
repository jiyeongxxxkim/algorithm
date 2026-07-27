import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    int[] count;
    void bfs(int start){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        count[start] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int g:graph.get(cur)){
                if(!visited[g]){
                    visited[g] = true;
                    q.add(g);
                    count[g] = count[cur]+1;
                }
            }
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] result = new int[sources.length];
        count = new int[n+1];
        visited = new boolean[n+1];
        for(int i=0;i<=n;i++)count[i] = -1;
        
        for(int i =0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<roads.length;i++){
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        
        visited[destination] = true;
        count[destination] = 0;
        bfs(destination);
        for(int i=0;i<sources.length;i++){
            result[i] = count[sources[i]];
        }
        return result;
    }
}