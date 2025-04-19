class Solution {
    fun countPairs(nums: List<Int>, target: Int): Int {
        val nums = nums.sorted()
        var left = 0
        var right = nums.size - 1
        var result = 0

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