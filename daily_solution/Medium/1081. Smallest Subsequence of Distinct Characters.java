class Solution {
    public String smallestSubsequence(String s) {
        int freq[]=new int[26];
        boolean visited[]=new boolean[26];

        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        //create a monotonic stack
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            int index = c-'a';
            freq[index]--;
            if(visited[index])
                continue;

            while(!stack.isEmpty()&&stack.peek()>c&&freq[stack.peek()-'a']>0){
                visited[stack.pop()-'a']=false;
            }
            stack.push(c);
            visited[index]=true;
        }
        StringBuilder result = new StringBuilder();
        for(char c:stack){
            result.append(c);
        }
        return result.toString();
    }
}
