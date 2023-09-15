class Solution:
    def twoOutOfThree(self, nums1: List[int], nums2: List[int], nums3: List[int]) -> List[int]:
        counter = Counter()
        
        counter.update(set(nums1))
        counter.update(set(nums2))
        counter.update(set(nums3))
        
        return [key for key in counter if counter[key] >= 2]