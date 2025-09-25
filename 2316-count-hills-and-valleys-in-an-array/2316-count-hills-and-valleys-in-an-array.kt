class Solution {
    fun countHillValley(nums: IntArray): Int {
        var prev = nums[0]
        var count = 0

        for (i in 1 until nums.size - 1) {
            if (nums[i] == nums[i + 1]) {
                continue
            }

            if (nums[i] > prev && nums[i] > nums[i + 1]) {
                count++
            } else if (nums[i] < prev && nums[i] < nums[i + 1]) {
                count++
            }

            prev = nums[i]
        }

        return count
    }
}