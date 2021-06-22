package L15Graph;

import java.util.*;
class Node {

        int data;
        public Node(int d) {
                data = d;
        }
}
class Edge {

        Node u;
        Node w;
        Boolean directed;
        int weight;

        public Edge(Node start, Node end) {
                u = start;
                w = end;
                weight = 1;
                directed = false;
        }

        public Edge(Node start, Node end, int weight) {
                u = start;
                w = end;
                this.weight = weight;
        }

        public Edge(Node start, Node end, boolean directed) {
                u = start;
                w = end;
                weight = 1;
                this.directed = directed;
        }
}


class Graph {

        ArrayList<ArrayList<Node>> GraphMap;

        public Graph() {
                GraphMap = new ArrayList<ArrayList<Node>>();
        }

        public int size() {
                return this.GraphMap.size();
        }

        public void add(ArrayList<Node> nodes) {
                for (int i = 0; i < nodes.size(); i++) {
                        GraphMap.add(new ArrayList<Node>());
                        GraphMap.get(i).add(0, nodes.get(i));
                }
        }

        public ArrayList<Node> getGraphNode(int i) {
                return this.GraphMap.get(i);
        }

        public void deleteGraphNode(int i) {
                GraphMap.remove(i);
        }

        public ArrayList<Node> getInitialList(Node n) {
                for (int i = 0; i < GraphMap.size(); i++) {
                        if (GraphMap.get(i).get(0) == n) {
                                return GraphMap.get(i);
                        }
                }
                return new ArrayList<Node>();
        }

        public int getIndexNode(Node n) {
                for (int i = 0; i < GraphMap.size(); i++) {
                        if (GraphMap.get(i).get(0) == n) {
                                return (i);
                        }
                }
                return -1;
        }

        public boolean isEdge(Node node1, Node node2) {
                for (int i = 0; i < GraphMap.size(); i++) {
                        for (int j = 1; j < GraphMap.get(i).size(); j++) {
                                if (GraphMap.get(i).get(0) == node1 && GraphMap.get(i).get(j) == node2) {
                                        return true;
                                }
                        }
                }
                return false;
        }
}

public class GraphTaskAL {


