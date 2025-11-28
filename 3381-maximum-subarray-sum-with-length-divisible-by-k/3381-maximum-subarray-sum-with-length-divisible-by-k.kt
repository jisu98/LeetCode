class Solution {
    fun maxSubarraySum(nums: IntArray, k: Int): Long {
        var chunk = 0L
        var max = 0L
        val dp = LongArray(nums.size)

        for (i in 0 until k) {
            chunk += nums[i]
        }

        dp[k - 1] = chunk
        max = chunk

        for (i in k until nums.size) {
            chunk = chunk + nums[i] - nums[i - k]
            dp[i] = maxOf(chunk, dp[i - k] + chunk)
            max = maxOf(max, dp[i])
        }
        
        return max
    }
}