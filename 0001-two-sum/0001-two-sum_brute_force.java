// Time: 51 ms (7.58%), Space: 45.2 MB (29.41%) - LeetHub
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] numbers = new int[2];
        for(int i =0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    numbers[0] = i;
                    numbers[1] = j;
                }
            }
            
        }
        return numbers;
    }
}
