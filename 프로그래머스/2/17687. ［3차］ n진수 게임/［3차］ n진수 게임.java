class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(sb.length()<(m*(t-1)+p)){
            String cur = Integer.toString(idx, n);
            sb.append(cur.toUpperCase());
            idx++;
        }
        String result = sb.toString();
        sb = new StringBuilder();
        for(int i=0;i<result.length();i++){
            if((i+1)%m==(p%m)&&sb.length()<t)sb.append(result.charAt(i));
        }
        answer = sb.toString();
        
        return answer;
    }
}