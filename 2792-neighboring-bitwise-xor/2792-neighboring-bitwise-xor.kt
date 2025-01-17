class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        return derived.count { it == 1 } % 2 == 0
    }
}