import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        
        Arrays.sort(mats);
        
        for(int mat=mats.length-1;mat>=0;mat--){
            int m = mats[mat];

            for(int i=0;i<=park.length-m;i++){
                for(int j=0;j<=park[0].length-m;j++){
                    if(park[i][j].equals("-1")){

                        boolean chk = true;
                        for(int x=i;x<(i+m);x++){
                            for(int y=j;y<(j+m);y++){
                                if(!park[x][y].equals("-1")){
                                    chk = false;
                                    break;
                                }
                            }if(!chk) break;
                        }if(chk) return m;
                    }
                }
            }
        }
        return -1;
    }
}