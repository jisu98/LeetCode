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
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || head?.next == null || k == 0) return head

        var tail = head
        var count = 1

        while (tail?.next != null) {
            tail = tail?.next
            count++
        }

        var k = k % count

        if (k == 0) return head

        tail?.next = head

        tail = head

        for (i in 0 until count - k - 1) {
            tail = tail?.next
        }

        val newHead = tail?.next
        tail?.next = null

        return newHead
    }
}