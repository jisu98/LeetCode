class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        countLR, count_ = 0, 0
        
        for move in moves:
            if move == 'L':
                countLR += 1
            elif move == 'R':
                countLR -= 1
            else:
                count_ += 1
        
        return abs(countLR) + count_