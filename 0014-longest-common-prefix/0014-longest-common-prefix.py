class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        result = ""
        length = min([len(string) for string in strs])
        
        for i in range(length):
            for string in strs:
                if string[i] != strs[0][i]:
                    return result
            result += string[i]
            
        return result