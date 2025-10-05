class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        for (i in nums1.indices) {
            val idx = nums2.indexOf(nums1[i])
            var nextGreaterElement = -1

            for (j in idx + 1 until nums2.size) {
                if (nums2[j] > nums1[i]) {
                    nextGreaterElement = nums2[j]
                    break
                }
            }

            nums1[i] = nextGreaterElement
        }

        return nums1
    }
}