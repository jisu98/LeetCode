class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        var answer = 0

        nums.sort()

        for (i in nums.indices step 2) {
            answer += nums[i]
        }

        return answer
    }
}