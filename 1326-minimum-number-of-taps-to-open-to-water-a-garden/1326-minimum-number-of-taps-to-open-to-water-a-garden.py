class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:        
        taps = [(max(0, i - range), i + range) for (i, range) in enumerate(ranges) if range > 0]
        
        left = 0
        candidate = 0
        cnt = 0
        
        # greedy
        for tap in sorted(taps):
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
                    
            # update if it is better than current candidate
            elif tap[1] > candidate:
                candidate = tap[1]

            # covered all!
            if candidate >= n:
                return cnt + 1

        return -1