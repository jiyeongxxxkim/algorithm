import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        Arrays.sort(weights);
        
        for(int weight : weights){
            hmap.put(weight, hmap.getOrDefault(weight,0)+1);
        }
        Integer[] uniqueWeights = hmap.keySet().toArray(Integer[]::new);
        Arrays.sort(uniqueWeights);
        
        for (int w : uniqueWeights) {
            long count = (long) hmap.get(w);
            
            if (count > 1) {
                answer += (count * (count - 1)) / 2;
            }

            int[] target = {w*4, w*4, w*3};
            int[] divisor = {3, 2, 2};
            
            for(int i=0;i<3;i++){
                if(target[i]%divisor[i]==0){
                    if(hmap.containsKey(target[i]/divisor[i])){
                        answer += count*hmap.get(target[i]/divisor[i]);
                    }
                }
            }
            
        }
        return answer;
    }
}