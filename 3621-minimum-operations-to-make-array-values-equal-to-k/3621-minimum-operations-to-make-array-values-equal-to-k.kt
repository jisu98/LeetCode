class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        val set = nums.toSortedSet()

        return if (k > set.first()) -1
        else if (k == set.first()) set.size - 1
        else set.size
    }
}