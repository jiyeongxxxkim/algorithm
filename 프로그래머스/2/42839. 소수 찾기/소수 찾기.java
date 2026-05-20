import java.util.*;
class Solution {
    int[] nums;
    boolean[] visited;
    HashSet<Integer> hset;
    int[] resultlist;
    int len;
    public void dfs(int depth){
    
        if(depth!=0){
            int result=0;
            for(int i=0;i<depth;i++){
                result = result*10+resultlist[i];
            }
            hset.add(result);
        }
        if(depth==len)return;
        
        for(int i=0;i<len;i++){
            if(!visited[i]){
                visited[i] = true;
                resultlist[depth] = nums[i];
                dfs(depth+1);
                visited[i] =false;
            }    
        }
    }
    public int solution(String numbers) {
        int answer = 0;
        len = numbers.length();
        
        boolean[] isnotprime = new boolean[10_000_000];
        isnotprime[0] = true;
        isnotprime[1] = true;
        isnotprime[2] = false;
        for(int i=2;i*i<10_000_000;i++){
            if(!isnotprime[i]){
                for(int j=i*i;j<10_000_000;j+=i){
                    isnotprime[j] = true;
                }
            }
        }
        
        nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i] = numbers.charAt(i)-'0';
        }
        
        hset = new HashSet<>();
        resultlist = new int[len];
        visited = new boolean[len+1];
        dfs(0);
        ArrayList<Integer> li = new ArrayList<>();
        
        
        for(int i:hset){
            if(!isnotprime[i]){
                li.add(i);
            }
        }
        
        answer = li.size();
        
        return answer;
    }
}