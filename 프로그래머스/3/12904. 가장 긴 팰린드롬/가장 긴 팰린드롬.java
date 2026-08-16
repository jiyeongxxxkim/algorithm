class Solution
{
    char[] arr;
    int maxlen(int r, int l){
        int count = 0;
        while(r>=0&&l<arr.length&&arr[r]==arr[l]){
            count+=2;
            r--;
            l++;
        }
        return count;
    }
    public int solution(String s)
    {
        int answer = 0;
        arr = new char[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i] = s.charAt(i);
        }
        
        for(int i=0;i<s.length();i++){
            answer = Math.max(answer, maxlen(i, i+1));
            answer = Math.max(answer, maxlen(i,i)-1);
        }
        return answer;
    }
}