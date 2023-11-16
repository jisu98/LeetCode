class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        nums = [int(num, 2) for num in nums]
        
        for i in range(len(nums) + 1):
            if i in nums:
                pass
            else:
                return bin(i)[2:].zfill(len(nums))