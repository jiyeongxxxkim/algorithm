import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> hset = new HashSet<>();
        int[] twice = new int[elements.length*2];
        for(int i=0;i<twice.length;i++){
            twice[i] = elements[(i%elements.length)];
        }
        for(int i=0;i<elements.length;i++){
            int sum = 0;
            for(int j=0;j<elements.length;j++){
                sum += twice[i+j];
                hset.add(sum);
            }
        }
        answer = hset.size();
        return answer;
    }
}