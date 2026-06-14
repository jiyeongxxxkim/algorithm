import java.util.*;
class Solution {
    static String[] words;
    static String target;
    static boolean[] visited;
    static int[] count;
    static String begin;
     public static void bfs(String begin){
        Queue<String> q = new LinkedList<>();
        q.add(begin);

        while(!q.isEmpty()) {
            String cur = q.poll();
            int index = getIndex(cur);
            if(cur.equals(target)){
                return;
            }
            for (int i = 0; i < words.length; i++) {
                if(!visited[i]){
                    if (mathchk(cur, words[i])) {
                        q.add(words[i]);
                        visited[i] = true;
                        count[i] = index+1;
                    }
                }
            }
        }
    }
    public static int getIndex(String cur){
        if(cur.equals(begin))return 0;
        else{
            for(int i=0;i<words.length;i++){
                if(words[i].equals(cur)){
                    return count[i];
                }
            }
        }
        return -1;
    }
    public static boolean mathchk(String s1, String s2){
        int count = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
        }
        if(count==1)return true;
        else return false;
        
    }
    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        int answer = 0;
        visited = new boolean[words.length+1];
        count = new int[words.length+1];

        int index = -1;

        boolean chk = false;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                chk = true;
                index = i;
            }
        }
        if(chk){
            bfs(begin);
            answer = count[index];
        }else{
            answer = 0;
        }
        return answer;
    }
}