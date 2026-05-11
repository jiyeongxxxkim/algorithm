import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> hmap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<26;i++){
            hmap.put(String.valueOf((char)('A' + i)), i+1);
        }
        int mapindex = 27;
        int index = 0;
        while(index<msg.length()){
            String w = String.valueOf(msg.charAt(index));
            
            while((index+1)<msg.length()&&hmap.containsKey(w+msg.charAt(index+1))){
                w+=msg.charAt(index+1);
                index++;
            }
            list.add(hmap.get(w));
            if((index+1)<msg.length()){
                hmap.put((w+msg.charAt(index+1)), mapindex++);
            }
            index++;
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}