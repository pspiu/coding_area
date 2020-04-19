import java.io.*; 
import java.util.*; 
  
// This class represents a directed graph using adjacency list 
// representation 
class Graph 
{ 
    private int V;   // No. of vertices 
  
    // Array  of lists for Adjacency List Representation 
    Map<Integer,List<Integer>> adj; 
  
    // Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new HashMap();
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj.putIfAbsent(v, new ArrayList<>());
        adj.get(v).add(w);
        } 

    void DFS(int v) 
    { 
        boolean visited[] = new boolean[V]; 
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    }
    
    void DFSUtil(int v,boolean visited[])
    {
     visited[v]=true;
     System.out.print(v+" ");
     Iterator<Integer> it = adj.get(v).iterator();
     while(it.hasNext())
     {
         int ele=it.next();
         if(!visited[ele])
         DFSUtil(ele,visited);
     } 
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
            //iterate though element you just popped; do not use 'vertex';use 'ele'
            Iterator < Integer > itr = adj.get(ele).iterator();
            while (itr.hasNext()) {
                int adj_ele = itr.next();
                if (!visited[adj_ele]) {
                    visited[adj_ele] = true;
                    queue.add(adj_ele);
                }
            }
        }

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
        System.out.println("\nFollowing is Breadth First Traversal "+ 
                           "(starting from vertex 0)");   
        g.BFS(0); 
 
    } 
}