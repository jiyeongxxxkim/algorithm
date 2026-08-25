import java.util.*;
class Solution {
    int[] card_idx;
    boolean[] visited;
    int bfs(int st){
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        visited[st] = true;
        int count = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            int nx = card_idx[cur];
            if(!visited[nx]){
                count++;
                visited[nx] = true;
                q.add(nx);
            }
        }
        return count;
    }
    public int solution(int[] cards) {
        int answer = 0;
        card_idx = new int[cards.length+1];
        visited = new boolean[cards.length+1];
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<cards.length;i++){
            card_idx[i+1] = cards[i];
        }
        for(int i=1;i<cards.length+1;i++){
            if(!visited[i]){
                arr.add(bfs(i));
            }
        }
        Collections.sort(arr, (a,b)->{return b-a;});
        
        if(arr.size()==1)return 0;
        return arr.get(0)*arr.get(1);
    }
}