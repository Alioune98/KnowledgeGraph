package Lab7.IndexTree;

import Lab7.BinarySearchTree2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**An IndexTree class that each node has data fields to store a word,
 * The count of occurrences of that word in a document file, and the line
 * number for each occurrence.
 *
 * @author Alioune Diagne on 4/24/2022
 * @project IndexTree
 */
public class IndexTree {
    /**
     * Data fields
     */

    //A binary search tree that holds all the words contained in a file
    public final BinarySearchTree2<Word> index;

    /**Takes a file and parses it to find uniques words and stores it in
     * binary search tree
     *
     * @param fileName The file that this index will compile from
     */
    public IndexTree(String fileName) throws FileNotFoundException {
        index = new BinarySearchTree2<>(); //A new index
        Scanner scan = new Scanner(new File(fileName)); //A scanner with the file to index
        int lineNumber = 0; //Initialize the line number
        while(scan.hasNextLine()){
            lineNumber++;
            String token;
            while((token = scan.findInLine("[\\p{L}']+")) != null){
                token = token.toLowerCase().replaceAll("\\p{Punct}", "");
                addRecord(token, lineNumber);
            }
            scan.nextLine(); //Clear the scan buffer
        }
    }

    /**Adds a new record if the word does not already exist in
     * the binary search tree and updates the occurrence quantity
     * and location if the word already exists in the index.
     *
     * @param w The word to be added to the index
     * @param line The line number in the file in which the occurrence is located
     */
    public void addRecord(String w, int line){
        Word word = new Word(w, line);
        if(!index.contains(new Word(w, line))){
            index.add(new Word(w.toLowerCase(), line));
        }else{
            Word occurrence = index.find(word.getW());
            occurrence.addOccurrence(line);
        }
    }

    /**
     * Prints the index with one word per line showing the line number of
     * each word and the number of occurrences
     */
    public void printIndex(){
        System.out.println(index.inorderToString());
    }

    /**
     * Inner class Word is used to construct a new occurrence of a word and
     * adds it to the index.
     */
    static class Word implements Comparable<Word>{
        private final String w;
        private int count;
        private final ArrayList<Integer> lines;

        /**A constructor that takes a word and a line number as an input
         * and updates the index accordingly
         *
         * @param w The actual word to be added
         * @param line The line number in which it is located
         */
        public Word(String w, int line){
            this.w = w;
            lines = new ArrayList<>();
            lines.add(line);
            count = 1;
        }

        /**Adds a new occurrence for an existing word
         * @param line The line number in the file where the word is located
         */
        public void addOccurrence(int line){
            for(int i = 0; i < lines.size(); i++){
                if(lines.get(i) == line){
                    return;
                }
                lines.add(line);
            }
            count++;
        }

        /**Prints out a visual representation of the index
         * @return A string with each of the words in the index
         * using the format "w(count): (occurrences)
         */
        public String toString(){
            StringBuilder s = new StringBuilder(w + "(" + count + "): ");
            for (int i = 0; i < lines.size(); i++) {
                if(i == lines.size() - 1){
                    s.append(lines.get(i));
                }else{
                    s.append(lines.get(i)).append(", ");
                }
            }
            return s.toString();
        }

        /**Compares two word objects to see if they are the same or not
         *
         * @param otherWord the word that this word is being compared to
         * @return 1 if the word is greater than this word, 0 if they are the same
         * and -1 if the word is less than this word.
         */
        @Override
        public int compareTo(Word otherWord) {
           return this.w.compareTo(otherWord.w);
        }

        /** Returns a word
         * @return The string representation of the requested word
         */
        public Word getW() {
            return this;
        }
    }
}
