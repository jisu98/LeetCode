class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val len = s.count()
        val palindromeSet = mutableSetOf<Pair<Char, Char>>()
        val notPalindromeSet = mutableSetOf<Pair<Char, Char>>()

        for (i in 0..<(len - 2)) {
            if (palindromeSet.any { it.first == s[i] }) continue
            if (notPalindromeSet.any { it.first == s[i] }) continue

            for (j in (i + 1)..<(len - 1)) {
                if (Pair(s[i], s[j]) in palindromeSet) continue
                if (Pair(s[i], s[j]) in notPalindromeSet) continue

                for (k in j + 1..<len) {
                    if (s[i] == s[k]) {
                        palindromeSet += Pair(s[i], s[j])
                    }
                }
                
                if (Pair(s[i], s[j]) !in palindromeSet) {
                    notPalindromeSet += Pair(s[i], s[j])
                }
            }
        }

        return palindromeSet.size
    }
}