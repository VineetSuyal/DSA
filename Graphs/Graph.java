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
        void display(){
            for(int vertex : adjList.keySet()){
                System.out.println(vertex + "->" + adjList.get(vertex));
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

        void SSP(int src){
            Map<Integer,Integer> dis = new HashMap<>();
            for(int v=1; v<=6; v++){
                dis.put(v,Integer.MAX_VALUE);
            }
            dis.put(src,0);
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            while(!q.isEmpty()){
                int front = q.poll();
                List<Integer> neighbourList = adjList.getOrDefault(front,new ArrayList<>());
                for(int val : neighbourList){
                    if(dis.get(val)==Integer.MAX_VALUE){
                        q.add(val);
                        int fd = dis.get(front);
                        int fnd = fd + 1;
                        dis.put(val,fnd);
                        System.out.println("Vertex " + val + " is at distance " + fnd + " from "+ src);
                    }
                }
            }
        }

        void dfs(int src){
            dfsHelper(src, new HashSet<>());
        }

        void dfsHelper(int src , Set<Integer> vis){
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            vis.add(src);

            System.out.print(src + " ");
            List<Integer> neighbourList = adjList.getOrDefault(src,new ArrayList<>());
            for(int val : neighbourList){
                if(!vis.contains(val)){
                    dfsHelper(val,vis);
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
        g.display();
        // g.bfs(2);
        // g.SSP(1);
        g.dfs(1);

    }
}