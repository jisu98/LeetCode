class Solution {
    fun maxSum(nums: IntArray): Int {
        val visited = mutableSetOf<Int>()
        var answer = 0

        for (n in nums) {
            if (n > 0 && !visited.contains(n)) {
                visited += n
                answer += n
            }
        }

        return if (visited.isEmpty()) nums.max()
        else answer
    }
}