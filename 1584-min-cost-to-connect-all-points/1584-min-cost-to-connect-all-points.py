class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        heap = []
        result = 0
        lastVisitedPoint = 0
        visited = set([lastVisitedPoint])
        
        for loop in range(len(points) - 1):
            for index, point in enumerate(points):
                if index not in visited:
                    heapq.heappush(heap, (abs(point[0] - points[lastVisitedPoint][0]) + abs(point[1] - points[lastVisitedPoint][1]), lastVisitedPoint, index))
                    
            while True:
                distance, i, j = heapq.heappop(heap)
                if j not in visited:
                    result += distance
                    visited.add(j)
                    lastVisitedPoint = j
                    break
        
        return result