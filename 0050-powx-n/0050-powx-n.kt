class Solution {
    fun myPow(x: Double, n: Int): Double {
        return myPow(x, n.toLong())
    }

    fun myPow(x: Double, n: Long): Double {
        return if (n == 0L) 1.0
        else if (n < 0L) 1 / myPow(x, -n)
        else if (n == 1L) x
        else if (n % 2 == 0L) myPow(x * x, n / 2)
        else x * myPow(x * x, (n - 1) / 2)
    }
}