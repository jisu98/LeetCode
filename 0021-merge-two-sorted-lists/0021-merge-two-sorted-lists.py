# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummyHead = ListNode()
        currentNode = dummyHead
        
        while True:
            if list1 == None:
                currentNode.next = list2
                break
            if list2 == None:
                currentNode.next = list1
                break
            
            if list1.val < list2.val:
                currentNode.next = ListNode(list1.val)
                currentNode = currentNode.next
                list1 = list1.next
            else:
                currentNode.next = ListNode(list2.val)
                currentNode = currentNode.next
                list2 = list2.next
            
        return dummyHead.next