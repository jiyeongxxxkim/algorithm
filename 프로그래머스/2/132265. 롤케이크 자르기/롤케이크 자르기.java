import java.util.*;
class Solution {
    public int solution(int[] topping) {
        Set<Integer> hset = new HashSet<>();
        Map<Integer, Integer> hmap = new HashMap<>();
         int answer = 0;
        
        for(int top:topping)hmap.put(top, hmap.getOrDefault(top,0)+1);
        
        for(int i=0;i<topping.length;i++){
            hset.add(topping[i]);
            if(hmap.getOrDefault(topping[i],0)!=1){
                hmap.put(topping[i], hmap.get(topping[i])-1);
            }else{
                hmap.remove(topping[i]);
            }
            if(hset.size()==hmap.size()){
                answer++;
            }
        }
        return answer;
    }
}