class Solution {
    fun minimumLength(s: String): Int {
        return s.toSet().map { c ->  
            if (s.count { it == c } % 2 == 0) 2 else 1
        }.sum()
    }
}