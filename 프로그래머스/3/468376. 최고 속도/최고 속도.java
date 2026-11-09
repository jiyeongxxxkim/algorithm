import java.util.*;

class Solution {
    
    // 좌표(x, y)를 고유한 long 형태의 키로 변환하여 저장할 맵
    HashMap<Long, Integer> pointToIndex = new HashMap<>();
    List<int[]> nodes = new ArrayList<>();
    List<Integer> nodeLimits = new ArrayList<>();
    
    // 점이 도로 선분(r) 위에 있는지 판별
    boolean isOnSegment(int px, int py, int[] r) {
        int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
        if (x1 == x2) {
            return px == x1 && py >= y1 && py <= y2;
        } else {
            return py == y1 && px >= x1 && px <= x2;
        }
    }

    // 좌표를 노드로 등록하고 고유 인덱스 번호를 반환
    int addNode(int x, int y) {
        // x, y 좌표를 합쳐 하나의 long 키로 생성 (비트 이동 연산으로 빠른 해싱)
        long key = (((long) x) << 32) | (y & 0xffffffffL);
        Integer id = pointToIndex.get(key);
        if (id == null) {
            id = nodes.size();
            pointToIndex.put(key, id);
            nodes.add(new int[]{x, y});
            nodeLimits.add(Integer.MAX_VALUE); // 기본적으로 속도 제한 없음 (무한대)
        }
        return id;
    }

    public int[] solution(int[][] city, int[][] road) {
        // 각 도로(road)마다 해당 도로 위에 존재하는 노드 ID들을 담을 Set 배열
        Set<Integer>[] roadNodes = new HashSet[road.length];
        for (int i = 0; i < road.length; i++) {
            roadNodes[i] = new HashSet<>();
        }

        // 1. 도시 추가 및 도로 매칭
        for (int[] c : city) {
            int id = addNode(c[0], c[1]);
            for (int i = 0; i < road.length; i++) {
                if (isOnSegment(c[0], c[1], road[i])) {
                    roadNodes[i].add(id);
                }
            }
        }

        // 2. 도로의 양 끝점 및 정중앙(카메라) 추가
        for (int i = 0; i < road.length; i++) {
            int[] r = road[i];
            // 양 끝점 추가
            roadNodes[i].add(addNode(r[0], r[1]));
            roadNodes[i].add(addNode(r[2], r[3]));

            // 정중앙 점(카메라) 추가
            int mx = r[0] + (r[2] - r[0]) / 2;
            int my = r[1] + (r[3] - r[1]) / 2;
            int midId = addNode(mx, my);
            roadNodes[i].add(midId);
            
            // 카메라 위치 정점에 제한 속도 부여 (가장 낮은 속도로 갱신)
            nodeLimits.set(midId, Math.min(nodeLimits.get(midId), r[4]));
        }

        // 3. 교차점(수직선과 수평선이 만나는 곳) 추가
        for (int i = 0; i < road.length; i++) {
            for (int j = i + 1; j < road.length; j++) {
                int[] r1 = road[i];
                int[] r2 = road[j];
                
                // r1이 수직선, r2가 수평선
                if (r1[0] == r1[2] && r2[1] == r2[3]) {
                    if (r2[0] <= r1[0] && r1[0] <= r2[2] && r1[1] <= r2[1] && r2[1] <= r1[3]) {
                        int crossId = addNode(r1[0], r2[1]);
                        roadNodes[i].add(crossId);
                        roadNodes[j].add(crossId);
                    }
                }
                // r1이 수평선, r2가 수직선
                else if (r1[1] == r1[3] && r2[0] == r2[2]) {
                    if (r1[0] <= r2[0] && r2[0] <= r1[2] && r2[1] <= r1[1] && r1[1] <= r2[3]) {
                        int crossId = addNode(r2[0], r1[1]);
                        roadNodes[i].add(crossId);
                        roadNodes[j].add(crossId);
                    }
                }
            }
        }

        // 4. 추출된 노드들을 바탕으로 그래프(인접 리스트) 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            List<Integer> list = new ArrayList<>(roadNodes[i]);
            int[] r = road[i];
            
            // 좌표 순서대로 정렬 (수평선은 x 기준, 수직선은 y 기준)
            list.sort((a, b) -> {
                int[] na = nodes.get(a);
                int[] nb = nodes.get(b);
                if (r[0] == r[2]) return Integer.compare(na[1], nb[1]);
                return Integer.compare(na[0], nb[0]);
            });

            // 이웃한 노드들끼리 간선 연결 (가중치는 정점 자체에 있으므로 간선에는 부여 안 함)
            for (int k = 0; k < list.size() - 1; k++) {
                int u = list.get(k);
                int v = list.get(k + 1);
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
        }

        // 5. Max-Min 다익스트라 수행
        int[] maxSpeeds = new int[nodes.size()];
        Arrays.fill(maxSpeeds, -1);
        
        // 우선순위 큐 (현재 유지 가능한 속도가 큰 경로를 먼저 탐색)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        
        // 출발점 (1번 도시)
        long startKey = (((long) city[0][0]) << 32) | (city[0][1] & 0xffffffffL);
        int startNode = pointToIndex.get(startKey);
        
        maxSpeeds[startNode] = Integer.MAX_VALUE;
        pq.add(new int[]{startNode, Integer.MAX_VALUE});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int speed = cur[1];

            if (speed < maxSpeeds[u]) continue;

            for (int v : graph.get(u)) {
                int limitAtV = nodeLimits.get(v);
                
                // 도착할 정점(v)의 제한 속도와 현재 속도 중 더 빡빡한 값이 다음 속도가 됨
                int nextSpeed = Math.min(speed, limitAtV);

                if (nextSpeed > maxSpeeds[v]) {
                    maxSpeeds[v] = nextSpeed;
                    pq.add(new int[]{v, nextSpeed});
                }
            }
        }

        // 6. 2번 ~ n번 도시 결과 배열 생성
        int[] answer = new int[city.length - 1];
        for (int i = 1; i < city.length; i++) {
            long key = (((long) city[i][0]) << 32) | (city[i][1] & 0xffffffffL);
            int targetNode = pointToIndex.get(key);
            int speed = maxSpeeds[targetNode];
            
            // 카메라를 만나지 않았거나 (Integer.MAX_VALUE), 닿을 수 없다면 0 처리
            if (speed == Integer.MAX_VALUE || speed == -1) {
                answer[i - 1] = 0;
            } else {
                answer[i - 1] = speed;
            }
        }

        return answer;
    }
}