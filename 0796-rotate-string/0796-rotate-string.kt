class Solution {
    fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false
        if (s == goal) return true

        for (i in 0 until s.length) {
            var flag = true

            for (j in 0 until s.length) {
                if (s[j] != goal[(i + j) % s.length]) {
                    flag = false
                    break
                }
            }

            if (flag) return true
        }

        return false
    }
}