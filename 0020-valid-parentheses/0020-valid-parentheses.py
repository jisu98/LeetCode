class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        
        for character in s:
            if character in "({[":
                stack.append(character)
            elif not stack:
                return False
            elif (character == ')' and stack.pop() != '(') or \
                (character == '}' and stack.pop() != '{') or \
                (character == ']' and stack.pop() != '['):
                    return False
                
        if stack:
            return False
        else:
            return True