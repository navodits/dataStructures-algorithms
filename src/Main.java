import AvlTrees.AVLTree;
import Graph.Graph;
import Heap.Heap;
import SortingAlgorithms.*;
import Trie.Trie;
import WeightedGraph.WeightedGraph;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        WeightedGraph tree = new WeightedGraph();
//
//        tree.addNode("A");
//        tree.addNode("B");
//        tree.addNode("C");
//
//        tree.addEdge("A", "B", 12);
//        tree.addEdge("B", "C", 4);
//        tree.addEdge("C", "A", 7);
//        //tree.removeEdge("N", "A");
//
//        var path = tree.getShortestPath("A", "B");
//        System.out.println(tree.hasCycle());
//        var t = tree.getMinSpanTree();
//        t.print();

        QuickSort sort = new QuickSort();

        int [] numbers =  {3, 5,2,1,9, 4,7, 2, 6};
        System.out.println(Arrays.toString(numbers));
        sort.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println("done");




    }
}
