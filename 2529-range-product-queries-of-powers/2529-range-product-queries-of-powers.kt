class Solution {
    fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
        var _n = n
        var pow = 1L
        val powers = mutableListOf<Long>()
        while (_n > 0) {
            if (_n % 2 == 1) powers += pow
            pow *= 2
            _n /= 2
        }

        val answer = IntArray(queries.size) { 1 }
        queries.forEachIndexed { index, query -> 
            var cur = query[0]
            while (cur <= query[1]) {
                answer[index] = (answer[index] * powers[cur] % 1000000007).toInt()
                cur++
            }
        }

        return answer
    }
}