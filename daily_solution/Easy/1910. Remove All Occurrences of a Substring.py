class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        stack = []

        for ch in s:
            stack.append(ch)
            # If the end of stack matches 'part', remove it
            if "".join(stack[-len(part):]) == part:
                for _ in range(len(part)):
                    stack.pop()

        result = "".join(stack)
        return result
