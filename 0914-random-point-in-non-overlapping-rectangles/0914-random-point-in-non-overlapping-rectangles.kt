class Solution(private val rects: Array<IntArray>) {
    private val points = rects.map {
        (it[2] - it[0] + 1L) * (it[3] - it[1] + 1)
    }
    private val totalPoints = points.sum()


    fun pick(): IntArray {
        var rand = Random.nextLong(0, totalPoints)
        var rect = 0

        for (i in points.indices) {
            if (rand >= points[i]) {
                rand -= points[i]
            } else {
                rect = i
                break
            }
        }

        val width = rects[rect][2] - rects[rect][0] + 1
        return intArrayOf(
            rects[rect][0] + (rand % width).toInt(),
            rects[rect][1] + (rand / width).toInt(),
        )
    }
}