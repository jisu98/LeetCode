class Solution {
    fun countServers(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid.first().size
        val total = grid.flatMap { it.toList() }.sum()

        val isolatedInRow = mutableSetOf<Pair<Int, Int>>()
        var isolatedCount = 0

        (0..<m).forEach { i ->
            var count = 0
            var candidate: Pair<Int, Int>? = null

            (0..<n).forEach { j ->
                if (grid[i][j] == 1) {
                    if (++count == 1) {
                        candidate = Pair(i, j)
                    }
                }
            }

            if (count == 1) {
                isolatedInRow += candidate!!
            }
        }
        (0..<n).forEach { j ->
            var count = 0
            var candidate: Pair<Int, Int>? = null

            (0..<m).forEach { i ->
                if (grid[i][j] == 1) {
                    if (++count == 1) {
                        candidate = Pair(i, j)
                    }
                }
            }

            if (count == 1 && candidate in isolatedInRow) {
                ++isolatedCount
            }
        }
        
        return total - isolatedCount
    }
}
