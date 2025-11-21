class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val alphabetToIndex = Array(26) { mutableListOf<Int>() }
        var count = 0

        for (i in s.indices) {
            alphabetToIndex[s[i] - 'a'] += i
        }

        for (i in 0 until 26) {
            if (alphabetToIndex[i].size < 2) continue

            for (j in 0 until 26) {
                if (hasElementInRange(
                        alphabetToIndex[j],
                        alphabetToIndex[i].first(),
                        alphabetToIndex[i].last(),
                    )
                ) count++
            }
        }

        return count
    }

    private fun hasElementInRange(list: List<Int>, start: Int, end: Int): Boolean {
        val index = list.binarySearch(start + 1).let {
            if (it >= 0) it else -it - 1
        }

        return index < list.size && list[index] < end
    }
}