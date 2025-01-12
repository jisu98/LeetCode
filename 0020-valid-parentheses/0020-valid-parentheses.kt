class Solution {
    fun isValid(s: String): Boolean {
        if (s.length % 2 == 1) return false

        val stack = Stack<Char>()

        try {
            s.forEach { c ->
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c)
                } else {
                    stack.pop().let {
                        if (
                            it == '(' && c != ')'
                            || it == '{' && c != '}'
                            || it == '[' && c != ']'
                        ) {
                            throw Exception()
                        }
                    }
                }
            }
        } catch (e: Exception) {
            return false
        }

        return stack.isEmpty()
    }
}