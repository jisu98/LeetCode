class Solution {
    fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
        var base = 0L
        var min = 0L
        var max = 0L

        differences.forEach { d ->
            base = base + d
            min = minOf(min, base)
            max = maxOf(max, base)
        }

        return maxOf(0, upper - max - lower + min + 1).toInt()
    }
}