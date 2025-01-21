class Solution {
    fun gridGame(grid: Array<IntArray>): Long {
        var firstLineSum = grid[0].sumOf { it.toLong() } - grid[0][0]
        var secondLineSum = 0L
        var result = firstLineSum

        (1..<grid[0].size).forEach { index ->
            firstLineSum -= grid[0][index]
            secondLineSum += grid[1][index - 1]
            result = minOf(result, maxOf(firstLineSum, secondLineSum))
        }

        return result
    }
}