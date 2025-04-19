class Solution {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        val nums = nums.sorted()
        
        return countPairs(nums, upper + 1) - countPairs(nums, lower)
    }

    private fun countPairs(nums: List<Int>, target: Int): Long {
        var left = 0
        var right = nums.size - 1
        var result = 0L

        while(left < right) {
            if (nums[left] + nums[right] < target) {
                result += right - left
                left++
            } else {
                right--
            }
        }

        return result
    }
}