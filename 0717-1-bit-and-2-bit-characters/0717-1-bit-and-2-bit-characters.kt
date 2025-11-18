class Solution {
    fun isOneBitCharacter(bits: IntArray): Boolean {
        var i = 0

        while (i < bits.size - 1) {
            if (bits[i] == 0) i++
            else i += 2
        }

        return i == bits.size - 1
    }
}