class Solution:
    def removeStars(self, s: str) -> str:
        def remove_star(s):
            result = []
            i = 0
            while i < len(s):
                # If current char is '*' → remove previous char (if any) and skip '*'
                if s[i] == '*':
                    if result:   # remove closest non-star to the left
                        result.pop()
                    i += 1
                else:
                    result.append(s[i])
                    i += 1
            return "".join(result)
        while '*' in s:
            s = remove_star(s)
        return s
