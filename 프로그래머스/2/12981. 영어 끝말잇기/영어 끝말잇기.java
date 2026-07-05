import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> hset = new HashSet<>();

        int count = 1;
        int index = 1;
        char pre = words[0].charAt(0);
        for(String word : words){
            if(index>n){
                index =1;
                count++;
            } 
            
            if(hset.contains(word)||(pre!=word.charAt(0))){
                answer[0] = index;
                answer[1] = count;
                break;
            }
            hset.add(word);
            pre = word.charAt(word.length()-1);
            index++;
        }

        return answer;
    }
}