class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        var result = listOf("")

        digits.forEach { digit ->
            result = result.flatMap { string ->
                when (digit) {
                    '2' -> listOf('a', 'b', 'c')
                    '3' -> listOf('d', 'e', 'f')
                    '4' -> listOf('g', 'h', 'i')
                    '5' -> listOf('j', 'k', 'l')
                    '6' -> listOf('m', 'n', 'o')
                    '7' -> listOf('p', 'q', 'r', 's')
                    '8' -> listOf('t', 'u', 'v')
                    else -> listOf('w', 'x', 'y', 'z')
                }.map {
                    string + it
                }
            }
        }
        
        return result
    }
}