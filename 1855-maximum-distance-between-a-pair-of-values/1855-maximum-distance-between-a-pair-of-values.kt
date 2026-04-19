class Solution {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        var distance = 0
        var i = 0
        var j = 0

        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] <= nums2[j]) {
                distance = maxOf(distance, j - i)
                j++
            } else {
                i++
                if (j < i) j = i
            }
        }

        return distance
    }
}