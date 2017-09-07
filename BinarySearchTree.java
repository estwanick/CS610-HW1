package com.company;

import java.util.*;

public class BinarySearchTree <T extends Comparable<T>> implements Iterable<T>{
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

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(T data : this) sb.append(data.toString());
        return sb.toString();
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
        if(compare(toInsert, p.data) == 0) return p;
        if(compare(toInsert, p.data) < 0)
            p.left = insert(p.left, toInsert);
        else
            p.right = insert(p.right, toInsert);
        return p;
    }

    /*****************************************************
     *
     *            TREE DESCRIPTORS
     *
     ******************************************************/

    public Node<T> getRoot() {
        System.out.println("Root: " + root);
        return root;
    }

    public int depth() {
        return depth(root);
    }

    private int depth(Node<T> p) {
        if(p == null) return 0;
        else return 1 + Math.max(depth(p.left), depth(p.right));
    }

    public int numLeaves() {
        return numLeaves(root);
    }

    public int numLeaves(Node<T> p) {
        if(p == null) {
            return 0;
        }
        if(p.left == null && p.right == null) {
            return 1;
        } else {
            return numLeaves(p.left) + numLeaves(p.right);
        }
    }

    public int numArcs() {
        return numArcs(root);
    }

    public int numArcs(Node<T> p) {
        if(p == null) {
            return 0;
        }
        if(p.left != null && p.right != null) {
            return 1 + numArcs(p.left) + numArcs(p.right);
        } else {
            return numArcs(p.left) + numArcs(p.right);
        }
    }

    public int numNodes() {
        return numNodes(root);
    }

    public int numNodes(Node<T> p) {
        if(p == null) {
            return 0;
        }
        return 1 + numNodes(p.left) + numNodes(p.right);
    }

    public int numInternalNodes() {
        return numInternalNodes(root);
    }

    public int numInternalNodes(Node<T> p) {
        if(p == null) {
            return 0;
        }
        if(p.left == null && p.right == null) {
            return 0;
        } else {
            return 1 + numInternalNodes(p.left) + numInternalNodes(p.right);
        }
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
            preOrderHelper(r.left);
            preOrderHelper(r.right);
        }
    }

    /*****************************************************
     *
     *            TREE ITERATOR
     *
     ******************************************************/

    public Iterator<T> iterator()
    {
        return new MyIterator();
    }
    //pre-order
    private class MyIterator implements Iterator<T>
    {
        Stack<Node<T>> stk = new Stack<Node<T>>();

        public MyIterator()
        {
            if(root != null) stk.push(root);
        }
        public boolean hasNext()
        {
            return !stk.isEmpty();
        }

        public T next()
        {
            Node<T> cur = stk.peek();
            if(cur.left != null)
            {
                stk.push(cur.left);
            }
            else
            {
                Node<T> tmp = stk.pop();
                while( tmp.right == null )
                {
                    if(stk.isEmpty()) return cur.data;
                    tmp = stk.pop();
                }
                stk.push(tmp.right);
            }

            return cur.data;
        }//end of next()

        public void remove()
        {

        }
    }

    private class Node<T> {
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

        public String toString() {
            return data.toString();
        }
    }
}

class objectComparator implements Comparator<Integer> {
    public int compare(Integer x, Integer y) {
        return y - x;
    }
}