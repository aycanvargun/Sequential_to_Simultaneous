package eszamanlilastirma;

import java.util.Arrays;

/******************************************************************************
 *  Compilation:  javac BreadthFirstPaths.java
 *  Execution:    java BreadthFirstPaths G s
 *  Dependencies: Graph.java Queue.java Stack.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/41graph/tinyCG.txt
 *
 *  Run breadth first search on an undirected graph.
 *  Runs in O(E + V) time.
 *
 *  %  java Graph tinyCG.txt
 *  6 8
 *  0: 2 1 5 
 *  1: 0 2 
 *  2: 0 1 3 4 
 *  3: 5 4 2 
 *  4: 3 2 
 *  5: 3 0 
 *
 *  %  java BreadthFirstPaths tinyCG.txt 0
 *  0 to 0 (0):  0
 *  0 to 1 (1):  0-1
 *  0 to 2 (1):  0-2
 *  0 to 3 (2):  0-2-3
 *  0 to 4 (2):  0-2-4
 *  0 to 5 (1):  0-5
 *
 *  %  java BreadthFirstPaths largeG.txt 0
 *  0 to 0 (0):  0
 *  0 to 1 (418):  0-932942-474885-82707-879889-971961-...
 *  0 to 2 (323):  0-460790-53370-594358-780059-287921-...
 *  0 to 3 (168):  0-713461-75230-953125-568284-350405-...
 *  0 to 4 (144):  0-460790-53370-310931-440226-380102-...
 *  0 to 5 (566):  0-932942-474885-82707-879889-971961-...
 *  0 to 6 (349):  0-932942-474885-82707-879889-971961-...
 *
 ******************************************************************************/


/**
 *  The <tt>BreadthFirstPaths</tt> class represents a data type for finding
 *  shortest paths (number of edges) from a source vertex <em>s</em>
 *  (or a set of source vertices)
 *  to every other vertex in an undirected graph.
 *  <p>
 *  This implementation uses breadth-first search.
 *  The constructor takes time proportional to <em>V</em> + <em>E</em>,
 *  where <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
 *  It uses extra space (not including the graph) proportional to <em>V</em>.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/41graph">Section 4.1</a>   
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class BreadthFirstPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path

    /**
     * Computes the shortest path between the source vertex <tt>s</tt>
     * and every other vertex in the graph <tt>G</tt>.
     * @param G the graph
     * @param s the source vertex
     */
    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
       // bfs(G, s);

     //   assert check(G, s);
    }

    /**
     * Computes the shortest path between any one of the source vertices in <tt>sources</tt>
     * and every other vertex in graph <tt>G</tt>.
     * @param G the graph
     * @param sources the source vertices
     */
    public BreadthFirstPaths(Graph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        bfs(G, sources);
    }

