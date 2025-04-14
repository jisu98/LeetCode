class Solution {
    fun partitionLabels(s: String): List<Int> {
        val answer = mutableListOf<Int>()
        val map = hashMapOf<Char, Pair<Int, Int>>()

        s.forEachIndexed { index, c ->
            if (c in map) map[c] = Pair(map[c]!!.first, index)
            else map[c] = Pair(index, index)
        }

        var end = -1

        map.values.sortedBy { it.first }.forEachIndexed { index, it ->
            if (it.first > end) {
                answer += end + 1
                end = it.second
            } else {
                end = maxOf(end, it.second)
            }
        }
        answer += s.length

        return answer.zipWithNext { a, b -> b - a }
    }
}