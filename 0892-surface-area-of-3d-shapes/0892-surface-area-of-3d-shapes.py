class Solution:
    def surfaceArea(self, grid: List[List[int]]) -> int:
        result = 0
        lenX, lenY = len(grid), len(grid[0])
        
        for x in range(lenX):
            for y in range(lenY):
                cube = grid[x][y]

                if cube == 0:
                    continue
                else:
                    result += 2 # top & bottom
                    
                if x == 0:
                    result += cube
                else:
                    result += max(0, cube - grid[x - 1][y])
                    
                if y == 0:
                    result += cube
                else:
                    result += max(0, cube - grid[x][y - 1])
                    
                if x == lenX - 1:
                    result += cube
                else:
                    result += max(0, cube - grid[x + 1][y])
                    
                if y == lenY - 1:
                    result += cube
                else:
                    result += max(0, cube - grid[x][y + 1])
                
        return result