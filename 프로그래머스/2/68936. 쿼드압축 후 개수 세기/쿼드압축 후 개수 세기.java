import java.util.*;
class Solution {
    int zerocnt = 0;
    int onecnt = 0;
    void chek(int[][] zeroone, int n){
        int first = zeroone[0][0];
        boolean samechk = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(zeroone[i][j]!=first){
                    samechk = false;
                    break;
                }
            }if(!samechk)break;
        }
        if(!samechk){
            int half = n / 2;
            
            int[][] topRight = new int[half][half];
            int[][] topLeft = new int[half][half];     
            int[][] bottomLeft = new int[half][half]; 
            int[][] bottomRight = new int[half][half];

            for (int i = 0; i < half; i++) {
                for (int j = 0; j < half; j++) {
                    topLeft[i][j] = zeroone[i][j];
                    topRight[i][j] = zeroone[i][j + half];
                    bottomLeft[i][j] = zeroone[i + half][j];
                    bottomRight[i][j] = zeroone[i + half][j + half];
                }
            }
            chek(topLeft, n/2);
            chek(topRight, n/2);
            chek(bottomLeft, n/2);
            chek(bottomRight, n/2);
        }else{
            if(first==0)zerocnt++;
            else onecnt++;
        }
    }
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        int n = arr.length;
        chek(arr, n);
        
        answer[0] = zerocnt;
        answer[1] = onecnt;
        return answer;
    }
}