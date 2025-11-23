class Solution {
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        return nums.asSequence()
            .mapIndexed { i, n -> Pair(i, n) }
            .sortedByDescending { it.second }
            .take(k)
            .sortedBy { it.first }
            .map { it.second }.toList()
            .toIntArray()
    }
}