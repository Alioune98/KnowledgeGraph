package Lab7.IndexTree;
import java.io.FileNotFoundException;

/**
 * @author aliou on 4/27/2022
 * @project DSA
 */
public class IndexTreeTest {
    public static void main(String[] args) throws FileNotFoundException {
        IndexTree index = new IndexTree("src/Lab7/IndexTree/IndexTreeFile.txt");
        index.printIndex();
    }
}