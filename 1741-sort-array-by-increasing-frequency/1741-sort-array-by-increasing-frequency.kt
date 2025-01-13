class Solution {
    fun frequencySort(nums: IntArray): IntArray {
        return nums.sortedWith(
            compareBy(
                { nums.toList().groupingBy { it }.eachCount()[it] },
                { -it },
            )
        ).toIntArray()
    }
}