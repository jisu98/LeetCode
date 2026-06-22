class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val map = text.groupingBy { it }.eachCount()

        return minOf(
            map.getOrDefault('b', 0),
            map.getOrDefault('a', 0),
            map.getOrDefault('l', 0) / 2,
            map.getOrDefault('o', 0) / 2,
            map.getOrDefault('n', 0),
        )
    }
}