class Solution {
    fun romanToInt(s: String): Int {
        return s.indices.sumOf { i ->
            when (s[i]) {
                'M' -> 1000
                'D' -> 500
                'C' -> if (i != s.length - 1 && (s[i + 1] == 'D' || s[i + 1] == 'M')) -100 else 100
                'L' -> 50
                'X' -> if (i != s.length - 1 && (s[i + 1] == 'L' || s[i + 1] == 'C')) -10 else 10
                'V' -> 5
                'I' -> if (i != s.length - 1 && (s[i + 1] == 'V' || s[i + 1] == 'X')) -1 else 1
                else -> (0).toInt()
            }
        }
    }
}