class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashTable = {}
        
        for i, num in enumerate(nums): 
            diff = target - num
            if diff in hashTable: 
                return [hashTable[diff], i]
            else: 
                hashTable[num] = i