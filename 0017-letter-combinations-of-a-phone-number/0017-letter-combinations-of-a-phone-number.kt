class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        return letterCombinations(digits, listOf(""))
    }

    private fun letterCombinations(digits: String, list: List<String>): List<String> {
        if (digits.isEmpty()) return list

        return letterCombinations(digits.drop(1), list.flatMap { s ->
            when (digits.first()) {
                '2' -> listOf("${s}a", "${s}b", "${s}c")
                '3' -> listOf("${s}d", "${s}e", "${s}f")
                '4' -> listOf("${s}g", "${s}h", "${s}i")
                '5' -> listOf("${s}j", "${s}k", "${s}l")
                '6' -> listOf("${s}m", "${s}n", "${s}o")
                '7' -> listOf("${s}p", "${s}q", "${s}r", "${s}s")
                '8' -> listOf("${s}t", "${s}u", "${s}v")
                else -> listOf("${s}w", "${s}x", "${s}y", "${s}z")
            }
        })
    }
}