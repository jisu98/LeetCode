class Solution {
    fun reorderedPowerOf2(n: Int): Boolean {
        val powOf2List = mutableListOf<Map<Char, Int>>()
        var powOf2 = 1
        for (i in 1..30) {
            powOf2List += powOf2.toString().groupingBy { it }.eachCount()
            powOf2 *= 2
        }

        return powOf2List.any { it == n.toString().groupingBy { it }.eachCount() }
    }
}