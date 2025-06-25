class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length; i++) {
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            // 존재하지 않는다면, 현재 숫자와 인덱스를 맵에 저장
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}