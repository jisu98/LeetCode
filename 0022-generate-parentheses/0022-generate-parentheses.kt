class Solution {
    fun generateParenthesis(n: Int): List<String> {
        return generateParenthesis("", n, n)
    }

    private fun generateParenthesis(s: String, open: Int, close: Int): List<String> {
        if (open == 0 && close == 0) return listOf(s)
        
        val left = if (open > 0) generateParenthesis("$s(", open - 1, close) else emptyList()
        val right = if (close > open) generateParenthesis("$s)", open, close - 1) else emptyList()

        return left + right
    }
}