class Solution {
    fun frequencySort(nums: IntArray): IntArray {
        return nums.sortedWith(
            compareBy(
                { indexNum ->
                    nums.toSet().map { setNum ->
                        Pair(setNum, nums.count { it == setNum })
                    }.find {
                        it.first == indexNum
                    }?.second
                },
                { -it },
            )
        ).toIntArray()
    }
}