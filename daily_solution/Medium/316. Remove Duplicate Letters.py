class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        #find last index of all unique element in the given string
        last_index = {ch: i for i, ch in enumerate(s)}

        #create the stack
        stack = []
        seen = set()

        #do the look for access every element in the string
        for i,ch in enumerate(s):
            if ch in seen:
                continue
            while stack and ch < stack[-1] and i < last_index[stack[-1]]:
                seen.remove(stack.pop())
            stack.append(ch)
            seen.add(ch)
        
        #return result in string
        return "".join(stack)
