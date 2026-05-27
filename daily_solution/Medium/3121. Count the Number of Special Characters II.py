class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        # create the array of unique characters
        array = []
        for i in range(len(word)):
            if word[i] not in array:
                array.append(word[i])

        # split uppercase and lowercase
        lowercase = []
        uppercase = []
        for s in array:
            if s.isupper():
                uppercase.append(s)
            else:
                lowercase.append(s)

        # count special characters
        count = 0
        for s in lowercase:
            if s.upper() in uppercase:
                # find positions of lowercase and uppercase
                lower_positions = [i for i, c in enumerate(word) if c == s]
                upper_positions = [i for i, c in enumerate(word) if c == s.upper()]

                # check ordering rule
                if max(lower_positions) < min(upper_positions):
                    count += 1
        return count
