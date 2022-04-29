package Lab7.IndexTree.TestClasses;
import Lab7.BinarySearchTree2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author aliou on 4/25/2022
 * @project DSA
 */
class BinarySearchTree2Test {
    @Test
    void find() {
        BinarySearchTree2<String> bst = new BinarySearchTree2<>();
        bst.add("dog");
        bst.add("cat");
        bst.add("canine");
        bst.add("wolf");
        Assertions.assertEquals("dog",bst.find("dog"));
    }

    @Test
    void add() {
        BinarySearchTree2<String> bst = new BinarySearchTree2<>();
        bst.add("dog");
        bst.add("cat");
        bst.add("canine");
        bst.add("wolf");
        Assertions.assertTrue(bst.add("zebra"));
        System.out.println(bst);
    }

    @Test
    void delete() {
        BinarySearchTree2<String> bst = new BinarySearchTree2<>();
        bst.add("dog");
        bst.add("cat");
        bst.add("canine");
        bst.add("wolf");
        Assertions.assertEquals("wolf", bst.delete("wolf"));
        System.out.println(bst);
    }

    @Test
    void remove() {
        BinarySearchTree2<String> bst = new BinarySearchTree2<>();
        bst.add("dog");
        bst.add("cat");
        bst.add("canine");
        bst.add("wolf");
        Assertions.assertTrue(bst.remove("dog"));
        Assertions.assertFalse(bst.remove("bird"));
        System.out.println(bst);
    }

    @Test
    void contains() {
        BinarySearchTree2<String> bst = new BinarySearchTree2<>();
        bst.add("dog");
        bst.add("cat");
        bst.add("canine");
        bst.add("wolf");
        Assertions.assertTrue(bst.contains("dog"));
        Assertions.assertFalse(bst.contains("bird"));
    }

    @Test
    void deletePrime() {
        BinarySearchTree2<String> bst = new BinarySearchTree2<>();
        bst.add("dog");
        bst.add("cat");
        bst.add("canine");
        bst.add("wolf");
        Assertions.assertEquals("dog", bst.deletePrime("dog"));
    }
}