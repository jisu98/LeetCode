class Solution {
    fun countPermutations(complexity: IntArray): Int {
        val mod = 1000000007
        val len = complexity.size

        for (i in 1 until len) {
            if (complexity[i] <= complexity[0]) return 0
        }

        var ans = 1L

        for (i in 1 until len) {
            ans = (ans * i) % mod
        }

        return ans.toInt()
    }
}