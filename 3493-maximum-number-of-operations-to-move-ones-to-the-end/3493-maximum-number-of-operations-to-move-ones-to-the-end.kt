class Solution {
    fun maxOperations(s: String): Int {
        var total = 0
        var one = 0

        for (i in s.indices) {
            if (s[i] == '1') one++
            else if (i > 0 && s[i - 1] == '1') total += one
        }

        return total
    }
}