class Solution {
    fun containsCycle(grid: Array<CharArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) { BooleanArray(n) { false } }

        fun Pair<Int, Int>.isValid(): Boolean {
            return first in 0 until m && second in 0 until n
        }

        fun dfs(cur: Pair<Int, Int>, parent: Pair<Int, Int>): Boolean {
            if (cur.isValid() && parent.isValid() && visited[cur.first][cur.second] && grid[cur.first][cur.second] == grid[parent.first][parent.second]) return true
            if (!cur.isValid() || visited[cur.first][cur.second]) return false
            if (parent.isValid() && grid[cur.first][cur.second] != grid[parent.first][parent.second]) return false

            visited[cur.first][cur.second] = true

            return listOf(
                cur.first + 1 to cur.second,
                cur.first - 1 to cur.second,
                cur.first to cur.second + 1,
                cur.first to cur.second - 1,
            ).any {
                it.isValid() && it != parent && dfs(cur = it, parent = cur)
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (dfs(i to j, -1 to -1)) {
                    return true
                }
            }
        }

        return false
    }
}