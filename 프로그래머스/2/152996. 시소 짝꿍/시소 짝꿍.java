import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        Arrays.sort(weights);
        
        for(int weight : weights){
            hmap.put(weight, hmap.getOrDefault(weight,0)+1);
        }
        Integer[] uniqueWeights = hmap.keySet().toArray(new Integer[0]);
        Arrays.sort(uniqueWeights);
        
        for (int w : uniqueWeights) {
            long count = (long) hmap.get(w);
            
            // Case 1: 같은 몸무게끼리 짝꿍 (nC2 조합)
            if (count > 1) {
                answer += (count * (count - 1)) / 2;
            }

            // Case 2: 다른 몸무게와 짝꿍 (비율 계산)
            // 시소 거리가 2, 3, 4이므로 가능한 비율은 3/2, 4/2(2/1), 4/3 입니다.
            // w보다 큰 몸무게들 중에서 찾아야 중복 카운트가 안 됩니다.
            int[] targets = {w * 3, w * 4, w * 4};
            int[] divisors = {2, 2, 3};

            for (int i = 0; i < 3; i++) {
                if (targets[i] % divisors[i] == 0) {
                    int targetWeight = targets[i] / divisors[i];
                    if (hmap.containsKey(targetWeight)) {
                        answer += count * (long) hmap.get(targetWeight);
                    }
                }
            }
        }
        return answer;
    }
}