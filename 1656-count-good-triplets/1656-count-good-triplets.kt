class Solution {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        return (0..arr.size - 3).sumOf { i ->
            (i + 1..arr.size - 2).sumOf { j ->
                (j + 1..arr.size - 1).count { k ->
                    abs(arr[i] - arr[j]) <= a &&
                            abs(arr[k] - arr[j]) <= b &&
                            abs(arr[i] - arr[k]) <= c
                }
            }
        }
    }
}