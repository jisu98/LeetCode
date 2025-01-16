class Solution {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        return (if (nums1.size % 2 == 0) 0 else nums2.reduce(Int::xor)) xor
                (if (nums2.size % 2 == 0) 0 else nums1.reduce(Int::xor))
    }
}