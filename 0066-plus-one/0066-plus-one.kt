class Solution {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size - 1 downTo 0) {
            if (digits[i] == 9) {
                digits[i] = 0
            } else {
                digits[i] += 1
                return digits
            }
        }
        
        return intArrayOf(1) + digits
    }
}