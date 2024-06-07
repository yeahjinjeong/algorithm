class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (target < nums[j]) {
                return j;
            }
        }
        return nums.length;
        // int[] newNums = Arrays.copyOf(nums, nums.length+1);
        // newNums[nums.length] = target;
        // Arrays.sort(newNums);
        // for (int j = 0; j < newNums.length; j++) {
        //     if (target == newNums[j]) {
        //         return j;
        //     }
        // }
        // return 0;
    }
}