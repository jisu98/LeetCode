class Solution {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        val secondEventValues = TreeMap<Int, Int>()
        var secondEventValue = 0
        var max = 0

        events.sortByDescending { it[0] }
        for (event in events) {
            secondEventValue = maxOf(secondEventValue, event[2])
            secondEventValues[event[0]] = secondEventValue
        }

        events.reverse()
        for (event in events) {
            val secondEvent = secondEventValues.ceilingEntry(event[1] + 1)?.value ?: 0
            max = maxOf(max, event[2] + secondEvent)
        }

        return max
    }
}