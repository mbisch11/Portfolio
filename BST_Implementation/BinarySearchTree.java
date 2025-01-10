package edu.psu.ist;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {

    public class Node {
        public T data;
        public Node left;
        public Node right;

        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    protected Node root;
    private boolean contained = false;
    private ArrayList partitioned = new ArrayList<T>();

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(T x){
        insert(root,x);
    }

    private Node insert(Node current, T x){
        if(root==null){
            root = new Node(x);
        }

        if(current == null){
            current = new Node(x);
            return current;
        }

        if(current.data.compareTo(x) == 1 ){
            current.left = this.insert(current.left, x);
        }else if(current.data.compareTo(x) == -1){
            current.right = this.insert(current.right, x);
        }

        return current;
    }

    public String toString(){
        return toString(this.root);
    }

    private String toString(Node current){
        StringBuilder stringBuilder = new StringBuilder();

        if(current != null){
            stringBuilder.append(this.toString(current.left));

            stringBuilder.append(current.data + " ");

            stringBuilder.append(this.toString(current.right));
        }

        return stringBuilder.toString();
    }

    public void delete(T x){
        //kick off method
        /*WITHIN RECURSIVE METHOD*
        *
        * find location of lead node that contains the data:
        * is it the root? (reset the root)
        *
        * is it a leaf node? (just delete it)
        *
        * only one child? (reassign parent pointer to child)
        *
        * does it have two children? go left and then all the way right (this is the smallest value in the larger subtree)
        * replace deleted node with node just found
        * */
        delete(root,x);
    }

    //always call this method with the right child of the node you want to delete
    private Node gimmeSmallest(Node current){ // helper method for deleting a non-only child and finding the leftmost child of the right child
        if(current.left == null){
            return current;
        }else{
            gimmeSmallest(current.left);
        }
        return null;
    }

    private Node delete(Node current, T x){
        if (current.right == null && current.left == null){
            throw new IllegalArgumentException("Data does not exist within tree");
        }

        Node tempR = null; //temporary storage node
        Node tempL = null; //temporary storage node as well

        if(root.data.equals(x)){ //root case
            if(root.left.right == null &&root.right != null){//checking if there's a right node that needs to be pointed to
                root.left.right = root.right;
                root = root.left;
                return null;
            }else if(root.right != null&& root.left != null){//if there's two children of the node
                tempR = root.right;
                tempL = root.left;
                root = gimmeSmallest(root.right);
                root.left = tempL;
                if(root.right != tempR){
                    root.right = tempR;
                }
                tempL = null; tempR = null;
                return null;
            }
        }

        //actual check
        if(current.right != null) {
            if (current.right.data.equals(x)) { // checking if the right node is to be deleted
                if (current.right.right == null && current.right.left == null) {//leaf case
                    current.right = null;
                    return null;
                } else if (current.right.left != null && current.right.right == (null)) {//one child node on the left
                    current.right = current.right.left;
                    return null;
                } else if (current.right.right != null && current.right.left == (null)) { //one child node on the right
                    current.right = current.right.right;
                    return null;
                } else { //two child nodes
                    //reassigning child pointers to new node
                    tempR = current.right.right;
                    tempL = current.right.left;
                    current.right = gimmeSmallest(current.right.right);
                    current.right.left = tempL;
                    if (current.right != tempR) {
                        current.right.right = tempR;
                    }
                    tempR = null;
                    tempL = null;
                    return null;
                }
            }
        }
        if(current.left != null){
            if (current.left.data.equals(x)) { //checking if the left node is to be deleted
                if (current.left.right == null && current.left.left == null) {//leaf case
                    current.left = null;
                    return null;
                } else if (current.left.left != null && current.left.right == null) {//one child node on the left
                    current.left = current.left.left;
                    return null;
                } else if (current.left.right != null && current.left.left == null) { //one child node on the right
                    current.left = current.left.right;
                    return null;
                } else { //two child nodes
                    //reassigning child pointers to new node
                    tempR = current.left.right;
                    tempL = current.left.left;
                    current.left = gimmeSmallest(current.left.right);
                    current.left.left = tempL;
                    if (current.left != tempR) {
                        current.left.right = tempR;
                    }
                    tempR = null;
                    tempL = null;
                    return null;
                }
            }
        }

        //recursively calling the function if x != current
        if(x.compareTo(current.data)==1){
            delete(current.right,x);
        } else if (x.compareTo(current.data)==-1) {
            delete(current.left,x);
        }
        return null;
    }

    public boolean contains(T x){
        return contains(x,root);
    }

    private boolean contains(T x, Node current){
        if(current.left == null&&current.right == null){
            contained = false;
        }

        if (x.equals(current.data)){
            contained = true;
        } else if(x.compareTo(current.data)==1 && current.right != null){
            contains(x,current.right);
        } else if (x.compareTo(current.data)==-1 && current.left != null) {
            contains(x,current.left);
        }
        return contained;
    }

    public ArrayList<T> partition(T data){
        return partition(data, root);
    }

    private ArrayList<T> partition(T x, Node current){
        if(current.data.compareTo(x) >= 0){
            partitioned.add(current.data);
        }
        if(current.right != null){
            partition(x,current.right);
        }
        if(current.left != null){
            partition(x,current.left);
        }
        return partitioned;
    }

}
