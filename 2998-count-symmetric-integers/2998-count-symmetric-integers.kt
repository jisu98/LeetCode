class Solution {
    fun countSymmetricIntegers(low: Int, high: Int): Int {
        return (low..high).count { num ->
            val str = num.toString()

            if (str.length % 2 == 1) {
                false
            } else {
                str.take(str.length / 2).sumOf { it.digitToInt() } ==
                        str.drop(str.length / 2).sumOf { it.digitToInt() }
            }
        }
    }
}