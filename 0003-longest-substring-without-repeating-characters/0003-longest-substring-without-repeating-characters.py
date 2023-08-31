class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        memo = []
        left, right = 0, -1
        answer = 0
        
        for i, character in enumerate(s): 
            if character not in memo:
                right += 1
                memo.append(character)
            else: 
                duplicatedIndex = memo.index(character)
                memo = memo[duplicatedIndex + 1:] + [character]
                answer = max(right - left + 1, answer)
                left = left + duplicatedIndex + 1
                right = i
        
        return max(right - left + 1, answer)