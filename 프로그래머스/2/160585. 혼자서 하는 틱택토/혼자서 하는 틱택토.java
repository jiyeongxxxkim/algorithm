import java.util.*;
class Solution {
    int[] board;
    Map<Integer, Integer> ticmap;
    int[][] index = {
        {0,1,2},
        {3,4,5},
        {6,7,8},
        {0,4,8},
        {0,3,6},
        {1,4,7},
        {2,5,8},
        {2,4,6}
    };
    public void checktic(){
        int prenum = -1;
        for(int i=0;i<8;i++){
            boolean chk = true;
            prenum = board[index[i][0]];
            if(prenum!=0){
                for(int j=1;j<3;j++){
                    if(prenum!=board[index[i][j]]){
                        chk = false;
                        break;
                    }
                }   
            }
            if(chk){
                ticmap.put(prenum, ticmap.getOrDefault(prenum, 0)+1);
            }
        }
    }
    public int solution(String[] board) {
        int answer = -1;
        this.board = new int[9];
        ticmap = new HashMap<>();
        int counto = 0, countx = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int num = board[i].charAt(j)=='.'?0:board[i].charAt(j)=='O'?1:2;
                if(num==1)counto++;
                else if(num==2)countx++;
                this.board[(i*3+j)] = num;
            }
        }
        checktic();
        
        if (counto < countx || counto > countx + 1) {
            return 0;
        }
        if (ticmap.getOrDefault(1, 0) > 0 && ticmap.getOrDefault(2, 0) > 0) {
            return 0;
        }
        if (ticmap.getOrDefault(1, 0) > 0 && counto == countx) {
            return 0;
        }
        if (ticmap.getOrDefault(2, 0) > 0 && counto == countx + 1) {
            return 0;
        }

        return 1;
            
    
    }
}