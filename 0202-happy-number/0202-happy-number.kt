class Solution {
    fun isHappy(n: Int): Boolean {
        var cur = n
        val loops = mutableSetOf(n)

        while (true) {
            cur = sumOfSquares(cur)

            if (cur == 1) return true
            else if (cur in loops) return false
        
            loops += cur
        }
    }

    fun sumOfSquares(n: Int): Int {
        var n = n
        val digits = mutableListOf<Int>()

        while(n > 0) {
            digits += n % 10
            n = n / 10
        }

        return digits.sumOf { it * it }
    }
}