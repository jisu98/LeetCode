class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val m = heights.size
        val n = heights[0].size
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { heights[it.first][it.second] })
        val visited = Array(m) { BooleanArray(n) }
        val pacific = Array(m) { BooleanArray(n) }
        val atlantic = Array(m) { BooleanArray(n) }

        // pacific
        for (i in 0 until m) {
            pq += i to 0
            visited[i][0] = true
        }
        for (i in 1 until n) {
            pq += 0 to i
            visited[0][i] = true
        }

        while (pq.isNotEmpty()) {
            val (x, y) = pq.poll()
            val adjacentCells = listOfNotNull(
                if (x > 0) x - 1 to y else null,
                if (y > 0) x to y - 1 else null,
                if (x < m - 1) x + 1 to y else null,
                if (y < n - 1) x to y + 1 else null,
            )

            if (
                x == 0
                || y == 0
                || adjacentCells.any {
                    pacific[it.first][it.second]
                            && heights[it.first][it.second] <= heights[x][y]
                }
            ) {
                pacific[x][y] = true
                adjacentCells.forEach {
                    if (!visited[it.first][it.second]) {
                        pq += it.first to it.second
                        visited[it.first][it.second] = true
                    }
                }
            }
        }

        // atlantic
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == m - 1 || j == n - 1) {
                    visited[i][j] = true
                    pq += i to j
                } else {
                    visited[i][j] = false
                }
            }
        }

        while (pq.isNotEmpty()) {
            val (x, y) = pq.poll()
            val adjacentCells = listOfNotNull(
                if (x > 0) x - 1 to y else null,
                if (y > 0) x to y - 1 else null,
                if (x < m - 1) x + 1 to y else null,
                if (y < n - 1) x to y + 1 else null,
            )

            if (
                x == m - 1
                || y == n - 1
                || adjacentCells.any {
                    atlantic[it.first][it.second]
                            && heights[it.first][it.second] <= heights[x][y]
                }
            ) {
                atlantic[x][y] = true
                adjacentCells.forEach {
                    if (!visited[it.first][it.second]) {
                        pq += it.first to it.second
                        visited[it.first][it.second] = true
                    }
                }
            }
        }

        // compare pacific to atlantic
        val answer = mutableListOf<List<Int>>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (pacific[i][j] && atlantic[i][j]) {
                    answer += listOf(i, j)
                }
            }
        }

        return answer
    }
}