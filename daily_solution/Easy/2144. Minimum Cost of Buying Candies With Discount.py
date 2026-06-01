class Solution:
    def minimumCost(self, cost: List[int]) -> int:
        # Sort in descending order
        cost.sort(reverse = True)

        queue = deque(cost)
        buy = []
        free = []

        # Process in groups of 3
        while len(queue) >= 3:
            # Take three candies
            c1 = queue.popleft()
            c2 = queue.popleft()
            c3 = queue.popleft()
            
            # Buy the two most expensive
            buy.append(c1)
            buy.append(c2)
            
            # Get the cheapest free
            free.append(c3)

        # If any candies remain (less than 3), buy them
        while queue:
            buy.append(queue.popleft())
        return sum(buy)
