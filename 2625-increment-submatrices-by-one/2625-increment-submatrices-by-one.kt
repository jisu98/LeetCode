class Solution {
    fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
        val diff = Array(n) { IntArray(n) }
        val output = Array(n) { IntArray(n) }

        for (q in queries) {
            for (i in q[0]..q[2]) {
                diff[i][q[1]]++
                if (q[3] < n - 1)diff[i][q[3] + 1]--
            }
        }

        for (i in 0 until n) {
            output[i][0] = diff[i][0]
            
            for (j in 1 until n) {
                output[i][j] = output[i][j - 1] + diff[i][j]
            }
        }

        return output
    }
}