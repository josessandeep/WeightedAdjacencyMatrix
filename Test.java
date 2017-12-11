
import java.util.*;
public class Test{
	
	
	private int[][] adjacencyMatrix;
	private Object [][] edgeslable;
	private int size;
	static int n;
	
	public Test(int size){
		this.size = size;
		adjacencyMatrix = new int[size][size];
		edgeslable = new Object[size][size];
		for(int[] single : adjacencyMatrix)
			Arrays.fill(single, Integer.MIN_VALUE);
		for(Object[] single : edgeslable)
			Arrays.fill(single, Integer.MIN_VALUE);
	}
 
	public void add(int source, int destination, int weight,Object edgelable){
		adjacencyMatrix[source][destination] = weight;
		edgeslable[source][destination]=edgelable;
	}
	
	
	public int indegree(int v) {
		int count=0;
		 for (int i = 0; i <= 6; i++) {
		        if (adjacencyMatrix[i][v] != Integer.MIN_VALUE) {
		            count++;
		        }
		    }
		return count;
		
	}
	
	public int outdegree(int v) {
		int count=0;
		 for (int i = 0; i <= 6; i++) {
		        if (adjacencyMatrix[v][i] != Integer.MIN_VALUE) {
		            count++;
		        }
		    }
		return count;
		
	}
	
	public void FindsourceDestination(Object e) {
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				if(edgeslable[i][j]==e) {
					System.out.println("Source :" +i);
					System.out.println("Destination :" +j);
				}
			}
		}
	
			
		
	}
	
	
	public void FindIncEdge(int node) {
		
		for(int i=0;i<=6;i++) {
			if(adjacencyMatrix[node][i] != Integer.MIN_VALUE)
			{
				Object o=edgeslable[node][i];
				System.out.println(o);
			}
			if(adjacencyMatrix[i][node] != Integer.MIN_VALUE)
			{
				Object k=edgeslable[i][node];
				System.out.println(k);
			}
		}
		
		
	}
	
   
	public static void main(String args[]){
		
	
		
		System.out.println("Enter the number of Vertices");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		
		int vertices[] = new int[n];
		for(int i=0;i<n;i++) {
			vertices[i]=i+1;
		}
		Test graph = new Test(vertices.length+1);
		
		System.out.println("Enter the number of edges: ");
		int edge=sc.nextInt();
		for(int i=0; i<edge; i++)
		{
			System.out.println("Enter source, destination, weight, edgelabel ");
			int s,d,w;
			Object e;
			s=sc.nextInt();
			d=sc.nextInt();
			w=sc.nextInt();
			e=sc.next().charAt(0);
			graph.add(s, d, w, e);
		}
		
		
		
		System.out.println("Enter the node for which you need Incident Edge: ");
		int node=sc.nextInt();
		graph.FindIncEdge(node);
		
		System.out.println("Enter the edge label for which you need the source and destination: ");
		Object o=sc.next().charAt(0);
		graph.FindsourceDestination(o);
		
		
		System.out.println("Enter the node for which you need Indegree and Outdegree:");
		int node1=sc.nextInt();
		System.out.println("InDegree: " +graph.indegree(node1));
		System.out.println("OutDegree: "+graph.outdegree(node1));
		
	}
	
}