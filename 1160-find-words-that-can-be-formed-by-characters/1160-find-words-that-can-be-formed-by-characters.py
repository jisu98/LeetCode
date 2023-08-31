class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        result = 0
        counterChars = Counter(chars)
        
        for word in words:
            counterWord = Counter(word)
            for char in counterWord:
                if counterWord[char] > counterChars[char]:
                    break
            else:
                result += len(word)
                    
        return result