class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        countL, countR, count_ = 0, 0, 0
        
        for move in moves:
            if move == 'L':
                countL += 1
            elif move == 'R':
                countR += 1
            else:
                count_ += 1
        
        return abs(countL - countR) + count_