package com.company;

public class Main {

    public static void main(String[] args) {

        Integer[] a = {2,6,3,8,5};
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        for(Integer n : a) bst.insert(n);
        // bst.preOrderTraversal();

        bst.getRoot();

        int depth = bst.depth();
        System.out.print("Depth: ");
        System.out.println(depth);

        int numLeaves = bst.numLeaves();
        System.out.print("Leaves: ");
        System.out.println(numLeaves);

        int numArcs = bst.numArcs();
        System.out.print("Arcs: ");
        System.out.println(numArcs);

        int numNodes = bst.numNodes();
        System.out.print("Nodes: ");
        System.out.println(numNodes);

        int numInternalNodes = bst.numInternalNodes();
        System.out.print("Internal Nodes: ");
        System.out.println(numInternalNodes);
    }
}
