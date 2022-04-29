import Lab7.BinarySearchTree2;

/**
 * @author aliou on 4/29/2022
 * @project KnowledgeGraph
 */
public class KnowledgeGraph {
    private final BinarySearchTree2<Entity1> tree;
    private CSVReader<Entity1> reader;
    private String path;


    public KnowledgeGraph(String path){
        tree = new BinarySearchTree2<>();
        this.path = path;
        reader = new CSVReader<Entity1>(path);
        reader.read(tree);
    }
}
