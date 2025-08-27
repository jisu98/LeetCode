class Solution {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val m = mat.size
        val n = mat.first().size

        var x = 0
        var y = 0
        var dx = -1
        var dy = 1
        
        var answer = intArrayOf()

        fun changeDirection() {
            dx = -dx
            dy = -dy
        }

        for (i in 0 until m*n) {
            answer += mat[x][y]

            if (y + dy == n) { // right
                x = x + 1
                changeDirection()
            } else if (x + dx == -1) { // up
                y = y + 1
                changeDirection()
            } else if (x + dx == m) { // down
                y = y + 1
                changeDirection() 
            } else if (y + dy == -1) { // left
                x = x + 1
                changeDirection()
            } else {
                x = x + dx
                y = y + dy
            }
        }

        return answer
    }
}