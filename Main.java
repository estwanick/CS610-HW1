package com.company;

public class Main {

    public static void main(String[] args) {

        //Test 1
        System.out.println("Test 1---------------");
        Integer[] a = {2,6,3,8,5};
        describeBST(a, 2 ,6);

        System.out.println("Test 2---------------");
        //Test 2
        Integer[] b = {2};
        describeBST(b, 2, 2);

        System.out.println("Test 3---------------");
        //Test 3
        Integer[] c = {5,4,6,3,7,2,8,1,9};
        describeBST(c, 9, 9);

        System.out.println("Test 4---------------");
        //Test 4
        Integer[] d = {11,3,7,2,8,5,4,6,3,7,2,8,1,9};
        describeBST(d, 9, 9);

    }

    public static void describeBST(Integer[] arr, int sNode, int pNode){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(Integer n : arr) bst.insert(n);
        bst.preOrderTraversal();

        Node<Integer> rootNode = bst.getRoot();
        System.out.print("Root Node: ");
        System.out.println(rootNode);

        Node<Integer> searchNode = bst.search(sNode);
        System.out.print("Search for Node: ");
        System.out.println(searchNode);
        System.out.print("Left child for Node: ");
        System.out.println(searchNode.getLeftChild());
        System.out.print("Right child for Node: ");
        System.out.println(searchNode.getRightChild());

        Node<Integer> parentNode = bst.findParent(pNode);
        System.out.print("Parent for Node is: ");
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
