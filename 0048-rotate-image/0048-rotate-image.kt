class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size

        for (x in 0 until n / 2) {
            for(y in 0 until (n + 1) / 2) {
                val tmp = matrix[x][y]

                matrix[x][y] = matrix[n - y - 1][x]
                matrix[n - y - 1][x] = matrix[n - x - 1][n - y - 1]
                matrix[n - x - 1][n - y - 1] = matrix[y][n - x - 1]
                matrix[y][n - x - 1] = tmp
            }
        }
    }
}