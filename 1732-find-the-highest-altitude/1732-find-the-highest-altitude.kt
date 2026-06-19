class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var max = 0

        gain.fold(0) { a, b ->
            max = maxOf(max, a + b)
            a + b 
        }
        
        return max
    }
}