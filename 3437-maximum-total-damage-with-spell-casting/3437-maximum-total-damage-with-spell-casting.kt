class Solution {
    fun maximumTotalDamage(power: IntArray): Long {
        var answer = 0L
        val dp = mutableListOf<Pair<Int, Long>>()
        val frequencyMap = power.toList().groupingBy { it }.eachCount().toSortedMap()

        for (f in frequencyMap) {
            val key = f.key
            val damage = key * f.value.toLong()
            var max = damage

            for (i in dp.size - 1 downTo 0) {
                if (dp[i].first < key - 2) {
                    max = maxOf(max, dp[i].second + damage)
                    break
                } else {
                    max = maxOf(max, dp[i].second)
                }
            }

            dp += key to max
            answer = maxOf(answer, max)
        }

        return answer
    }
}