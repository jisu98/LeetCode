class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        var result = listOf(1)

        for (row in 0 until rowIndex) {
            result = listOf(1) + (result.indices - 0).map { i ->
                result[i - 1] + result[i]
            } + listOf(1)
        }

        return result  
    }
}