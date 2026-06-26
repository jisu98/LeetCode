class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1 || nums[0] > nums[1]) return 0
        if (nums[nums.size - 1] > nums[nums.size - 2]) return nums.size - 1

        for (i in 1 until nums.size - 1) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i
        }

        return -1
    }
}