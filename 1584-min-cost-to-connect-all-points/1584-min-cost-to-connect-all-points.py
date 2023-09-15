class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        heap = []
        visited = set([0])
        result = 0
        lastVisitedPoint = 0
        
        while len(visited) < len(points):
            for index, point in enumerate(points):
                if index not in visited and index != lastVisitedPoint:
                    heapq.heappush(heap, (abs(point[0] - points[lastVisitedPoint][0]) + abs(point[1] - points[lastVisitedPoint][1]), lastVisitedPoint, index))
                    
            while True:
                distance, i, j = heapq.heappop(heap)
                if j in visited:
                    continue
                else:
                    result += distance
                    visited.add(j)
                    lastVisitedPoint = j
                    break
        
        return result