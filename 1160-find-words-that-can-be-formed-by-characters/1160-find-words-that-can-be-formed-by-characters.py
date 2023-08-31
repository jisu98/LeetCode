class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        result = 0
        counterChars = Counter(chars)
        
        for word in words:
            counterWord = Counter(word)
            if all([counterWord[char] <= counterChars[char] for char in counterWord]):
                result += len(word)
        
        return result