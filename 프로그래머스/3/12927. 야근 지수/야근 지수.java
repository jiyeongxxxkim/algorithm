import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        ArrayList<Integer> rev = new ArrayList<>();
        for(int work:works){
            tmap.put(work, tmap.getOrDefault(work,0)+1);
        }
        while (n > 0 && !tmap.isEmpty()){
            int maxKey = tmap.lastKey();
            if (maxKey == 0) break;
            int orival = tmap.get(maxKey);
            if (orival > n) {
                tmap.put(maxKey, orival - n); 
                tmap.put(maxKey - 1, tmap.getOrDefault(maxKey - 1, 0) + n); 
                n = 0;
                break;
            }else {
                tmap.remove(maxKey);
                tmap.put(maxKey - 1, tmap.getOrDefault(maxKey - 1, 0) + orival);

                n -= orival;
            }
        }
        
        for(int key:tmap.keySet()){
            for(int j=0;j<tmap.get(key);j++){
                answer += Math.pow(key,2);
            }
        }
        
        
        return answer;
    }
}