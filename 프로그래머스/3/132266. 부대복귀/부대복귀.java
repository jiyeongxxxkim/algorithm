import java.util.*;
class Solution {
    int[] result;
    int destination;
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
        result = new int[sources.length];
        this.destination = destination;
        for(int i =0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<roads.length;i++){
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        for(int i=0;i<sources.length;i++){
            if(sources[i]==destination)result[i] = 0;
            else{
                visited = new boolean[n+1];
                count = new int[n+1];
                visited[sources[i]] = true;
                bfs(sources[i]);
                if(count[destination]==0){
                    result[i] = -1;
                }else{
                    result[i] = count[destination];
                }
            }
        }
        return result;
    }
}