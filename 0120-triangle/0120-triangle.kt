class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        var prev: IntArray
        var cur = intArrayOf(0)

        for (i in 0 until triangle.size) {
            prev = cur
            cur = triangle[i].toIntArray()

            for (j in cur.indices) {
                if (j == 0) {
                    cur[j] += prev[j]
                } else if (j == cur.size - 1) {
                    cur[j] += prev[j - 1]
                } else {
                    cur[j] += minOf(prev[j], prev[j - 1])
                }
            }
        }

        return cur.min()
    }
}