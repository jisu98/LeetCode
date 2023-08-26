# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode(0)
        cur = head
        carry = 0
        
        while not (l1 == None and l2 == None and carry == 0):
            num1 = l1.val if l1 != None else 0
            num2 = l2.val if l2 != None else 0
            sum = num1 + num2 + carry
            
            carry = sum // 10
            cur.next = ListNode(sum % 10)
            cur = cur.next
            
            l1 = l1.next if l1 != None else None
            l2 = l2.next if l2 != None else None
        
        return head.next