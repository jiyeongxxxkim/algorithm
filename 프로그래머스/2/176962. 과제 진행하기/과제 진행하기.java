import java.util.*; 
class Solution {
    public String[] solution(String[][] plans) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        String[] planname = new String[plans.length];
        int[][] plantime = new int[plans.length][3];
        String[] answer = new String[plans.length];
        for(int i=0;i<plans.length;i++){
            planname[i] = plans[i][0];
            plantime[i][0] = i;  
            plantime[i][1] = Integer.parseInt(plans[i][1].split(":")[0])*60+Integer.parseInt(plans[i][1].split(":")[1]);
            plantime[i][2] = Integer.parseInt(plans[i][2]);
        }
        Arrays.sort(plantime, (a,b)->{
           return a[1]-b[1]; 
        });
        
        int resultidx = 0;
        int curtime = 0;

        for (int i = 0; i < plans.length; i++) {
            int nextStart = plantime[i][1];

            while (!stk.isEmpty() && curtime < nextStart) {
                int curIdx = stk.peek();
                int remainTime = plantime[curIdx][2];

                if (curtime + remainTime <= nextStart) {
                    curtime += remainTime;
                    answer[resultidx++] = planname[plantime[stk.pop()][0]];
                } 
                else {
                    plantime[curIdx][2] -= (nextStart - curtime);
                    curtime = nextStart;
                    break;
                }
            }

            curtime = nextStart;
            stk.push(i);
        }
        while(!stk.isEmpty()){
            answer[resultidx++] = planname[plantime[stk.pop()][0]];
        }
        
        
        return answer;
    }
}