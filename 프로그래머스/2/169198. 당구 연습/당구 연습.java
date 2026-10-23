class Solution {
    int[][] getpoint(int m, int n, int[] ball){
        int[][] fpoint = new int[4][2];
        
        for(int i=0;i<4;i++)fpoint[i] = ball.clone();
        
        fpoint[0][1] = n+(n-ball[1]);
        fpoint[1][0] = m+(m-ball[0]);
        fpoint[2][1] = -1*ball[1];
        fpoint[3][0] = -1*ball[0];

        return fpoint;
    }
    int[] getlen(int m, int n, int sx, int sy, int[] ball){
        int[] result = new int[4];
        int idx= 0;
        for(int[] fp:getpoint(m,n,ball)){
            result[idx++] = (sx-fp[0])*(sx-fp[0])+(sy-fp[1])*(sy-fp[1]);
        }
        if(sx==ball[0]&&sy<ball[1])result[0] = Integer.MAX_VALUE;
        else if(sx==ball[0]&&sy>ball[1])result[2] = Integer.MAX_VALUE;
        else if(sy==ball[1]&&sx<ball[0])result[1] = Integer.MAX_VALUE;
        else if(sy==ball[1]&&sx>ball[0])result[3] = Integer.MAX_VALUE;
        return result;
    }
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int k = balls.length;
        int[] answer = new int[k];
        for(int i=0;i<k;i++){
            int[] ball = balls[i];
            int min = Integer.MAX_VALUE;
            
            for(int l:getlen(m, n, startX, startY, ball)){
                min = Math.min(min, l);
            }    
            answer[i] = min;
        }
        
        
        
        
        return answer;
    }
}