class Solution {
    fun survivedRobotsHealths(
        positions: IntArray,
        healths: IntArray,
        directions: String
    ): List<Int> {
        data class Robot(
            val index: Int,
            val position: Int,
            var health: Int,
            val direction: Boolean, // 'R': true, 'L': false
        )

        val n = positions.size
        val stack = mutableListOf<Robot>()
        val robots = (0 until n).map { i ->
            Robot(
                index = i,
                position = positions[i],
                health = healths[i],
                direction = directions[i] == 'R'
            )
        }.sortedBy { it.position }

        for (r in robots) {
            while (stack.isNotEmpty() && stack.last().direction && !r.direction && r.health > 0) {
                if (stack.last().health > r.health) {
                    r.health = 0
                    stack.last().health--
                    break
                } else if (stack.last().health == r.health) {
                    r.health = 0
                    stack.removeLast()
                    break
                } else {
                    r.health--
                    stack.removeLast()
                }
            }

            if (r.health > 0) {
                stack += r
            }
        }

        return stack.sortedBy { it.index }.map { it.health }
    }
}
