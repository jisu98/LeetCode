class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var ans = 0

        for (p in prices) {
            min = minOf(min, p)
            ans = maxOf(p - min, ans)
        }

        return ans
    }
}