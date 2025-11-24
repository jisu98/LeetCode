class Solution {
    fun prefixesDivBy5(nums: IntArray): BooleanArray {
        var prev = 0
        val answer = BooleanArray(nums.size)

        for (i in nums.indices) {
            prev = ((prev shl 1) + nums[i]) % 5
            answer[i] = (prev == 0)
        }

        return answer
    }
}