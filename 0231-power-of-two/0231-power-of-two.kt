class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n < 1) return false
        if (n == 1) return true
        if (n % 2 == 0) return isPowerOfTwo(n/2)
        else return false
    }
}