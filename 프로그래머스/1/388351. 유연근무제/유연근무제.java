class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int daynum = startday;
        for(int i=0;i<schedules.length;i++){
            schedules[i] = (schedules[i]/100*60)+(schedules[i]%100)+10;
        }
        int time = 0;
        boolean chk = true;
        for(int i=0;i<timelogs.length;i++){
            chk = true;
            daynum = startday;
            for(int j=0;j<7;j++,daynum++){
                daynum = daynum>7?daynum%7:daynum;
                time = (timelogs[i][j]/100*60)+(timelogs[i][j]%100);
                if(time>schedules[i]&&daynum!=6&&daynum!=7){
                    chk = false;
                    break;
                }
            }
            if(chk)answer++;
        }
        
        return answer;
    }
}