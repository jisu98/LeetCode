class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var count = 0

        nums.forEach { num ->
            if (num != `val`) {
                nums[count++] = num
            }
        }

        return count
    }
}