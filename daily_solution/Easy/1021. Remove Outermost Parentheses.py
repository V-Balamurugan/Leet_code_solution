class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        res = []
        balance = 0
        current = ""

        for ch in s:
            current += ch
            if ch == "(":
                balance += 1
            else:
                balance -= 1
            
            # when balance returns to 0, we have a complete group
            if balance == 0:
                res.append(current)
                current = ""

        result = []

        for word in res:
            temp = word[1:len(word)-1]
            result.append(temp)
        return "".join(result)
