class Solution {
    static void addedges(ArrayList<ArrayList<Integer>> graph, int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    static void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<Integer> componet){
        visited[node]=true;
        componet.add(node);
        for(int neighbour:graph.get(node)){
            if(!(visited[neighbour])){
                dfs(neighbour, graph, visited,componet);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new ArrayList());
        }
        
        for(int[] edge: edges){
            addedges(graph, edge[0],edge[1]);
        }

        boolean visited[]=new boolean[n];
        int result =0;
        for(int i=0;i<n;i++){
            if(!(visited[i])){
                ArrayList<Integer> componet = new ArrayList<>();
                dfs(i,graph,visited, componet);
                int edge = 0;
                int vertex = componet.size();

                for(int node : componet){
                    edge += graph.get(node).size(); 
                }
                edge /=2;
                if(edge == vertex*(vertex-1)/2)
                    result += 1;
            }
        }
        return result;
    
    }
}
