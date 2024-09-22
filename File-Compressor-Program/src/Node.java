/**
 * This class represents the nodes of the tree. It keeps track of the character, frequency, and
 * left, right, and parent node. It implements comparable interfance to compare the frequencies of
 * the nodes.
 */

public class Node implements Comparable<Node> {


    /**
     * Character information stored in the node.
     */

    public Character data;
    /**
     * Frequency information stored in the node.
     */
    public int frequency;
    /**
     * Reference to the left and right child.
     */
    public Node left, right;
    /**
     * Reference to the parent.
     */
    public Node parent;

    public Node(Character data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        left = null;
        right = null;
        parent = null;
    }

    /**
     * Compares the frequency of the nodes.
     */

    public int compareTo(Node o) {
        if (this.frequency < o.frequency) {
            return -1;
        } else if (this.frequency > o.frequency) {
            return +1;
        } else {
            return 0;
        }

    }

    /**
     * Converts the data stored in the node to string.
     */


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (data != null) {

            return sb.append(data.toString() + frequency).toString();

        } else {

            return sb.append(frequency).toString();
        }
    }

}