/*
    // breadth-first search from a single source
    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }
   */ 
    public void bfs_ozel(Graph G, int s, int dugum_sayisi) {
    	
    	Node[] tree_array_temp= new Node[dugum_sayisi]; 
    	
    	for(int kk=0; kk< dugum_sayisi; kk++)
    	{
    		tree_array_temp[kk] = new Node();
    		tree_array_temp[kk].cocuk_idleri = new int[dugum_sayisi];
    		Arrays.fill(tree_array_temp[kk].cocuk_idleri, -1);
    	}
    	
    	
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);
      int i=0; int j=0;
        while (!q.isEmpty()) {
            int v = q.dequeue();
            tree_array_temp[i].id =(v+1)*10;
           
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                	
                	 tree_array_temp[i].cocuk_idleri[j]= (w+1)*10 ;
                	 j++;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
            tree_array_temp[i].cocuk_sayisi=j;
            j=0;
            i++;
        }
       
        
        int kez=dugum_sayisi; int flag_external=0;;
    	while(kez !=0)
    	{	
        int anne =-1; int flag =0;
        for(i=0; i< dugum_sayisi; i++)
        {
        	if(tree_array_temp[i].cocuk_sayisi==1 && i !=0 && tree_array_temp[i].id !=-1)
        	{//aracý nod var demek ki
        		flag_external=1;
        		for(j=0; j< dugum_sayisi; j++)
        		{// Aracý nodun annesini arýyoruz
        			for(int k=0; k< dugum_sayisi; k++)
        			{
        				if(tree_array_temp[j].cocuk_idleri[k] ==tree_array_temp[i].id)
        				{
        					anne = j;
        					flag = 1;
        					break;
        				}
        				else if (tree_array_temp[j].cocuk_idleri[k] == -1)
        					break;
        				
        			}
        			 
        			if(flag == 1)
        			break;
        		}
        		
        		flag =0;
        		int rr=0;
        		for( rr=0; rr< dugum_sayisi; rr++)
        		{
        			if(tree_array_temp[anne].cocuk_idleri[rr] == tree_array_temp[i].id)
        				break;
        		}
        		//tek çocuklu nodun çocuðunu anneye baðladým
        		
        		int benim_cocugumun_idsi= tree_array_temp[i].cocuk_idleri[0];
        		int agacta_kacinci=-1;
        		for(agacta_kacinci = 0; agacta_kacinci<dugum_sayisi; agacta_kacinci++)
        		{
        			if(tree_array_temp[agacta_kacinci].id == benim_cocugumun_idsi)
        				break;
        		}
        		
        		
        		
        		tree_array_temp[anne].cocuk_idleri[rr]=benim_cocugumun_idsi ;
        		
        		for(int oo =0; oo< dugum_sayisi;oo++)
        		{
        			
        			tree_array_temp[i].cocuk_idleri[oo]= tree_array_temp[agacta_kacinci].cocuk_idleri[oo];
        		
        		}
        		
        		tree_array_temp[i].id= benim_cocugumun_idsi;
        		tree_array_temp[i].cocuk_sayisi= tree_array_temp[agacta_kacinci].cocuk_sayisi;
        		tree_array_temp[agacta_kacinci].id=-1;
        		
        	}
        	else if (tree_array_temp[i].cocuk_sayisi==1 && i ==0 &&  tree_array_temp[i].id !=-1)
        	{
        		System.out.printf("Root 1 cocuklu !!!! yeniden dene\n");
        		break;
        	}
        }
        if(flag_external ==0) 
        {
        	break;
        }
        else
        {
        	flag_external=0;
        }
     kez--;
        
    }
     // temporar tree yi temize çekelim
        
        
    	int gercek_nod_sayisi =0;
    	for(int oo =0; oo<dugum_sayisi; oo++)
    	{
    		
    		if(tree_array_temp[oo].id != -1)
    			gercek_nod_sayisi++;
    			
    	}
    	Eszamanlilastirma.node_sayisi = gercek_nod_sayisi;
    	Eszamanlilastirma.tree_array= new Node[gercek_nod_sayisi]; 
    	//Node dizisini temize çekiyoruz
    	 
    	for(int oo =0; oo< gercek_nod_sayisi; oo++)
    	{
    		Eszamanlilastirma.tree_array[oo]= new Node();
    	}
    	
    	
    	int kkk =0;
    	for(int oo =0; oo < dugum_sayisi; oo++)
    	{
    		if(tree_array_temp[oo].id != -1)
    		{
    			Eszamanlilastirma.tree_array[kkk].id= tree_array_temp[oo].id;
    			int cocukk=tree_array_temp[oo].cocuk_sayisi;
    			Eszamanlilastirma.tree_array[kkk].cocuk_sayisi= cocukk;
    			Eszamanlilastirma.tree_array[kkk].cocuk_idleri= new int[cocukk];
    		for(int tt=0; tt< cocukk; tt++)
    		{
    			Eszamanlilastirma.tree_array[kkk].cocuk_idleri[tt] = tree_array_temp[oo].cocuk_idleri[tt];
    		}
    		
    				kkk++;
    		}
    		
    	}
    ///id leri düzeltelim
    	
    	int tempid=-1;
    	for(int oo =0; oo< gercek_nod_sayisi; oo++)
    	{
    		tempid= Eszamanlilastirma.tree_array[oo].id;
    		for(int uu=0; uu< gercek_nod_sayisi; uu ++ )
    		{
    		 for(int yy=0; yy <  Eszamanlilastirma.tree_array[uu].cocuk_sayisi; yy++)
    		 {
    			 if(Eszamanlilastirma.tree_array[uu].cocuk_idleri[yy] == tempid)
    			 {
    				 Eszamanlilastirma.tree_array[uu].cocuk_idleri[yy] = oo+1; 
    				 
    			 }
    		 }
    			
    		}
    		Eszamanlilastirma.tree_array[oo].id=oo+1;
    		
    	}
    	
    	//System.out.printf("fsdfs");
    	
    }

    // breadth-first search from multiple sources
    private void bfs(Graph G, Iterable<Integer> sources) {
        Queue<Integer> q = new Queue<Integer>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    /**
     * Is there a path between the source vertex <tt>s</tt> (or sources) and vertex <tt>v</tt>?
     * @param v the vertex
     * @return <tt>true</tt> if there is a path, and <tt>false</tt> otherwise
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * Returns the number of edges in a shortest path between the source vertex <tt>s</tt>
     * (or sources) and vertex <tt>v</tt>?
     * @param v the vertex
     * @return the number of edges in a shortest path
     */
    public int distTo(int v) {
        return distTo[v];
    }

    /**
     * Returns a shortest path between the source vertex <tt>s</tt> (or sources)
     * and <tt>v</tt>, or <tt>null</tt> if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a shortest path, as an Iterable
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }
/*

    // check optimality conditions for single source
    private boolean check(Graph G, int s) {

        // check that the distance of s = 0
        if (distTo[s] != 0) {
            StdOut.println("distance of source " + s + " to itself = " + distTo[s]);
            return false;
        }

        // check that for each edge v-w dist[w] <= dist[v] + 1
        // provided v is reachable from s
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (hasPathTo(v) != hasPathTo(w)) {
                    StdOut.println("edge " + v + "-" + w);
                    StdOut.println("hasPathTo(" + v + ") = " + hasPathTo(v));
                    StdOut.println("hasPathTo(" + w + ") = " + hasPathTo(w));
                    return false;
                }
                if (hasPathTo(v) && (distTo[w] > distTo[v] + 1)) {
                    StdOut.println("edge " + v + "-" + w);
                    StdOut.println("distTo[" + v + "] = " + distTo[v]);
                    StdOut.println("distTo[" + w + "] = " + distTo[w]);
                    return false;
                }
            }
        }

        // check that v = edgeTo[w] satisfies distTo[w] + distTo[v] + 1
        // provided v is reachable from s
        for (int w = 0; w < G.V(); w++) {
            if (!hasPathTo(w) || w == s) continue;
            int v = edgeTo[w];
            if (distTo[w] != distTo[v] + 1) {
                StdOut.println("shortest path edge " + v + "-" + w);
                StdOut.println("distTo[" + v + "] = " + distTo[v]);
                StdOut.println("distTo[" + w + "] = " + distTo[w]);
                return false;
            }
        }

        return true;
    }
*/
    /**
     * Unit tests the <tt>BreadthFirstPaths</tt> data type.
     */
   /* public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        // StdOut.println(G);

        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d (-):  not connected\n", s, v);
            }

        }
    }

*/
}

