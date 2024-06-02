class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])){
                nums[index++]= nums[i];
            }
        }
        return set.size();
    }
}