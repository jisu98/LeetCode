class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        return candies.map { it + extraCandies >= candies.max()}
    }
}