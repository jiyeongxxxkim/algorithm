import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> hset = new HashSet<>();
        for(int i=0;i<skill.length();i++){
            hset.add(skill.charAt(i));
        }
        
        for(String skilltree : skill_trees){
            int count = 0;
            boolean matchchk = true;
            for(int i=0;i<skilltree.length();i++){
                char ch = skilltree.charAt(i);
                if(hset.contains(ch)){
                    if(ch!=skill.charAt(count)){
                        matchchk = false;
                        break;
                    }else{
                        count++;
                    }
                }
                
            }if(matchchk)answer++;
        }
        return answer;
    }
}