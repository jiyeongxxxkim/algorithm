import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int tan:tangerine){
            hmap.put(tan, hmap.getOrDefault(tan,0)+1);
        }
        List<Integer> sortedCounts = hmap.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        
        int answer = 0;
        int sum = 0;
        for (int count : sortedCounts) {
            sum += count;
            answer++;
            if (sum >= k) break;
        } 
        return answer;
    }
}