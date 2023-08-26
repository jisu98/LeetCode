class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sortedNums = sorted([(nums[i], i) for i in range(len(nums))])
        
        i, j = 0, len(nums) - 1
        
        while True: 
            currentSum = sortedNums[i][0] + sortedNums[j][0]
            if currentSum == target: 
                return [sortedNums[i][1], sortedNums[j][1]]
            elif currentSum < target: 
                i += 1
            else: 
                j -= 1