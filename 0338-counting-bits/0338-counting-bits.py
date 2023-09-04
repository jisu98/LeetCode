class Solution:
    def countBits(self, n: int) -> List[int]:
        result = [0]
        i = 1
        
        while i <= n:
            result = result + [i + 1 for i in result]
            i = i * 2
            
        return result[:n + 1]