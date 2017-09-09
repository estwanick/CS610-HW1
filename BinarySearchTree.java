package com.company;

import java.util.*;

public class BinarySearchTree <T extends Comparable<T>>{
    private Node<T> root;
    private Comparator<T> comparator;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Comparator<T> comp)
    {
        root = null;
        comparator = comp;
    }

    private int compare(T x, T y) {
        if(comparator == null) return x.compareTo(y);
        else return comparator.compare(x,y);
    }

    /*****************************************************
     *
     *            INSERT
     *
     ******************************************************/
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> p, T toInsert) {
        if(p == null) return new Node<T>(toInsert);
        if(compare(toInsert, p.getData()) == 0) return p;
        if(compare(toInsert, p.getData()) < 0)
            p.setLeftChild(insert(p.getLeftChild(), toInsert));
        else
            p.setRightChild(insert(p.getRightChild(), toInsert));
        return p;
    }

    /*****************************************************
     *
     *            TREE DESCRIPTORS
     *
     ******************************************************/

    public Node<T> getRoot() {
        return root;
    }

    public int depth() {
        return depth(root);
    }

    private int depth(Node<T> p) {
        if(p == null) return 0;
        else return 1 + Math.max(depth(p.getLeftChild()), depth(p.getRightChild()));
    }

    public Node<T> search(T toSearch) {
        return search(root, toSearch);
    }

    public Node<T> search(Node<T> p, T toSearch) {
        if(p == null) {
            return null;
        } else if(compare(toSearch, p.getData()) == 0) {
            return p;
        } else if(compare(toSearch, p.getData()) < 0) {
            return search(p.getLeftChild(), toSearch);
        } else {
            return search(p.getRightChild(), toSearch);
        }
    }

    public int numLeaves() {
        return numLeaves(root);
    }

    public int numLeaves(Node<T> p) {
        if(p == null) {
            return 0;
        }
        if(p.getLeftChild() == null && p.getRightChild() == null) {
            return 1;
        } else {
            return numLeaves(p.getLeftChild()) + numLeaves(p.getRightChild());
        }
    }

    public int numArcs() {
        return numArcs(root);
    }

    public int numArcs(Node<T> p) {
        if(p == null) {
            return 0;
        }
        if(p.getLeftChild() != null && p.getRightChild() != null) {
            return 1 + numArcs(p.getLeftChild()) + numArcs(p.getRightChild());
        } else {
            return numArcs(p.getLeftChild()) + numArcs(p.getRightChild());
        }
    }

    public int numNodes() {
        return numNodes(root);
    }

    public int numNodes(Node<T> p) {
        if(p == null) {
            return 0;
        }
        return 1 + numNodes(p.getLeftChild()) + numNodes(p.getRightChild());
    }

    public int numInternalNodes() {
        return numInternalNodes(root);
    }

    public int numInternalNodes(Node<T> p) {
        if(p == null) {
            return 0;
        }
        if(p.getLeftChild() == null && p.getRightChild() == null) {
            return 0;
        } else {
            return 1 + numInternalNodes(p.getLeftChild()) + numInternalNodes(p.getRightChild());
        }
    }

    public Node<T> findParent(T p) {
        return findParent(p, root, null);
    }

    public Node<T> findParent(T p, Node<T> node, Node<T> parent)
    {
        if (node == null) {
            return null;
        } else if (compare(node.getData(), p) < 0) {
            parent = findParent(p, node.getLeftChild(), node);
            if (parent == null) {
                parent = findParent(p, node.getRightChild(), node);
            }
        }
        return parent;
    }

    /*************************************************
     *
     *            TRAVERSAL
     *
     **************************************************/

    public void preOrderTraversal() {
        preOrderHelper(root);
    }

    private void preOrderHelper(Node r) {
        if(r != null) {
            System.out.println(r);
            preOrderHelper(r.getLeftChild());
            preOrderHelper(r.getRightChild());
        }
    }
}

class Node<T> {
    private T data;
    private Node<T> left, right;

    public Node(T data, Node<T> ld, Node<T> rd) {
        left = ld;
        right = rd;
        this.data = data;
    }

    public Node(T data) {
        this(data, null, null);
    }

    public Node getLeftChild() {
        return left;
    }

    public void setLeftChild(Node<T> child) {
        left = child;
    }

    public Node getRightChild() {
        return right;
    }

    public void setRightChild(Node<T> child) {
        right = child;
    }

    public T getData() {
        return data;
    }

    public String toString() {
        return data.toString();
    }
}

class objectComparator implements Comparator<Integer> {
    public int compare(Integer x, Integer y) {
        return y - x;
    }
}