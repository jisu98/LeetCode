class Solution {
    fun minimizeXor(num1: Int, num2: Int): Int {
        var n1 = Integer.toBinaryString(num1).toCharArray()
        var n2 = Integer.toBinaryString(num2)

        val lengthDiff = n1.size - n2.length
        if (lengthDiff > 0) {
            n2 = "0".repeat(lengthDiff) + n2
        } else if (lengthDiff < 0) {
            n1 = CharArray(-lengthDiff) { '0' } + n1
        }

        var count = n1.count { it == '1' } - n2.count { it == '1' }
        var cur = n1.size - 1
        while (count != 0) {
            if (count > 0 && n1[cur] == '1') {
                n1[cur] = '0'
                --count
            } else if (count < 0 && n1[cur] == '0') {
                n1[cur] = '1'
                ++count
            }
            --cur
        }

        return Integer.parseInt(n1.concatToString(), 2)
    }
}