class Solution {
    fun maxWalls(robots: IntArray, distance: IntArray, walls: IntArray): Int {
        data class Robot(
            val index: Int,
            val position: Int,
            val distance: Int,
        )

        val robots = robots.mapIndexed { i, p ->
            Robot(
                index = i,
                position = p,
                distance = distance[i],
            )
        }.sortedBy { it.position }

        val dp = Array(robots.size) { IntArray(2) } // 0: left, 1: right

        walls.sort()

        dp[0][0] = countWalls(
            left = robots[0].position - robots[0].distance - 1,
            right = robots[0].position + 1,
            walls = walls,
        )
        dp[0][1] = countWalls(
            left = robots[0].position - 1,
            right = minOf(
                robots[0].position + robots[0].distance + 1,
                if (robots.size > 1) robots[1].position else Int.MAX_VALUE,
            ),
            walls = walls,
        )

        for (i in 1 until robots.size) {
            // shoot left
            dp[i][0] = maxOf(
                dp[i - 1][0] + countWalls(
                    left = maxOf(
                        robots[i - 1].position,
                        robots[i].position - robots[i].distance - 1,
                    ),
                    right = robots[i].position + 1,
                    walls = walls,
                ),
                dp[i - 1][1] + countWalls(
                    left = maxOf(
                        robots[i - 1].position + robots[i - 1].distance,
                        robots[i].position - robots[i].distance - 1,
                    ),
                    right = robots[i].position + 1,
                    walls = walls,
                ),
            )

            // shoot right
            dp[i][1] = if (i == robots.size - 1) {
                maxOf(dp[i - 1][0], dp[i - 1][1]) + countWalls(
                    left = robots[i].position - 1,
                    right = robots[i].position + robots[i].distance + 1,
                    walls = walls,
                )
            } else {
                maxOf(dp[i - 1][0], dp[i - 1][1]) + countWalls(
                    left = robots[i].position - 1,
                    right = minOf(
                        robots[i].position + robots[i].distance + 1, robots[i + 1].position
                    ),
                    walls = walls,
                )
            }
        }

        return maxOf(dp.last()[0], dp.last()[1])
    }

    // l r 둘 다 비포함하는 거로
    private fun countWalls(left: Int, right: Int, walls: IntArray): Int {
        val l = walls.binarySearch(left).let {
            if (it >= 0) it + 1 else -it - 1
        }

        val r = walls.binarySearch(right).let {
            if (it >= 0) it else -it - 1
        }

        return (r - l).coerceAtLeast(0)
    }
}