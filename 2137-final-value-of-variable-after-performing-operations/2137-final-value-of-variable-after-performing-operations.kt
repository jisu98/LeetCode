class Solution {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var value = 0

        for (o in operations) {
            if (o[1] == '+') value++
            else value--
        }

        return value
    }
}