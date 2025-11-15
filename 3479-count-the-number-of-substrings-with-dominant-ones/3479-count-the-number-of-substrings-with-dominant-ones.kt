class Solution {
    fun numberOfSubstrings(s: String): Int {
        val len = s.length
        val zeros = IntArray(len)
        var zeroCount = 0
        var answer = 0

        for (i in s.indices) {
            if (s[i] == '0') zeroCount++

            zeros[i] = zeroCount
        }

        fun isOneDominant(left: Int, right: Int): Boolean {
            if (right >= len) return false

            val zeroCount = if (left == 0) zeros[right] else zeros[right] - zeros[left - 1]
            val oneCount = right - left + 1 - zeroCount

            return oneCount >= zeroCount * zeroCount
        }

        fun getNextRight(left: Int, right: Int): Int {
            if (right >= len) return right

            val zeroCount = if (left == 0) zeros[right] else zeros[right] - zeros[left - 1]

            return left + zeroCount + zeroCount * zeroCount - 1
        }

        for (left in 0 until len) {
            var right = left

            while (right < len) {
                if (isOneDominant(left, right)) {
                    val rightBound = indexOfLast(zeros, right)
                    answer += rightBound - right + 1
                    right = rightBound + 1
                } else {
                    right = getNextRight(left, right)
                }
            }
        }

        return answer
    }

    private fun indexOfLast(array: IntArray, l: Int): Int {
        val target = array[l]
        var left = l
        var right = array.size - 1

        while (left <= right) {
            val mid = (left + right) / 2

            if (array[mid] > target) right = mid - 1
            else left = mid + 1
        }

        return right
    }
}