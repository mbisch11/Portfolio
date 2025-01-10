# Binary Search Tree Implementation

## Overview
This project implements a **Binary Search Tree (BST)** in Java, showcasing a robust and type-safe design using Java generics. The BST supports standard operations like insertion, deletion, search, and traversal, as well as advanced features such as partitioning.

## Features
- **Generic Design**: Supports any data type that implements the `Comparable` interface.
- **Recursive Operations**: 
  - Insertion
  - Deletion (with handling for leaf nodes, single-child nodes, and nodes with two children)
  - Search
- **Traversal**: In-order traversal to display sorted data.
- **Partitioning**: Retrieve elements based on a specified value.
- **Contains Check**: Efficiently verify if a value exists within the tree.

## Usage
1. **Initialize the BST**:
    ```java
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    ```
2. **Insert Elements**:
    ```java
    bst.insert(10);
    bst.insert(5);
    bst.insert(15);
    ```
3. **Search for an Element**:
    ```java
    boolean found = bst.contains(10); // Returns true if 10 exists
    ```
4. **Delete an Element**:
    ```java
    bst.delete(5);
    ```
5. **Traverse the Tree**:
    ```java
    System.out.println(bst.toString()); // Outputs elements in sorted order
    ```
6. **Partition the Tree**:
    ```java
    ArrayList<Integer> partitioned = bst.partition(10); // All values ≥ 10
    ```
