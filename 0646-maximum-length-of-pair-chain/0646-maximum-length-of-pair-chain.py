class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        result = 0
        maximum = -1001

        pairs.sort(key=lambda x: (x[1], -x[0]))

        for pair in pairs: 
            if pair[0] > maximum: 
                result += 1
                maximum = pair[1]
        
        return result