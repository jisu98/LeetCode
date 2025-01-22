class Solution {
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val n = isWater.size
        val m = isWater.first().size

        val result = Array(n) { IntArray(m) { -1 } }
        var num = 0
        var cur = mutableListOf<Pair<Int, Int>>()
        var next = mutableListOf<Pair<Int, Int>>()

        (0..<n).forEach { i ->
            (0..<m).forEach { j ->
                if (isWater[i][j] == 1) {
                    next += Pair(i, j)
                }
            }
        }

        while (next.isNotEmpty()) {
            cur = next
            next = mutableListOf()

            cur.forEach { (i, j) ->
                if (result[i][j] > -1) {
                    // skip
                } else {
                    result[i][j] = num

                    if (i > 0) next += Pair(i - 1, j)
                    if (j > 0) next += Pair(i, j - 1)
                    if (i < n - 1) next += Pair(i + 1, j)
                    if (j < m - 1) next += Pair(i, j + 1)
                }
            }

            ++num
        }


        return result
    }
}