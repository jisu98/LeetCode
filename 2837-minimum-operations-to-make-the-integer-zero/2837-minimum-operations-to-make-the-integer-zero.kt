class Solution {
    private fun countOnes(target: Long): Int {
        var count = 0
        var num = target

        while (num > 0) {
            if (num and 1 == 1L) count++
            num = num shr 1
        }

        return count
    }

    fun makeTheIntegerZero(num1: Int, num2: Int): Int {
        var count = 1

        while (true) {
            val target = num1 - count * num2.toLong()
            if (target < count) return -1
            if (countOnes(target) <= count) return count
            count++
        }
    }
}