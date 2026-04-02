class Solution {
    fun maximumAmount(coins: Array<IntArray>): Int {
        val m = coins.size
        val n = coins[0].size
        val dp = Array(m) { Array(n) { IntArray(3) { -5000000 } } }

        dp[0][0][0] = coins[0][0]
        dp[0][0][1] = 0
        dp[0][0][2] = 0

        for (i in 1 until m) {
            dp[i][0][0] = coins[i][0] + dp[i - 1][0][0]
            dp[i][0][1] = maxOf(coins[i][0] + dp[i - 1][0][1], dp[i - 1][0][0])
            dp[i][0][2] = maxOf(coins[i][0] + dp[i - 1][0][2], dp[i - 1][0][1])
        }
        for (j in 1 until n) {
            dp[0][j][0] = coins[0][j] + dp[0][j - 1][0]
            dp[0][j][1] = maxOf(coins[0][j] + dp[0][j - 1][1], dp[0][j - 1][0])
            dp[0][j][2] = maxOf(coins[0][j] + dp[0][j - 1][2], dp[0][j - 1][1])
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j][0] = coins[i][j] + maxOf(dp[i - 1][j][0], dp[i][j - 1][0])
                dp[i][j][1] = maxOf(
                    coins[i][j] + maxOf(dp[i - 1][j][1], dp[i][j - 1][1]),
                    maxOf(dp[i - 1][j][0], dp[i][j - 1][0]),
                )
                dp[i][j][2] = maxOf(
                    coins[i][j] + maxOf(dp[i - 1][j][2], dp[i][j - 1][2]),
                    maxOf(dp[i - 1][j][1], dp[i][j - 1][1]),
                )
            }
        }

        return maxOf(dp[m - 1][n - 1][0], dp[m - 1][n - 1][1], dp[m - 1][n - 1][2])
    }
}