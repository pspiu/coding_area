import java.io.*; 
import java.util.*; 
  
// This class represents a directed graph using adjacency list 
// representation 
class Graph 
{ 
    private int V;   // No. of vertices 
  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  // Add w to v's list. 
    } 
  

    void BFS(int vertex) {
        boolean visited[] = new boolean[V];
        Queue < Integer > queue = new LinkedList < Integer > ();
        visited[vertex] = true;
        queue.add(vertex);

        //while(!queue.isEmpty())
        while (queue.size() !=0) {
            int ele = queue.poll();
            //int ele = queue.pop();
            System.out.print(ele + " ");
            Iterator < Integer > itr = adj[ele].listIterator();
            while (itr.hasNext()) {
                int adj_ele = itr.next();
                if (!visited[adj_ele]) {
                    visited[adj_ele] = true;
                    queue.add(adj_ele);
                }
            }
        }

    }
  
    // A function used by DFS 
    void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    } 
  
    public static void main(String args[]) 
    { 
        Graph g = new Graph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 0)");   
        g.DFS(0); 
        System.out.println("\n Following is BreadthFirst Traversal "+ 
                           "(starting from vertex 0)");   
        g.BFS(0); 
    } 
}