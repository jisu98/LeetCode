class Solution {
    fun isPalindrome(s: String): Boolean {
        val s = s.lowercase()
        var left = 0 
        var right = s.length - 1

        while (true) {
            while (left < s.length && !s[left].isLetter()) left++
            while (right >= 0 && !s[right].isLetter()) right--

            if (left >= s.length || right < 0 || left >= right) break
            
            if (s[left] != s[right]) return false

            left++
            right--
        }

        return true
    }

    private fun Char.isLetter(): Boolean {
        return this in 'a'..'z' || this in '0'..'9'
    }
}