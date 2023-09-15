class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        dictionary.sort()
        
        pointer = 1
        for loop in range(len(dictionary) - 1):
            if dictionary[pointer].startswith(dictionary[pointer - 1]):
                del dictionary[pointer]
            else:
                pointer += 1
        
        strings = sentence.split()
        
        for index, string in enumerate(strings):
            pos = max(0, bisect.bisect_right(dictionary, string) - 1)
            if string.startswith(dictionary[pos]):
                strings[index] = dictionary[pos]
        
        return ' '.join(strings)