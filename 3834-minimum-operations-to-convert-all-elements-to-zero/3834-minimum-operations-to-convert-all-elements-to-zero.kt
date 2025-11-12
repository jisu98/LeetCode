class Solution {
    fun minOperations(nums: IntArray): Int {
        val monotonic = mutableListOf<Int>()
        var count = 0

        for (n in nums) {
            while (monotonic.isNotEmpty() && monotonic.last() > n) {
                monotonic.removeLast()
            }
            
            if (n == 0) {
                continue
            }

            if (monotonic.isEmpty() || monotonic.last() < n) {
                count++
                monotonic += n
            }
        }

        return count
    }
}