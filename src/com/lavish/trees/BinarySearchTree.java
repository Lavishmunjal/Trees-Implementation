package com.lavish.trees;

public class BinarySearchTree {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
    private Node root;
    public BinarySearchTree() {

    }
    public int height(Node node) {
        if(node ==null) {
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty() {
        return root==null;
    }
    public void display() {
        display(root, "Root node: ");
    }

    private void display(Node root, String details) {
        if(root==null) {
            return;
        }
        System.out.println(details+ root.getValue());
        display(root.left, "Left child of "+root.value+" : ");
        display(root.right, "right child of "+root.value+" : ");
    }
    public void insert(int value) {
        root = insert(value,root);
    }
    private Node insert(int value, Node node) {
        if(node==null) {
            node = new Node(value);
            return node;
        }
        if(value< node.value) {
            node.left = insert(value, node.left);

        }
        if(value> node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node root) {
        if(root==null) {
            return true;
        }
        return Math.abs(height(root.left)-height(root.right))<=1 && balanced(root.left)&& balanced(root.right);
    }
    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nums = {5,2,7,1,4,6,9,8,3,10};
        tree.populate(nums);
        tree.display();
    }
}

