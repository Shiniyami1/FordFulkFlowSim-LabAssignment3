// Prepared by Taijus Aggarwal 250968018
//Prepared by Mohommed Ali 250924795
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;

class Assignment3
{
    public Vertex<V> parentArray[] = new Vertex<V>[FN.numVertices()];
    // Returns true if a path from source 's' to destination 't' exists. Also uses parent[] to store the path
    boolean bfs(Graph FN, int s, int t)
    {
        // Create a visited array
        boolean visitedArray[] = new boolean[V];
        for(int i=0; i<t; ++i)
            visited[i]=false;

        // Create a queue, enqueue source vertex and mark source vertex as visited
        LinkedListQueue<Vertex<V>> queue = new LinkedList<Vertex<V>>();
        queue.enqueue(FN.getVertex(s));
        visitedArray[s] = true;
        parentArray[s]=-1;

        while (queue.size()!=0)
        {
            Vertex<V> node = LLQ.dequeue();
            //if (node == t) break;
            for (Edge<E> edge:fN.outgoingEdges(dequeuedNode))
            {
                Vertex<V> v = fN.opposite(dequeuedNode,edge);
                int vLabel = v.getLabel();
                boolean flowCheck = (edge.flowCapacity()-edge.flow())> 0;
                if (visitedArray[vLabel]==false && flowCheck)
                {
                    queue.enqueue(v);
                    parent[vLabel] = node;
                    visited[vLabel] = true;
                }
            }
        }
        return(visited[t]);// retruns if destination was reached and augmented path was found (visited[t] == true)
    }

    // Returns tne maximum flow from s to t in the given graph
    int fordFulkerson(Graph FN, int s, int t)
    {
        int maxFlow = 0;
        // Augment the flow if path from source to destination exists
        while (bfs(FN, s, t))
        {
            int pushFlow = Integer.MAX_VALUE;

  	        for (Vertex<V> v = parent[t]; v != -1; v = parent[v.getLabel()]) {
              Edge<E e = FN.getEdge(v.getLabel(),v);
              pushFlow = Math.min(pushFlow , e.flowCapacity - e.flow);
            }
        	// Adds to flow values and subtracts from reverse flow values in path
          	for (Vertex<V> v = parent[t]; v != -1; v = parent[v.getLabel()]) {
              Edge<E> e = FN.getEdge(v.getLabel(),v);
          		e.flow += pushFlow;
          		e.reverse.flow -= pushFlow; //Assuming reverse detection preintegrated
          	}

        	  maxFlow += pushFlow;
      	}
        return max_flow;
    }
}
