class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { grid[it.first][it.second] })
        val visited = Array(n) { BooleanArray(n) }
        val directions = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        var answer = -1

        pq += 0 to 0
        visited[0][0] = true

        while (true) {
            if (pq.peek() == n - 1 to n - 1) return maxOf(answer, grid[n - 1][n - 1])

            val cur = pq.poll()
            answer = maxOf(answer, grid[cur.first][cur.second])

            directions.forEach { (dx, dy) ->
                val x = cur.first + dx
                val y = cur.second + dy

                if (x in 0 until n && y in 0 until n && !visited[x][y]) {
                    pq += x to y
                    visited[x][y] = true
                }
            }
        }
    }
}