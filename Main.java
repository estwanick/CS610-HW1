package com.company;

public class Main {

    public static void main(String[] args) {

        Integer[] arr = {2,1,6,3,8,5};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(Integer n : arr) bst.insert(n);
        bst.preOrderTraversal();

        Node<Integer> rootNode = bst.getRoot();
        System.out.print("Root Node: ");
        System.out.println(rootNode);

        boolean isRoot = bst.isRoot(2);
        System.out.print("Is root?: " + 2 + " -> ");
        System.out.println(isRoot);

        boolean isInternal = bst.isInternalNode(8);
        System.out.print("Is internal?: " + 8 + " -> ");
        System.out.println(isInternal);

        boolean isExternal = bst.isExternalNode(8);
        System.out.print("Is External?: " + 8 + " -> ");
        System.out.println(isExternal);

        Node<Integer> searchNode = bst.search(6);
        System.out.print("Search for Node: " + 6 + " -> ");
        System.out.println(searchNode);

        Node<Integer> leftChild = bst.getLeftChild(6);
        System.out.print("Left child for Node: " + 6 + " -> ");
        System.out.println(leftChild);

        Node<Integer> rightChild = bst.getRightChild(6);
        System.out.print("Right child for Node: " + 6 + " -> ");
        System.out.println(rightChild);

        Node<Integer> parentNode = bst.findParent(6);
        System.out.print("Parent for Node: " + 6 + " -> ");
        System.out.println(parentNode);

        int depth = bst.depth();
        System.out.print("Depth: ");
        System.out.println(depth);

        int numLeaves = bst.numLeaves();
        System.out.print("Leaves/External Nodes: ");
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
