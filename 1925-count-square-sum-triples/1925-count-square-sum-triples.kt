class Solution {
    fun countTriples(n: Int): Int {
        var count = 0

        for (c in 1..n) {
            for (a in 1 until c) {
                val b = sqrt(c * c - a * a.toDouble()).toInt()

                if (a * a + b * b == c * c) {
                    count++
                }
            }
        }

        return count
    }
}