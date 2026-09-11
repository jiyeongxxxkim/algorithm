import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        // 1. 가지고 있는 전체 곡괭이 개수 계산
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        // 2. 내가 캘 수 있는 최대 광물의 개수 제한 (중요 ⭐)
        // 가지고 있는 곡괭이로 다 캘 수 없으면, 어차피 못 캐는 뒤쪽 광물은 잘라내야 정렬이 안 꼬임
        int maxLen = Math.min(minerals.length, totalPicks * 5);
        
        List<int[]> list = new ArrayList<>();
        
        // 3. 광물들을 5개씩 묶어서 곡괭이별 피로도 계산
        for (int i = 0; i < maxLen; i += 5) {
            int diaFatigue = 0;
            int ironFatigue = 0;
            int stoneFatigue = 0;
            
            // i부터 최대 5개(또는 남은 광물 끝까지) 검사
            for (int j = i; j < i + 5 && j < maxLen; j++) {
                String mineral = minerals[j];
                
                if (mineral.equals("diamond")) {
                    diaFatigue += 1;
                    ironFatigue += 5;
                    stoneFatigue += 25;
                } else if (mineral.equals("iron")) {
                    diaFatigue += 1;
                    ironFatigue += 1;
                    stoneFatigue += 5;
                } else { // "stone"
                    diaFatigue += 1;
                    ironFatigue += 1;
                    stoneFatigue += 1;
                }
            }
            
            // 한 묶음의 [다이아 피로도, 철 피로도, 돌 피로도] 배열을 리스트에 추가
            list.add(new int[]{diaFatigue, ironFatigue, stoneFatigue});
        }
        
        // 4. 돌 곡괭이로 캤을 때의 피로도(인덱스 2)를 기준으로 내림차순 정렬
        Collections.sort(list, (o1, o2) -> {
            return o2[2] - o1[2]; 
        });
        
        // 5. 위험도(피로도)가 가장 높은 묶음부터 좋은 곡괭이 할당
        for (int[] fatigue : list) {
            if (picks[0] > 0) {         // 다이아 곡괭이가 남았다면
                answer += fatigue[0];
                picks[0]--;
            } else if (picks[1] > 0) {  // 철 곡괭이가 남았다면
                answer += fatigue[1];
                picks[1]--;
            } else if (picks[2] > 0) {  // 돌 곡괭이가 남았다면
                answer += fatigue[2];
                picks[2]--;
            } else {
                break; // 남은 곡괭이가 없으면 종료
            }
        }
        
        return answer;
    }
}