        static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
                adj.get(u).add(v);
                adj.get(v).add(u);
        }

        public static void main(String[] args) {
                // Creating a graph with 5 vertices 
                Graph g = new Graph();

                //Making Nodes
                Node n1 = new Node(1);
                Node n2 = new Node(2);
                Node n3 = new Node(3);
                Node n4 = new Node(4);
                Node n5 = new Node(5);
                //List of Nodes
                ArrayList<Node> nodes = new ArrayList<Node>();
                nodes.add(n1);
                nodes.add(n2);
                nodes.add(n3);
                nodes.add(n4);
                nodes.add(n5);
                //Adding Nodes to Graph
                addNodes(g, nodes);
                // Adding edges one by one 
                ArrayList <Edge> edges = new ArrayList<Edge>();
                boolean isDir = true;
                edges.add(new Edge(n1, n2, isDir));
                edges.add(new Edge(n1, n4, isDir));
                edges.add(new Edge(n2, n5, isDir));
                edges.add(new Edge(n3, n1, isDir));
                edges.add(new Edge(n3, n4, isDir));
                edges.add(new Edge(n4, n5, isDir));
                addEdges(g, edges);
                
                //List Of Nodes
                nodes = listOfNodes(g);
                printArrayList(nodes);
                
                //List Of Edges
                edges = listOfEdges(g);
                printEdgeList(edges);
                
                //Removing a node
                //removeNode(g,n4);
                
                //Test Mutual Neighbor
                ArrayList<Edge> e = new ArrayList<Edge>();
                e.add(new Edge(n4,n3,isDir));
                addEdges(g, e);
                System.out.println("Mutual Neigbours(n3 and n4)? "+ commonNeighbours(g,n3,n4));
                
                
                //Indegree OutDegree
                //printInDegreeOutDegree(g);
                
                //Display List Veiw
                //displayGraph(g);
                //Display Matrix Veiw
                display_adj_matrix(g);
        }

        public static Graph addNodes(Graph G, ArrayList<Node> nodes) {
                G.add(nodes);
                return G;
        }

        public static Graph addEdges(Graph G, ArrayList<Edge> E) {
                Node start;
                Node end;
                Boolean dir;
                for (int i = 0; i < E.size(); i++) {
                        start = E.get(i).u;
                        end = E.get(i).w;
                        dir = E.get(i).directed;
                                
                        if (dir) {
                                G.getInitialList(start).add(end);
                        } else {
                                G.getInitialList(start).add(end);
                                G.getInitialList(end).add(start);
                        }
                }
                return G;
        }

        public static ArrayList<Node> listOfNodes(Graph G) {
                ArrayList<Node> list = new ArrayList<Node>();
                for (int i = 0; i < G.size(); i++) {
                        list.add(G.getGraphNode(i).get(0));
                }
                return list;
        }
        public static ArrayList<Edge> listOfEdges(Graph G){
                ArrayList<Edge>edges = new ArrayList<Edge>();
                Node start;
                Node end;
                boolean directed;
                for (int i = 0; i < G.size(); i++) {
                        start  = G.getGraphNode(i).get(0);
                        for (int j = 1; j < G.getGraphNode(i).size(); j++) {
                                end  = G.getGraphNode(i).get(j);
                                directed = commonNeighbours(G,start,end);
                                edges.add(new Edge(start,end,directed));
                        }
                }
                return edges;
        }
        
        public static void printInDegreeOutDegree(Graph G){
                int [] inArray = new int[G.size()];
                int [] outArray = new int[G.size()];
                Node node;
                System.out.println("\nDisplaying in-degree out-degree");
                for (int i = 0; i < G.size(); i++) {
                        outArray[i] = G.getGraphNode(i).size()-1;
                        for (int j = 1; j < G.getGraphNode(i).size(); j++) {
                               node =  G.getGraphNode(i).get(j);
                               inArray[G.getIndexNode(node)]++;
                        }
                }
                for (int i = 0; i < G.size(); i++) {
                        System.out.println(i+"th Node has in-degree: "+ inArray[i]+", outDegree: "+outArray[i]);
                }
        }
        public static void removeNode(Graph G, Node node) {
                //Remove All Edges Except the head
                ArrayList<Node>list;
                for (int i = 0; i < G.size(); i++) {
                        if(i != G.getIndexNode(node)){
                                list = G.getGraphNode(i);
                                list.remove(node);
                        }
                }
                //Remove from Main List
                G.deleteGraphNode(G.getIndexNode(node));
        }
        public static void removeNodes(Graph G, ArrayList<Node>nodes){
                for(int i=0;i<nodes.size();i++)
                        removeNode(G, nodes.get(i));
        }

        public static void displayGraph(Graph G) {
                for (int i = 0; i < G.size(); i++) {
                        System.out.println("\nAdjacency list of vertex is..........." + i);
                        System.out.print("Head");
                        for (int j = 0; j < G.getGraphNode(i).size(); j++) {
                                System.out.print(" -> " + G.getGraphNode(i).get(j).data);
                        }
                        System.out.println();
                }
        }

        public static void display_adj_matrix(Graph G) {
                System.out.println("\nAdjacency Matrix is.......");
                int [][] matrix = new int[G.size()][G.size()];
                int index = 0;
                for (int i = 0; i < G.size(); i++) {
                        for (int j = 0; j < G.getGraphNode(i).size(); j++) {
                                        if (G.isEdge(G.getGraphNode(i).get(0), G.getGraphNode(i).get(j))) {
                                                index = G.getIndexNode(G.getGraphNode(i).get(j));
                                                matrix[i][index] =1;
                                        } else {
                                                matrix[i][j] = 0;
                                        }
                        }
                }
                for (int i = 0; i < G.size(); i++) {
                        for (int j = 0; j < G.size(); j++) {
                                System.out.print(matrix[i][j]+"  ");
                        }
                        System.out.println();
                }
                
        }
        public static boolean commonNeighbours(Graph G, Node n1, Node n2){
                ArrayList<Node> list1 = G.getInitialList(n1);
                ArrayList<Node> list2 = G.getInitialList(n2);
                return (list1.contains((Node)n2) && list2.contains((Node)n1));
        }
        public static void printArrayList(ArrayList<Node>nodes){
                System.out.println("Node's List ...:");
                for(int i =0;i< nodes.size();i++){
                        System.out.print(" ----|> " + nodes.get(i).data);
                }
                System.out.println("\n");
        }
         public static void printEdgeList(ArrayList<Edge>edges){
                System.out.println("Edge information:");
                Edge e;
                for(int i =0;i< edges.size();i++){
                        e = edges.get(i);
                        System.out.println("Edge Number: --- >"+i+" , Starting at : "+ e.u.data+" ,Ending at : "+e.w.data+",Is it BiDirectional? "+e.directed);
                }
                System.out.println("\n");
        }

}
