class Solution {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Int {
        val prefix = IntArray(nums.size)
        var count = 0
        var ans = 0

        for (i in nums.indices) {
            if (nums[i] == target) {
                count++
            }

            prefix[i] = count
        }

        for (i in 0 until nums.size) {
            for (j in i until nums.size) {
                val right = prefix[j]
                val left = if (i == 0) 0 else prefix[i - 1]

                if (right - left > (j - i + 1) / 2) {
                    ans++
                }
            }
        }

        return ans
    }
}