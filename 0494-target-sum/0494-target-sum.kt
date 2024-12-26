class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        var results = mapOf<Int, Int>()

        nums.forEach { number ->
            if (results.isEmpty()) {
                results = if (number == 0) {
                    mapOf(0 to 2)
                } else {
                    mapOf(number to 1, -number to 1)
                }
            } else {
                val newResults = mutableMapOf<Int, Int>()

                results.forEach { prevResult ->
                    val sum = prevResult.key + number
                    val difference = prevResult.key - number

                    newResults[sum] = (newResults[sum] ?: 0) + prevResult.value
                    newResults[difference] = (newResults[difference] ?: 0) + prevResult.value
                }

                results = newResults
            }
        }

        return results[target] ?: 0
    }
}
