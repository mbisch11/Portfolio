package edu.psu.ist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTests {

    @Test
    public void testInsert() {
        BinarySearchTree tree = new BinarySearchTree<>();
        tree.insert(100);
        tree.insert(50);
        tree.insert(150);
        tree.insert(101);
        tree.insert(141);

        assertEquals(100,tree.root.data);
        assertEquals(50,tree.root.left.data);
        assertEquals(150,tree.root.right.data);

        assertEquals("50 100 101 141 150 ", tree.toString()); //toString Test

        assertEquals(true,tree.contains(101)); //contains Test
        assertEquals(false,tree.contains(106));

        tree.insert(75);

        ArrayList partitionTest = new ArrayList();
        partitionTest.add(100); partitionTest.add(150); partitionTest.add(101); partitionTest.add(141); partitionTest.add(75);

        assertEquals(partitionTest,tree.partition(70));

        tree.delete(150);
        tree.delete(50);

        assertEquals("75 100 101 141 ", tree.toString());
    }
}
