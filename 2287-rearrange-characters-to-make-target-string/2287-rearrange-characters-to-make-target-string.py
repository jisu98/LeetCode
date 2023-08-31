class Solution:
    def rearrangeCharacters(self, s: str, target: str) -> int:
         return min(Counter(s)[c] // count for (c, count) in Counter(target).items())