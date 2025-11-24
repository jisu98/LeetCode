class Solution {
    fun prefixesDivBy5(nums: IntArray): List<Boolean> {
        var prev = 0
        val answer = MutableList(nums.size) { false }

        for (i in nums.indices) {
            prev = ((prev shl 1) + nums[i]) % 5
            if (prev == 0) answer[i] = true
        }

        return answer
    }
}