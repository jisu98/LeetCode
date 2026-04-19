class Solution {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        var distance = 0

        for (i in nums1.indices) {
            distance = maxOf(distance, findLastLargerIndex(nums2, nums1[i]) - i)
        }

        return distance
    }

    private fun findLastLargerIndex(arr: IntArray, target: Int): Int {
        var l = 0
        var r = arr.size - 1
        
        while (l <= r) {
            val mid = (l + r) / 2

            if (arr[mid] >= target) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }

        return l - 1
    }
}