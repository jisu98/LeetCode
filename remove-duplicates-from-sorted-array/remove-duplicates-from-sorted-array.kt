class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var lastNum = -101
        var k = 0
        
        nums.forEachIndexed { index, num ->
            if (num > lastNum) {
                nums[k] = num
                lastNum = num
                k += 1
            }
        }
        
        return k
    }
}