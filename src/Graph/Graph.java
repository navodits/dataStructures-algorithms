package Graph;


import java.util.*;

public class Graph {

    private class Node{
        String label;

        public Node(String label){
            this.label = label;
        }
    }


    Map<String, Node> nodes = new HashMap<>();
    Map<Node, List<Node>> adjList = new HashMap<>();

    public void addNode(String label){

        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to){
        List<Node> list = new ArrayList<>();
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null){
            throw new IllegalArgumentException();
        }
        if(adjList.get(fromNode) == null){
            list.add(toNode);
        }
        else{
            list = adjList.get(fromNode);
            list.add(toNode);
        }
            adjList.put(fromNode, list);

    }

    public Node remove(String label){
        if(!nodes.containsKey(label)){
            throw new IllegalArgumentException();
        }
        Node node = nodes.remove(label);

        for(Node n : adjList.keySet()){
            var list = adjList.get(n);
            list.remove(n);
            adjList.remove(n);

        }
        return node;
    }

    public void removeEdge(String from, String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null){
            throw new IllegalArgumentException();
        }

        var nodeList = adjList.get(fromNode);
        if(!nodeList.contains(toNode) || !nodes.containsKey(from)){
            throw new IllegalArgumentException();
        }
        nodeList.remove(toNode);
    }

    public void traverseDFS(String label){
        var node = nodes.get(label);
        if(node == null){
            return;
        }

        traverseDFS(node, new HashSet<>());
    }
    public void traverseBFS(String label){
        var node = nodes.get(label);
        if(node == null){
            return;
        }

        traverseBFS(node, new HashSet<>());
    }

    public void traverseDFS(Node root, Set<Node> visited){

        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        while(!nodes.empty()) {
            Node current = nodes.pop();
            if(!visited.contains(current)){
                visited.add(current);
                System.out.println(current.label);
            }
            var list = adjList.get(current);
            if(list == null) continue;
            for(Node neighbour : list){
                if(!visited.contains(neighbour)){
                    nodes.push(neighbour);

                }
            }
        }

    }

    public void traverseBFS(Node root, Set<Node> visited){

        Queue<Node> nodes = new ArrayDeque<>();

        nodes.add(root);
        while(!nodes.isEmpty()) {
            Node current = nodes.remove();
            if(!visited.contains(current)){
                visited.add(current);
                System.out.println(current.label);
            }
            var list = adjList.get(current);
            if(list == null) continue;
            for(Node neighbour : list){
                if(!visited.contains(neighbour)){
                    nodes.add(neighbour);

                }
            }
        }

    }

    public List topologicalSort(){
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        for(Node node : nodes.values()){

             topologicalSort(node, visited , stack);
        }
        List<String> list = new ArrayList<>();
        while(!stack.empty()){
            list.add(stack.pop().label);
        }

        return list;
    }

    private void topologicalSort(Node node, Set visited, Stack stack){
        if(visited.contains(node)) return;
        visited.add(node);
        var list = adjList.get(node);
        for (Node neighbour: list) {
            if(!visited.contains(neighbour)){
                topologicalSort(neighbour, visited, stack);
                stack.push(neighbour);
            }
        }
    }


    public boolean hasCycle(){
     Set<Node> all = new HashSet<>();
     Set<Node> visiting = new HashSet<>();
     Set<Node> visited = new HashSet<>();


     all.addAll(nodes.values());
     while (!all.isEmpty()){
         var node = all.iterator().next();
       if(hasCycle(node,all, visiting, visited)) return true;

     }
        return  false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited){

         all.remove(node);
         visiting.add(node);
         var list = adjList.get(node);
         if(list == null){
             visiting.remove(node);
             visited.add(node);
             return false;
         }
         for(Node neighbour : list){
            if(visited.contains(neighbour)) continue;

            if(visiting.contains(neighbour)) return true;

            if(hasCycle(neighbour, all,visiting,visited)) return true;

         }
            visiting.remove(node);
            visited.add(node);
         return false;
     }

}


