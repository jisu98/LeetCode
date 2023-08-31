class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        result = ""
        
        try:
            for i, character in enumerate(strs[0]):
                for string in strs:
                    if character != string[i]:
                        return result
                result += string[i]
        except IndexError:
            return result
            
        return result