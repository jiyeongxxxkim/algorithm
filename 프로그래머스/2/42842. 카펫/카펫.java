class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int n = (brown-4)/2;
        
        
        for(int i=1;i<=n/2;i++){
            if(i*(n-i)==yellow){
                answer[0] = (n-i)+2;
                answer[1] = i+2;
                return answer;
            }
        }
        return answer;
    }
}