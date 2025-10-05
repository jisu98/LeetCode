class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val monotonicStack = mutableListOf<Int>()
        val nextGreaterMap = hashMapOf<Int, Int>()

        for (n in nums2) {
            while (monotonicStack.isNotEmpty()) {
                val last = monotonicStack.last()

                if (last < n) {
                    nextGreaterMap[monotonicStack.removeLast()] = n
                } else {
                    break
                }
            }

            monotonicStack += n
        }

        for (i in nums1.indices) {
            nums1[i] = nextGreaterMap.getOrDefault(nums1[i], -1)
        }

        return nums1
    }
}