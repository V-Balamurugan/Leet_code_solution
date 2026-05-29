class Solution:
    def minElement(self, nums: List[int]) -> int:
        result = []
        for i in nums:
            digits = sum([int(d) for d in str(i)])
            result.append(digits)
        return min(result)
