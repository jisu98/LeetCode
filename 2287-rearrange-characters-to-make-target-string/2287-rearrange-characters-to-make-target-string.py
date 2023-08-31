class Solution:
    def rearrangeCharacters(self, s: str, target: str) -> int:
        counterS = Counter(s)
        return min(counterS[c] // count for (c, count) in Counter(target).items())