import Lab7.BinarySearchTree2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author aliou on 4/29/2022
 * @project KnowledgeGraph
 */
public class CSVReader<E extends Comparable<E>> {
    private final String path;

    public CSVReader(String path){
        this.path = path;
    }

    public void read(BinarySearchTree2<E> tree){
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                int count = 0;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
