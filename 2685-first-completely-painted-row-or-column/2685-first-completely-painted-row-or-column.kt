class Solution {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val positions = Array(arr.size + 1) { Pair(0, 0) }
        mat.forEachIndexed { index1, column ->
            column.forEachIndexed { index2, num ->
                positions[num] = Pair(index1, index2)
            }
        }

        val cols = IntArray(mat.size) { mat.first().size }
        val rows = IntArray(mat.first().size) { mat.size }

        arr.forEachIndexed { index, num ->
            val position = positions[num]

            if (--cols[position.first] == 0) return index
            if (--rows[position.second] == 0) return index
        }
        
        return -1
    }
}