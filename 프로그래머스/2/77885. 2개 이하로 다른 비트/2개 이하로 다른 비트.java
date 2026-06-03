class Solution {
    int getidx(String n){
        for(int i=n.length()-1;i>=0;i--){
            if(n.charAt(i)=='0')return n.length()-i-1;
        }
        return -1;
    }
    long change(String n, int idx){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n.length();i++){
            if(i==(n.length()-idx-1))sb.append("1");
            else if(i==(n.length()-idx))sb.append("0");
            else sb.append(n.charAt(i));
        }
        return Long.parseLong(sb.toString(), 2);
    }
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            long num = numbers[i];
            String n = "0"+Long.toBinaryString(num);
            // System.out.println(n+" : "+getidx(n));
            if(getidx(n)==0)answer[i] = (long)(numbers[i]+1);
            else{
                answer[i] = change(n, getidx(n));
                // System.out.println(change(n, getidx(n)));
            }
        }

        return answer;
    }
}