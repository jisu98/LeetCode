class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        memo = -101
        count = 0
        
        for num in nums:
            if num > memo:
                memo = num
                nums[count] = num
                count += 1
        
        return count