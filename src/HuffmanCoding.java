import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Main class Huffman Coding, which implements the Huffman Algorithm.
 */
public class HuffmanCoding {

    public static ArrayList<Node> listOfNodes = new ArrayList<>();

    /**
     * Function which encodes a string.
     * @param root - Node parameter.
     * @param str - String parameter.
     * @param huffmanCode - String> parameter.
     */
    public static void encode(Node root, String str,
                              Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }

        // In case we find a leaf node.

        if (isLeaf(root)) {
            huffmanCode.put(root.getCharacter(), str.length() > 0 ? str : "1");
        }

        encode(root.left, str + '0', huffmanCode);
        encode(root.right, str + '1', huffmanCode);
    }


    // Utility function to check if Huffman Tree contains only a single node.

    /**
     * Function that checks if a node is actually a leaf.
     * @param root - Node parameter.
     * @return Returns a boolean.
     */
    public static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }


    // Traverse the Huffman Tree and decode the encoded string

    /**
     * Function that decodes a string.
     * @param root - Node parameter.
     * @param index - Int parameter.
     * @param sb - StringBuilder parameter.
     * @return Returns the index.
     */
    public static int decode(Node root, int index, StringBuilder sb) {
        if (root == null) {
            return index;
        }

        // In case we find a leaf node.

        if (isLeaf(root)) {
            return index;
        }
        index++;
        root = (sb.charAt(index) == '0') ? root.left : root.right;
        index = decode(root, index, sb);
        return index;
    }


    // Builds Huffman Tree and decodes the given input text.

    /**
     * Function that builds the Huffman Tree.
     * @param text - String parameter.
     */
    public static void buildHuffmanTree(String text) {

        // Base case: the string is empty.

        if (text == null || text.length() == 0) {
            return;
        }

        // Count the frequency of appearance of each character
        // and store it in a map.

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // It creates a priority queue to store live nodes of the Huffman tree.
        // Notice that the highest priority item has the lowest frequency.

        PriorityQueue<Node> pq;
        pq = new PriorityQueue<>(Comparator.comparingInt(Node::getOccurrence));

        // Create a leaf node for each character and add it
        // to the priority queue.

        for (var entry : freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Do till there is more than one node in the queue.

        while (pq.size() != 1) {

            // Remove the two nodes of the highest priority
            // (the lowest frequency) from the queue.

            Node left = pq.poll();
            Node right = pq.poll();

            // Create a new internal node with these two nodes as children
            // and with a frequency equal to the sum of both nodes'
            // frequencies. Add the new node to the priority queue.

            assert left != null;
            assert right != null;
            int sum = left.getOccurrence() + right.getOccurrence();
            pq.add(new Node(left, right, sum));
        }


        // The node `root` stores pointer to the root of Huffman Tree.
        Node root = pq.peek();

        // Traverse the Huffman tree and store the Huffman codes in a map.

        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);

        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }

        if (isLeaf(root)) {

            // Special case: For input like a, aa, aaa, etc.

            char ch = root.getCharacter();
            while (ch-- > 0) {

            }
        } else {

            // Traverse the Huffman Tree again and this time,
            // decode the encoded string.

            int index = -1;
            while (index < sb.length() - 1) {
                index = decode(root, index, sb);
            }
        }

        String result = sb.toString();
        File file = new File("coded.txt");
        byte[] data = new BigInteger(result, 2).toByteArray();
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data);
            System.out.println("Successfully written data to the coded file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Main function.
     * @param args - String[] parameter.
     */
    public static void main(String[] args) {
        BufferedReader objReader = null;
        StringBuilder myText = new StringBuilder();
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader("readfile.txt"));
            while ((strCurrentLine = objReader.readLine()) != null) {
                myText.append(strCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        for (int i = 0; i < myText.length(); i++) {
            boolean characterExists = false;
            for (Node node : listOfNodes) {
                if (node.getCharacter() == myText.charAt(i)) {
                    characterExists = true;
                    break;
                }
            }
            if (characterExists) {
                continue;
            }
            int count = 1;
            for (int j = i + 1; j < myText.length(); j++) {
                if (myText.charAt(i) == myText.charAt(j))
                    count++;
            }
            Node newNode = new Node(myText.charAt(i), count);
            listOfNodes.add(newNode);
        }
        buildHuffmanTree(myText.toString());
    }
}