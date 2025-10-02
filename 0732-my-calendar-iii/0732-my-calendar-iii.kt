class MyCalendarThree {
    private val calendar = TreeMap<Int, Int>()
    private var max = 0

    fun book(startTime: Int, endTime: Int): Int {
        calendar.merge(startTime, 1, Int::plus)
        calendar.merge(endTime, -1, Int::plus)

        calendar.remove(startTime, 0)
        calendar.remove(endTime, 0)

        calendar.headMap(endTime).values.fold(0) { a, b ->
            max = maxOf(max, a + b)
            a + b
        }

        return max
    }
}