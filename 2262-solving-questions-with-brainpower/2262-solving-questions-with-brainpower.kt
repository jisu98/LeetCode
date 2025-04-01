class Solution {
    fun mostPoints(questions: Array<IntArray>): Long {
        val len = questions.size
        val points = LongArray(len) { 0L }

        ((len - 1) downTo 0).forEach { index ->
            points[index] = maxOf(
                points.getOrNull(index + 1) ?: 0L,
                questions[index][0] + (points.getOrNull(index + questions[index][1] + 1) ?: 0L),
            )
        }

        return points[0]
    }
}