class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:        
        ranges = [(i - range if i - range >= 0 else 0, i + range) for (i, range) in enumerate(ranges) if range > 0]
        ranges.sort(key = lambda x: x[0])
        
        left = 0
        candidate = 0
        cnt = 0
        
        # greedy
        for tap in ranges:
            # if have gap with previously selected one
            if tap[0] > left: 
                # cannot cover the range of [candidate, tap[0]]
                if tap[0] > candidate: 
                    return -1
                # determine to use the candidate
                else:
                    cnt += 1
                    left = candidate
                    candidate = tap[1]

            # if can compare with previous candidate
            else: 
                # skip if it is not better than current candidate
                if tap[1] <= candidate: 
                    pass
                # update candidate if it is better than current one
                else: 
                    candidate = tap[1]
            
            if candidate >= n:
                return cnt + 1

        return -1