class Solution {
    fun myPow(x: Double, n: Int): Double {
        var x = x
        var n = n.toLong()
        var result = 1.0

        if (n < 0) {
            x = 1 / x
            n = -n
        }

        while (n > 0) {
            if (n % 2 == 1L) result *= x
            x *= x
            n /= 2

            println(result)
        }

        return result
    }
}