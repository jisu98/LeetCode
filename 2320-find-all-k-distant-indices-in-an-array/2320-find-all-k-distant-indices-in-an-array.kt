class Solution {
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        return nums.indices
            .filter { nums[it] == key }
            .flatMap { keyIndex ->
                (-k..k).map { it + keyIndex }
            }
            .toSet()
            .filter { it >= 0 && it < nums.size }
    }
}