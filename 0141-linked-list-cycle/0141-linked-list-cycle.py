# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        for i in range(pow(10, 4) + 1):
            if not head:
                return False
            else:
                head = head.next
        
        return True