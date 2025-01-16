class Solution {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        val a = if (nums1.size % 2 == 0) 0 else nums2.reduce { x, y -> x.xor(y) }
        val b = if (nums2.size % 2 == 0) 0 else nums1.reduce { x, y -> x.xor(y) }

        return a.xor(b)
    }
}