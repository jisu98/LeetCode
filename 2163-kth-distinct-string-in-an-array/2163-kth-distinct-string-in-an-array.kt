class Solution {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        val distinct = mutableListOf<String>()
        val duplicated = mutableSetOf<String>()

        for (s in arr) {
            if (duplicated.contains(s)) continue
            if (distinct.contains(s)) {
                distinct.remove(s)
                duplicated += s
            } else {
                distinct += s
            }
        }

        return if (distinct.size >= k) distinct[k - 1]
        else ""
    }
}