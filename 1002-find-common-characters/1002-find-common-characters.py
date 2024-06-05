from collections import Counter

# c = list((Counter(a) & Counter(b)).elements())
class Solution(object):
    def count(self, word):
        frequencies = [0] * 26
        
        for character in word:
            frequencies[ord(character) - ord('a')] += 1
        
        return frequencies
    
    def intersect(self, word1, word2): 
        return [min(x, y) for x, y in zip(word1, word2)]
    
    def convert(self, frequencies): 
        result = []
        
        for index, frequency in enumerate(frequencies): 
            result += [chr(index + ord('a'))] * frequency
            
        return result
    
    def commonChars(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        return self.convert(reduce(self.intersect, map(self.count, words)))