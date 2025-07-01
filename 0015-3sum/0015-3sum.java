class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 결과를 담을 리스트
        List<List<Integer>> results = new ArrayList<>();
        // 배열의 길이가 3 미만이면 유효한 조합이 없으므로 빈 리스트 반환
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            
            // 3. 중복된 첫 번째 숫자(a)를 건너뜀.
            // i > 0 조건은 첫 번째 원소일 때는 검사x.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 4. 투 포인터(left, right)를 초기화
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    // 합이 0보다 작으면, 합을 키우기 위해 left 포인터를 오른쪽으로 이동
                    left++;
                } else if (sum > 0) {
                    // 합이 0보다 크면, 합을 줄이기 위해 right 포인터를 왼쪽으로 이동
                    right--;
                } else {
                    // 합이 0이면 정답
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 5. 정답을 찾은 후, 다른 유일한 정답을 찾기 위해 포인터를 이동
                    //    이때 중복된 두 번째(b), 세 번째(c) 숫자를 건너뛰어야 함
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // left 쪽 중복 제거
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; // right 쪽 중복 제거
                    }
                    
                    // 다음 유일한 쌍을 탐색하기 위해 포인터를 한 칸씩 이동
                    left++;
                    right--;
                }
            }
        }
        return results;
    }
}