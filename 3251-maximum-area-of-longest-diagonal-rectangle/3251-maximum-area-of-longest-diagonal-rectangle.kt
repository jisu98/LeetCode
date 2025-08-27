class Solution {
    fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
        var maxDiagonal = 0
        var maxArea = 0

        dimensions.forEach { dimension -> 
            val diagonal = dimension[0] * dimension[0] + dimension[1] * dimension[1]
            val area = dimension[0] * dimension[1]

            if (diagonal > maxDiagonal || (diagonal == maxDiagonal && area > maxArea)) {
                maxDiagonal = diagonal
                maxArea = area
            }
        }

        return maxArea
    }
}