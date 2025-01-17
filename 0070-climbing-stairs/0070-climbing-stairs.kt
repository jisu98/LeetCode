class Solution {
    fun climbStairs(n: Int): Int {
        return climb(0, 1, n)
    }

    private fun climb(a: Int, b: Int, count: Int): Int {
        return if (count == 0) b else climb(b, a + b, count - 1)
    }
}