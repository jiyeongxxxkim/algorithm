import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> graph;
    boolean[] visited;
    public int bfs(int start, int skip){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int count  = 1;
        visited[start] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i:graph.get(cur)){
                if(!visited[i]&&i!=skip){
                    visited[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
        return count;
    }
    public int solution(int n, int[][] wires) {
        int answer = -1;
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        int min = Integer.MAX_VALUE;
        int minus = 0;
        for(int i=0;i<n-1;i++){
            visited = new boolean[n+1];
            int A = bfs(wires[i][0], wires[i][1]);
            int B = n - A;
            minus = Math.abs(A - B);
            min = Math.min(min, minus);
        }
        
        return min;
    }
}