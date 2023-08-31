class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 1
        
        for i in range(len(digits)):
            sum = carry + digits[-i - 1]
            if sum < 10:
                carry = 0
                digits[-i - 1] = sum
            else:
                carry = 1
                digits[-i -1 ] = sum - 10
        
        if carry == 1:
            return [1] + digits
        else:
            return digits