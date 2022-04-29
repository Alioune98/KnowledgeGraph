package Lab7.IndexTree.TestClasses;

import Lab7.BinarySearchTree2;
import Lab7.BinaryTree2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author aliou on 4/25/2022
 * @project JUnit Test class for the BinaryTree2 class
 */
class BinaryTree2Test {

    @Test
    void getLeftSubtree() {
        BinarySearchTree2<String> bt = new BinarySearchTree2<>();
        bt.add("dog");
        bt.add("cat");
        bt.add("canine");
        bt.add("wolf");
        Assertions.assertEquals(bt.getLeftSubtree().getData(), "cat");
    }

    @Test
    void getRightSubtree() {
        BinarySearchTree2<String> bt = new BinarySearchTree2<>();
        bt.add("dog");
        bt.add("cat");
        bt.add("canine");
        bt.add("wolf");
        Assertions.assertEquals(bt.getRightSubtree().getData(),"wolf");
    }

    @Test
    void getData() {
        BinarySearchTree2<String> bt = new BinarySearchTree2<>();
        bt.add("dog");
        bt.add("cat");
        bt.add("canine");
        bt.add("wolf");
        Assertions.assertEquals(bt.getData(), "dog");
    }

    @Test
    void isLeaf() {
        BinarySearchTree2<String> bt = new BinarySearchTree2<>();
        bt.add("dog");
        bt.add("cat");
        bt.add("canine");
        bt.add("wolf");
        Assertions.assertTrue(bt.getRightSubtree().isLeaf());
        Assertions.assertFalse(bt.getLeftSubtree().isLeaf());
    }

    @Test
    void testToString() {
        BinarySearchTree2<String> bt = new BinarySearchTree2<>();
        bt.add("dog");
        bt.add("cat");
        bt.add("canine");
        bt.add("wolf");
        String s = "dog\n cat\n  canine\n   null\n   null\n  null\n wolf\n  null\n  null";
        Assertions.assertEquals(s, bt.toString());
    }

    @Test
    void readBinaryTree() throws IOException {
        BinarySearchTree2<String> bt = new BinarySearchTree2<>();
        bt.add("dog");
        bt.add("cat");
        bt.add("canine");
        bt.add("wolf");
        String s = "dog\n cat\n  canine\n   null\n   null\n  null\n wolf\n  null\n  null\n";
        Assertions.assertEquals(BinaryTree2.readBinaryTree(new BufferedReader(new StringReader(s))), bt);
    }

    @Test
    void preorderToString() {
        BinarySearchTree2<String> bt = new BinarySearchTree2<>();
        bt.add("dog");
        bt.add("cat");
        bt.add("canine");
        bt.add("wolf");
        Assertions.assertEquals("dog cat canine wolf", bt.preorderToString().trim());
    }

    @Test
    void postorderToString() {
        BinarySearchTree2<String> bt = new BinarySearchTree2<>();
        bt.add("dog");
        bt.add("cat");
        bt.add("canine");
        bt.add("wolf");
        Assertions.assertEquals("canine cat wolf dog", bt.postorderToString().trim());
    }

    @Test
    void inorderToString() {
        BinarySearchTree2<String> bt = new BinarySearchTree2<>();
        bt.add("dog");
        bt.add("cat");
        bt.add("canine");
        bt.add("wolf");
        Assertions.assertEquals("canine cat dog wolf", bt.inorderToString().trim());
    }
}