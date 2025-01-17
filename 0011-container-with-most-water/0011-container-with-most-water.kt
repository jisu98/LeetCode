class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var result = 0

        while (left < right) {
            result = maxOf(
                result,
                (right - left) * minOf(height[left], height[right]),
            )
            if (height[left] < height[right]) {
                ++left
            } else {
                --right
            }
        }

        return result
    }
}