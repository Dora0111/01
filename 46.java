class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 1;   // 慢指针
        if(nums.length == 1) {
            return 1;
        }
        for(int i = 1; i < nums.length; i++) {  // i为快指针
            if(nums[i] != nums[i - 1]) {   // 当前元素!=上一个元素
                nums[slow] = nums[i];   // 慢指针所指的元素为当前元素
                slow++;
            }
        }
        return slow;
    }
}
