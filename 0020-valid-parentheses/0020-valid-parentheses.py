class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        
        try:
            for character in s:
                if character in ['(', '{', '[']:
                    stack.append(character)
                elif character == ')':
                    if stack.pop() != '(':
                        return False
                elif character == '}':
                    if stack.pop() != '{':
                        return False
                elif character == ']':
                    if stack.pop() != '[':
                        return False
        except IndexError:
            return False
                
        if stack:
            return False
        else:
            return True