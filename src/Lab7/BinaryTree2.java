package Lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;

/**
 * Class for a binary tree that stores type E objects.
 **/
public class BinaryTree2<E> implements Serializable {

    //Data Fields
    protected Node<E> root; /*The root of the binary tree */

    /** Construct an empty BinaryTree2 */
    public BinaryTree2() {
        root = null;
    }

    /**
     * Construct a BinaryTree2 with a specified root.
     * Should only be used by subclasses.
     * @param root The node that is the root of the tree.
     */
    protected BinaryTree2(Node<E> root) {
        this.root = root;
    }

    /** ------------------------------------------------------ Missing code 2
     * Constructs a new binary tree with data in its root,leftTree
     * as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree2(E data, BinaryTree2<E> leftTree, BinaryTree2<E> rightTree) {
        root = new Node<>(data);
        if(leftTree != null){
            root.left = leftTree.root;
        }else{
            root.left = null;
        }
        if(rightTree != null){
            root.right = rightTree.root;
        }else{
            root.right = null;
        }
    }

    /**------------------------------------------------------ Missing code 3
     * Return the left subtree.
     * @return The left subtree or null if either the root or
     * the left subtree is null
     */
    public BinaryTree2<E> getLeftSubtree() {
        if (root != null && root.left != null){
            return new BinaryTree2<>(root.left);
        }else{
            return new BinaryTree2<>(null);
        }
    }

    /**------------------------------------------------------ Missing code 4
     * Return the right sub-tree
     * @return the right sub-tree or null if either the root or the
     * right subtree is null.
     */
    public BinaryTree2<E> getRightSubtree() {
        if(root != null && root.right != null){
            return new BinaryTree2<>(root.right);
        }else{
            return new BinaryTree2<>(null);
        }
    }

    /**
     * Return the data field of the root
     * @return the data field of the root
     *         or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**------------------------------------------------------ Missing code 5
     * Determine whether this tree is a leaf.
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        return root == null || (root.left == null && root.right == null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform a preorder traversal.
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        sb.append("  ".repeat(Math.max(0, depth - 1)));
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node);
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /**
     * Method to read a binary tree.
     * @pre The input consists of a preorder traversal
     * of the binary tree. The line "null" indicates a null tree.
     * @param bR The input file
     * @return The binary tree
     * @throws IOException If there is an input error
     */
    public static BinaryTree2<String> readBinaryTree(BufferedReader bR) throws IOException {
        // Read a line and trim leading and trailing spaces.
        String data = bR.readLine().trim();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree2<String> leftTree = readBinaryTree(bR);
            BinaryTree2<String> rightTree = readBinaryTree(bR);
            return new BinaryTree2<>(data, leftTree, rightTree);
        }
    }

    /*<exercise Lab Assignment 6 - Programming exercise 2/
    /**
     * Method to return the preorder traversal of the binary tree
     * as a sequence of strings each separated by a space.
     * @return A preorder traversal as a string
     */
    public String preorderToString() {
        StringBuilder stb = new StringBuilder();
        preorderToString(stb, root);
        return stb.toString();
    }

    //Return preorder traversal of a binary tree as a sequence of strings each separated by a space.
    // Please consider using recursion.
    private void preorderToString(StringBuilder stb, Node<E> root) {
        //base case (if the root is empty
        if(root == null){
            return;
        }
        //Visits the root node
        stb.append(root.data);
        stb.append(" ");
        //traverse the left node of each subtree
        preorderToString(stb, root.left);
        //traverse the right node of each subtree
        preorderToString(stb, root.right);
    }

    /*<exercise Lab Assignment 6 - Programming exercise 3/
    /**
     * Method to return the postorder traversal of the binary tree
     * as a sequence of strings each separated by a space.
     * @return A postorder traversal as a string
     */
    public String postorderToString() {
        StringBuilder stb = new StringBuilder();
        postorderToString(stb, root);
        return stb.toString();
    }

    //Return the preorder traversal of a binary tree as a
    //sequence of strings each separated by a space. Please consider using recursion.
    private void postorderToString(StringBuilder stb, Node<E> root) {
        if (root == null) {
            return;
        }
        postorderToString(stb, root.left);
        postorderToString(stb, root.right);
        stb.append(root.data);
        stb.append("\n ");
    }

    /*<exercise Lab Assignment 6-Programming exercise 4/
    /**
     * A method to display the inorder traversal of a binary tree
     * placing a left parenthesis before each subtree and a right
     * parenthesis after each subtree. For example the expression
     * tree shown in the Figure would be represented as
     * (((x) + (y)) * ((a) / (b))).
     * @return An inorder string representation of the tree
     */
    public String inorderToString() {
        StringBuilder stb = new StringBuilder();
        inorderToString(stb, root);
        return stb.toString();
    }

    //Write a method to display the inorder traversal of a binary tree in the same form as Programming Exercise 2, except place a left parenthesis before each subtree and a right parenthesis after each subtree. Don’t display anything for an empty subtree
    //For example, the expression tree shown in the following Figure would be represented as
    //(((x) + (y)) * ((a) / (b))).
    private void inorderToString(StringBuilder stb, Node<E> root) {
        if (root == null) {
            return;
        }

        postorderToString(stb, root.left);
        stb.append(root.data);
        stb.append("\n");
        postorderToString(stb, root.right);
    }

    /** Class to encapsulate a tree node. */
    protected static class Node<E> implements Serializable{
        // Data Fields
        /** The information stored in this node. */
        public E data;
        /** Reference to the left child. */
        public Node<E> left;
        /** Reference to the right child. */
        public Node<E> right;

        // Constructors  ------------------------------------------------------ Missing code 1
        /**
         * Construct a node with given data and no children.
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods
        /**
         * Returns a string representation of the node.
         * @return A string representation of the data fields
         */
        @Override
        public String toString() {
            return data.toString();
        }
    }
}