class Solution {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        var remaining = coins
        var count = 0

        costs.sort()

        for (c in costs) {
            if (c > remaining) break

            remaining -= c
            count++
        }

        return count
    }
}