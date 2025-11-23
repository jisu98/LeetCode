class Solution {
    fun maxSumDivThree(nums: IntArray): Int {
        val mods = Array(3) { PriorityQueue<Int>() }
        var sum = 0

        for (n in nums) {
            mods[n % 3].add(n)
            sum += n
        }

        when (sum % 3) {
            0 -> {
                return sum
            }

            1 -> {
                val candidate1 = if (mods[1].isEmpty()) null else mods[1].peek()
                val candidate2 = if (mods[2].size < 2) null else mods[2].poll() + mods[2].peek()

                return if (candidate1 == null) sum - (candidate2 ?: 0)
                else if (candidate2 == null) sum - candidate1
                else sum - minOf(candidate1, candidate2)
            }

            else -> {
                val candidate1 = if (mods[1].size < 2) null else mods[1].poll() + mods[1].peek()
                val candidate2 = if (mods[2].isEmpty()) null else mods[2].peek()

                return if (candidate1 == null) sum - (candidate2 ?: 0)
                else if (candidate2 == null) sum - candidate1
                else sum - minOf(candidate1, candidate2)
            }
        }
    }
}