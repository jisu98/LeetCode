class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf(listOf(1))

        for (i in 1 until numRows) {
            result += (result[i - 1].indices + i).map { j ->
                result[i - 1].getOrElse(j - 1) { 0 } + result[i - 1].getOrElse(j) { 0 }
            }
        }

        return result
    }
}