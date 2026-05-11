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
        
        for(int w:uniqueWeights){
            long count = (long)hmap.get(w);
            int[] divisor = {3,2,2};
            int[] multi = {4,4,3};
            
            answer += (count*(count-1)/2);
            
            for(int i=0;i<3;i++){
                if(w*multi[i]%divisor[i]==0&&hmap.containsKey((w*multi[i]/divisor[i]))){
                    answer += count*(hmap.get(w*multi[i]/divisor[i]));
                }
            }
        }
        
        return answer;
    }
}