class Solution {
    fun reverseWords(s: String): String {
        return s.split(" ").filter { it != "" }.reversed().joinToString(" ")
    }
}