class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int k = 0; k < numCourses; k++){
            adj[k] = new ArrayList();
        }
        for(int[] pre:prerequisites)
            adj[pre[0]].add(pre[1]);
        
        int[] visited = new int[numCourses];
        for(int k = 0; k < numCourses; k++)
            if(visited[k] == 0 && !dfs(adj,visited,k))
                return false;
        return true;
    }
    private boolean dfs(ArrayList<Integer>[] adj, int[] visited,int s){
        if(visited[s]==1)
            return false;
        visited[s]=1;
        for(int ad : adj[s])
            if(!dfs(adj,visited,ad))
                return false;
        visited[s]=2;
        return true;
            
    }
}
