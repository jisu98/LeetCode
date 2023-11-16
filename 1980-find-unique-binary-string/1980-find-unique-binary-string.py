class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        integers = set([i for i in range(2 ** len(nums))])
        
        for num in nums:
            integers.remove(int(num, 2))
            
        return bin(integers.pop())[2:].zfill(len(nums))