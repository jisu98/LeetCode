class Solution:
    def surfaceArea(self, grid: List[List[int]]) -> int:
        result = 0
        
        for x in range(len(grid)):
            for y in range(len(grid[0])):
                cube = grid[x][y]

                if cube == 0:
                    continue
                else:
                    result += cube * 4 + 2
                    
                if x > 0:
                    result -= 2 * min(grid[x - 1][y], cube)
                if y > 0:
                    result -= 2 * min(grid[x][y - 1], cube)
                
        return result