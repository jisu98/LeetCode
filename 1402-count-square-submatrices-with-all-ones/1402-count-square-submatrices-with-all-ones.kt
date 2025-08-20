class Solution {
    fun countSquares(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix.first().size
        val side = Array(m) { _ -> IntArray(n) { 0 } }
        var answer = 0

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    side[i][j] = 0
                } else if (i == 0 || j == 0) {
                    side[i][j] = matrix[i][j]
                } else {
                    side[i][j] = minOf(side[i - 1][j], side[i - 1][j - 1], side[i][j - 1]) + 1
                }
                
                answer += side[i][j]
            }
        }

        return answer
    }
}