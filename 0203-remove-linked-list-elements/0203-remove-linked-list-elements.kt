/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeElements(head: ListNode?, value: Int): ListNode? {
        val dummy = ListNode(-1).apply {
            next = head
        }

        removeElements(dummy, head, value)

        return dummy.next
    }

    private fun removeElements(prev: ListNode, cur: ListNode?, value: Int) {
        if (cur == null) return

        if (cur.`val` == value) {
            prev.next = cur.next
            removeElements(prev, cur.next, value)
        } else {
            removeElements(cur, cur.next, value)
        }
    }
}