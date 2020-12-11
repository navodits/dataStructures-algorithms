package WeightedGraph;

import Graph.Graph;

import java.util.*;

public class WeightedGraph {

    public class Node{
        String value;
        List<Edge> edges = new ArrayList<>();
        public Node(String value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void addEdge(Node to, int weight){
            edges.add(new Edge(this, to, weight));
        }


    }

    private class NodeEntry{
        Node node;
        int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public class Edge {
        Node from, to;
        int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->"  + to 
                    ;
        }
    }

    Map<String, Node> nodes = new HashMap<>();

    public void addNode(String value){
        Node node = new Node(value);
        nodes.putIfAbsent(value, node);


    }

    public void addEdge(String from, String to, int weight){
        Node fromNode = nodes.get(from);

        Node toNode = nodes.get(to);
        fromNode.addEdge(toNode , weight);
        toNode.addEdge(fromNode, weight);
    }



    public Path getShortestPath(String from, String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );
        Set<Node> visited = new HashSet<>();

        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();

        for(Node node : nodes.values()) {
            distances.put(node, Integer.MAX_VALUE);

            distances.replace(fromNode, 0);
        }
        queue.add(new NodeEntry(fromNode, 0));
        while (!queue.isEmpty()){
            var current = queue.remove().node;
            visited.add(current);
            for (Edge edge : current.getEdges()){
                if(visited.contains(edge.to))continue;
                var newDistance = distances.get(current) + edge.weight;

                if(newDistance < distances.get(edge.to)){
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        Stack<Node> stack = new Stack<>();

        stack.add(toNode);
        var previous = previousNodes.get(toNode);
        while (previous != null){
            stack.add(previous);
            previous = previousNodes.get(previous);
        }
        Path path = new Path();
        while (!stack.isEmpty()){
            path.add(stack.pop().value);
        }
        return path;
    }



    public boolean hasCycle(){
        Set<Node> visited = new HashSet<>();


        for (Node node : nodes.values()){


          if (hasCycle(node,null, visited) && !visited.contains(node)) {
              return true;
          }
        }
        return false;

    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited){


        visited.add(node);
        for (Edge edge :node.edges){
            if(edge.to == parent ) continue;
            if(visited.contains(edge.to) || hasCycle(edge.to,node, visited )){

                return true;
            }
        }
        return false;
    }

    public WeightedGraph getMinSpanTree(){
        WeightedGraph minSpanTree = new WeightedGraph();

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

       var node = nodes.values().iterator().next();

       queue.addAll(node.getEdges());
       while (minSpanTree.nodes.size() != this.nodes.size()){
          var minEdge = queue.remove();
          var from = node.value;
          var to = minEdge.to.value;

          if(minSpanTree.containsNode(to)) continue;

           minSpanTree.addNode(from);
           minSpanTree.addNode(to);
           minSpanTree.addEdge(from, to, minEdge.weight);
           for (Edge edge : minEdge.to.getEdges()){
               if(!queue.contains(edge))
                queue.add(edge);
           }
       }

        return minSpanTree;
    }

    public boolean containsNode(String label){
        return nodes.containsKey(label);
    }



    public void print(){
        for(var node : nodes.values()){
            var target = node.getEdges();
            if(!target.isEmpty()){
                System.out.println(node + " is connected to " + target);
            }
        }
    }

}

