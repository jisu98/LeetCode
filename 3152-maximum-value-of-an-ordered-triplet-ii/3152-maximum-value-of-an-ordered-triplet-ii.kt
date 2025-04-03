class Solution {
    fun maximumTripletValue(nums: IntArray): Long {
        var maxI = 0
        var maxIMinusJ = 0L
        var max = 0L
        val len = nums.size

        val maxK = IntArray(len) { 0 }
        for (k in len - 1 downTo 2) {
            maxK[k] = maxOf(
                nums[k],
                maxK.getOrElse(k + 1) { 0 },
            )
        }


        for (i in 0..len - 3) {
            if (maxI >= nums[i]) continue

            maxI = nums[i]
            maxIMinusJ = 0

            for (j in i + 1..len - 2) {
                val iMinusJ = nums[i].toLong() - nums[j]

                if (iMinusJ > maxIMinusJ) {
                    maxIMinusJ = iMinusJ
                    max = maxOf(
                        max,
                        maxIMinusJ * maxK[j + 1]
                    )
                }
            }
        }

        return max
    }
}