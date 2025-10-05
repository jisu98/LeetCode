class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val monotonicStack = mutableListOf<Int>()
        val nextGreaterMap = hashMapOf<Int, Int>()

        for (n in nums2) {
            while (monotonicStack.isNotEmpty() && monotonicStack.last() < n) {
                nextGreaterMap[monotonicStack.removeLast()] = n
            }

            monotonicStack += n
        }

        for (i in nums1.indices) {
            nums1[i] = nextGreaterMap.getOrDefault(nums1[i], -1)
        }

        return nums1
    }
}