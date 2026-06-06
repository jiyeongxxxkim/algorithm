import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        TreeMap<Integer, Long> tmap = new TreeMap<>();
        for(int we:weights){
            tmap.put(we, tmap.getOrDefault(we, 0L)+(long)1);
        }
        int[] maxarr = {1,2,3};
        int[] minarr = {2,3,4};
        
        for(int key:tmap.keySet()){
            if(tmap.get(key)>1){
                answer += (tmap.get(key)*(tmap.get(key)-1)/2);
            }
            for(int i=0;i<3;i++){
                if((minarr[i]*key)%maxarr[i]==0&&tmap.containsKey((minarr[i]*key)/maxarr[i])){
                    System.out.println(tmap.get(key)*tmap.get(minarr[i]*key/maxarr[i]));
                    answer += (long)(tmap.get(key)*tmap.get(minarr[i]*key/maxarr[i]));
                }
            }
        }
        return answer;
    }
}