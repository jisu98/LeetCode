class Solution:
    def surfaceArea(self, grid: List[List[int]]) -> int:
        result = 0
        
        for x in range(len(grid)):
            for y in range(len(grid[0])):
                if grid[x][y] == 0:
                    continue
                
                result += grid[x][y] * 4 + 2
                    
                if x > 0:
                    result -= 2 * min(grid[x - 1][y], grid[x][y])
                if y > 0:
                    result -= 2 * min(grid[x][y - 1], grid[x][y])
                
        return result