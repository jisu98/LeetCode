class Solution {
    fun countBinaryPalindromes(n: Long): Int {
        val binary = n.toString(2)
        var answer = 1 // 0은 무조건 포함된다

        if (n == 0L) return 1
        if (n == 1L) return 2

        // 1자리~n-1자리는 미리 더해준다
        for (i in 1 until binary.length) {
            answer += 1 shl (i + 1) / 2 - 1
        }

        // n자리는 자기 자신보다 작거나 같은 것만 센다
        if (binary.length <= 2) {
            return if (isPalindrome(binary)) answer + 1
            else answer
        }

        var l = 0
        var r = (1 shl ((binary.length - 1) / 2)) - 1
        var mid: Int

        while (l <= r) {
            mid = (l + r) / 2
            val palindrome = createPalindrome(mid, binary.length)

            if (palindrome == n) return answer + mid + 1

            if (palindrome < n) l = mid + 1
            else r = mid - 1
        }

        return answer + l
    }

    private fun isPalindrome(n: String): Boolean {
        for (i in 0 until (n.length / 2)) {
            if (n[i] != n[n.length - i - 1]) return false
        }

        return true
    }

    private fun createPalindrome(seed: Int, length: Int): Long {
        val half = seed.toString(2).padStart((length - 1) / 2, '0')

        return if (length % 2 == 0) "1$half${half.reversed()}1".toLong(2)
        else "1${half.dropLast(1)}${half.reversed()}1".toLong(2)
    }
}