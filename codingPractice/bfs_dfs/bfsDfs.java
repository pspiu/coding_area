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

Solution 2:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //avoid null pointer exception
        if(root ==null)
            return res;
        
        //create Map containing <level, array of TreeNode val at a given level>
       Map<Integer, List<Integer>> map = new HashMap();
        dfs(root,0, map);
        
        //iterate though map and add list of treenode's values res(list of list of treenode val)   
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet())
            res.add(entry.getValue());
        return res;
    }
    
    void dfs(TreeNode root, int level, Map<Integer,List<Integer>> map)
    {
        if(root ==null)
            return;
        //add entry for a given level in the map
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.val);
        dfs(root.left, level +1, map);
        dfs(root.right, level +1, map);
    }
}

Solution 3:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //avoid null pointer exception
        if(root ==null)
            return res;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            //create list and size fields for each level
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode ele =q.poll();
                level.add(ele.val);
                if(ele.left !=null)
                    q.add(ele.left);
                if(ele.right !=null)
                    q.add(ele.right);               
                
            }
            res.add(level);
            
        }
        return res;
    }
}