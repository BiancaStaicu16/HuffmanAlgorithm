import java.util.Comparator;

/**
 * Class Node that has a character, an occurrence, a left and a right node and the sum of those two.
 */
public class Node implements Comparator<Node> {

    private char character;

    private int occurrence;

    int sumOfLeftAndRight;

    Node left;

    Node right;

    /**
     * Constructor method.
     * @param newLeft - Node parameter.
     * @param newRight - Node parameter.
     * @param newSum - Int parameter.
     */
    public Node(Node newLeft, Node newRight, int newSum){
        this.left = newLeft;
        this.right = newRight;
        this.sumOfLeftAndRight = newSum;
    }

    /**
     * Compare function.
     * @param x - Node parameter.
     * @param y - Node parameter.
     * @return Returns the difference between their occurrences.
     */
    public int compare(Node x, Node y) {
        return x.occurrence - y.occurrence;
    }

    /**
     * Constructor method.
     * @param newCharacter - Char parameter.
     * @param newOccurrence - Int parameter.
     */
    public Node(char newCharacter, int newOccurrence){
        this.character = newCharacter;
        this.occurrence = newOccurrence;
    }

    public char getCharacter(){
        return this.character;
    }

    public int getOccurrence() {
        return this.occurrence;
    }
}