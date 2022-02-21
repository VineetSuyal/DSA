import java.util.*;
public class Main {
    static class Graph{
        HashMap<Integer,List<Integer>> adjList;
        Graph(){
            this.adjList = new HashMap<>();
        }
        void addEdge(int u, int v, boolean isBidir){
             List<Integer> l = adjList.getOrDefault(u,new ArrayList<>());
             l.add(v);
             adjList.put(u,l);

             if(isBidir){
                 List<Integer> li  = adjList.getOrDefault(v,new ArrayList<>());
                 li.add(u);
                 adjList.put(v,li);
             }
        }
       
        void bfs(int src){
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> vis = new HashSet<>();
            q.add(src);
            vis.add(src);

            while(!q.isEmpty()){
                int front = q.poll();
                System.out.print(front + " ");

                List<Integer> l = adjList.getOrDefault(front,new ArrayList<>());
                for(int val : l){
                    if(!vis.contains(val)){
                    q.add(val);
                    vis.add(val);
                    }
                }
            }
        }

    }

    public static void main(String args[]) {
        Graph g = new Graph();
        g.addEdge(1,2,true);
        g.addEdge(1,3,true);
        g.addEdge(2,4,true);
        g.addEdge(3,4,true);
        g.addEdge(3,5,true);
        g.addEdge(5,6,true);
        g.bfs(2);
        

    }
}