class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        #create the array
        array = []

        #store only one element once in the array based on given string

        for i in range(len(word)):
            if word[i] in array:
                continue
            else:
                array.append(word[i])

        # split uppercase and lowercase array
        lowercase = []
        uppercase = []
        for s in array:
            if s.isupper():
                uppercase.append(s)
            else:
                lowercase.append(s)
        # count the special character in lowercase and uppercase help
        count = 0
        for s in lowercase:
            for S in uppercase:
                if s.upper() == S:
                    count += 1
        return count
