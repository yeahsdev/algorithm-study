class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
        1. input nums -> HashMap and count check
        2. HashMap -> PriorityQueue -> 오름차순 정렬
        3. 상위 k개만 남겨놓고 전부 제거
         */
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        // 2. 빈도를 기준으로 하는 최소 힙(Min Heap) 생성
        // PriorityQueue는 기본적으로 최소 힙이다.
        // a.getValue() - b.getValue() : 빈도(value)를 기준으로 오름차순 정렬 (작은 값이 우선)
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        // 3. map의 모든 entry를 PriorityQueue에 추가
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            // 힙의 크기가 k를 초과하면, 빈도가 가장 낮은 원소(힙의 루트)를 제거
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 4. PriorityQueue에 남아있는 K개의 원소(결과)를 배열에 담기
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // 힙에서 원소를 하나씩 꺼내서(poll) 배열에 담습니다.
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}