class Solution {
    fun countGoodIntegers(n: Int, k: Int): Long {
        val factorial = createFactorial(n)

        return createPalindromeList(n)
            .filter { it.toLong() % k == 0L }
            .map { palindrome ->
                palindrome.groupBy { it }.mapValues { it.value.size }
            }
            .toHashSet()
            .sumOf {
                (factorial[n] - it.getOrElse('0') { 0 } * factorial[n - 1]) /
                        it.values.fold(1L) { acc, i -> acc * factorial[i] }
            }
    }

    private fun createFactorial(n: Int): List<Long> {
        val list = mutableListOf(1L, 1L)

        for (i in 2..n) {
            list += list.last() * i
        }

        return list
    }

    private fun createPalindromeList(n: Int): List<String> {
        val start = 10.0.pow(n / 2 - 1).toInt()
        val end = 10.0.pow(n / 2).toInt() - 1
        val baseList = if (n % 2 == 0) listOf("") else (0..9).map { it.toString() }

        if (n == 1) return baseList

        return baseList.flatMap { base ->
            (start..end).map {
                val s = it.toString()
                s + base + s.reversed()
            }
        }
    }
}