class Solution {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        var count1 = 0
        var gcd = 0

        for (num in nums) {
            if (num == 1) count1++
            else gcd = gcd(gcd, num)
        }

        if (count1 > 0) return n - count1
        if (gcd > 1) return -1

        var minLen = n

        for (i in 0 until n) {
            var g = 0

            for (j in i until n) {
                g = gcd(g, nums[j])

                if (g == 1) {
                    minLen = minOf(minLen, j - i + 1)
                    break
                }
            }
        }

        return minLen + n - 2
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (a < b) gcd(b, a)
        else if (b == 0) a
        else gcd(b, a % b)
    }
}