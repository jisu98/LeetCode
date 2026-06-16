class Solution {
    fun processStr(s: String): String {
        val cur = StringBuilder()

        for (c in s) {
            when (c) {
                '*' -> if (cur.isNotEmpty()) cur.deleteAt(cur.length - 1)
                '#' -> cur.append(cur)
                '%' -> cur.reverse()
                else -> cur.append(c)
            }
        }

        return String(cur)
    }
}