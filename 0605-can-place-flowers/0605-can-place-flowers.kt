class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var maxPlots = 0
        var flag = true

        flowerbed.forEachIndexed { i, plot -> 
            if (plot == 1) {
                flag = false
            } else if (flag && (i == flowerbed.size - 1 || flowerbed[i + 1] == 0)) {
                flag = false
                maxPlots += 1
            } else {
                flag = true
            }
        }

        return maxPlots >= n
    }
}