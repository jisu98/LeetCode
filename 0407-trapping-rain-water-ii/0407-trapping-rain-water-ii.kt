/*
https://leetcode.com/problems/trapping-rain-water-ii/solutions/1138028/python3-visualization-bfs-solution-with-explanation
보고 풀었음
*/

class Solution {

    fun trapRainWater(heightMap: Array<IntArray>): Int {
        val m = heightMap.size
        val n = heightMap[0].size

        if (m < 3 || n < 3) return 0

        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { heightMap[it.first][it.second] })
        val visited = Array(m) { BooleanArray(n) { false } }
        var level = 0
        var answer = 0

        // 외곽
        for (i in 0 until n) {
            visited[0][i] = true
            pq += 0 to i
            visited[m - 1][i] = true
            pq += m - 1 to i
        }
        for (i in 1 until m - 1) {
            visited[i][0] = true
            pq += i to 0
            visited[i][n - 1] = true
            pq += i to n - 1
        }

        fun Pair<Int, Int>.toHeight() = heightMap[first][second]

        while (pq.isNotEmpty()) {
            val cell = pq.poll()
            val x = cell.first
            val y = cell.second

            level = maxOf(level, cell.toHeight())

            // find adjacent cells
            listOfNotNull(
                if (x > 0 && !visited[x - 1][y]) x - 1 to y else null,
                if (y > 0 && !visited[x][y - 1]) x to y - 1 else null,
                if (x < m - 1 && !visited[x + 1][y]) x + 1 to y else null,
                if (y < n - 1 && !visited[x][y + 1]) x to y + 1 else null,
            ).forEach {
                if (it.toHeight() < level) {
                    answer += level - it.toHeight()
                }

                visited[it.first][it.second] = true
                pq += it
            }
        }

        return answer
    }
}