import java.util.*;
class Solution {
    public long solution(int[] a, int[][] edges) {
        long[] are = new long[a.length];
        ArrayList<ArrayList<Integer>> graph;
        long count = 0;
        boolean[] visited = new boolean[a.length];
        for(int i=0;i<a.length;i++)are[i] = (long)a[i];
        
        long weightsum = 0;
        for(int aitem:a)weightsum+=aitem;
        if(weightsum!=0)return -1;
        
        graph = new ArrayList<>();
        for(int i=0;i<a.length;i++)graph.add(new ArrayList<>());
        
        int[] depth = new int[a.length];
        for(int[]e :edges){
            depth[e[0]]++;
            depth[e[1]]++;
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<depth.length;i++){
            if(depth[i]==1)q.add(i);
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            for(int nex:graph.get(cur)){
                if(!visited[nex]){
                    depth[nex]--;
                    depth[cur]--;
                    count += Math.abs(are[cur]);
                    are[nex] += are[cur];
                    are[cur] = 0;
                    if(depth[nex]==1)q.add(nex);
                }
            }

        }
        
        
        
        return count;
          
      }
}