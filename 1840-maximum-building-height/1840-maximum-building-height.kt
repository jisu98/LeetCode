class Solution {
    fun maxBuilding(n: Int, restrictions: Array<IntArray>): Int {
        val restrictions =
            (restrictions + intArrayOf(1, 0) + intArrayOf(n, 1000000000)).sortedBy { it[1] }
        val heights = TreeMap<Int, Int>()
        var max = 0

        for (r in restrictions) {
            val left = heights.floorEntry(r[0])
            val right = heights.ceilingEntry(r[0])
            var cur = r[1]

            if (left != null) cur = minOf(cur, left.value + r[0] - left.key)
            if (right != null) cur = minOf(cur, right.value + right.key - r[0])

            heights[r[0]] = cur
            max = maxOf(max, cur)
        }

        heights.entries.reduce { a, b ->
            max = maxOf(max, (a.value + b.value + b.key - a.key) / 2)
            b
        }

        return max
    }
}