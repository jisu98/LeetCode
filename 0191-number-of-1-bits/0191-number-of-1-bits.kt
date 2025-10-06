class Solution {
    fun hammingWeight(n: Int): Int {
        var count = 0
        var num = n

        while (num > 0) {
            count += num.and(1)
            num = num shr 1
        }

        return count
    }
}