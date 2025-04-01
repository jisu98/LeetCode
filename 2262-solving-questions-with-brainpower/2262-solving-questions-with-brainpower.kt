class Solution {
    fun mostPoints(questions: Array<IntArray>): Long {
        val len = questions.size
        val solvePoints = LongArray(len) { 0L }
        val skipPoints = LongArray(len) { 0L }

        solvePoints[len - 1] = questions.last()[0].toLong()

        ((len - 2) downTo 0).forEach { index ->
            skipPoints[index] = maxOf(solvePoints[index + 1], skipPoints[index + 1])
            solvePoints[index] = maxOf(
                questions[index][0] +
                        (solvePoints.getOrNull(index + questions[index][1] + 1) ?: 0L),
                solvePoints[index + 1],
            )
        }

        return maxOf(skipPoints[0], solvePoints[0])
    }
}