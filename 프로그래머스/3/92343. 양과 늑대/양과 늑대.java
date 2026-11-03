import java.util.*;

class Solution {
    private int maxSheep = 0;
    private List<List<Integer>> tree = new ArrayList<>();
    private int[] nodeInfo;

    public int solution(int[] info, int[][] edges) {
        nodeInfo = info;
        
        // 트리 구조 초기화
        for (int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }
        
        // 다음으로 방문할 수 있는 노드 후보 리스트
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0); // 루트 노드부터 시작
        
        dfs(0, 0, 0, nextNodes);
        
        return maxSheep;
    }
    
    private void dfs(int currentNode, int sheep, int wolf, List<Integer> nextNodes) {
        // 현재 노드에 있는 동물이 양(0)인지 늑대(1)인지 확인하여 카운트 증가
        if (nodeInfo[currentNode] == 0) sheep++;
        else wolf++;
        
        // 늑대가 양과 같거나 많아지면 잡아먹히므로 탐색 종료 (백트래킹)
        if (wolf >= sheep) return;
        
        // 최대 양의 수 갱신
        maxSheep = Math.max(maxSheep, sheep);
        
        // 다음 상태를 위한 새로운 후보 리스트 생성
        List<Integer> next = new ArrayList<>(nextNodes);
        
        // 방금 방문한 현재 노드는 후보에서 제거 (Integer 객체로 전달해야 인덱스가 아닌 값으로 삭제됨)
        next.remove(Integer.valueOf(currentNode));
        
        // 현재 노드의 자식 노드들을 다음 방문 후보에 추가
        for (int child : tree.get(currentNode)) {
            next.add(child); 
        }
        
        // 갈 수 있는 모든 후보 노드들에 대해 DFS 재귀 호출
        for (int nextNode : next) {
            dfs(nextNode, sheep, wolf, next);
        }
    }
}