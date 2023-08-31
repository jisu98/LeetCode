class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        result = 0
        
        for i in range(len(s)):
            if s[-i - 1] == ' ':
                if result == 0:
                    pass
                else: 
                    return result
            else:
                result += 1
        
        return result