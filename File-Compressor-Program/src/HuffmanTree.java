import java.util.*;

/**
 * Class for a binary tree based on the huffman algorithm. This class is used to perform the
 * preorder traversal on a binary tree.
 **/
public class HuffmanTree {
    public Node root;
    private HashMap<Character, BitSet> codeMap;
    private HashMap<Character, Integer> depthMap;


    public HuffmanTree() {
        root = null;
        codeMap = new HashMap<>();
        depthMap = new HashMap<>();
    }

    /**
     * Perform a preorder traversal.
     * 
     * @param node  The local root
     * @param depth The depth
     * @param bit   The bitset to save the output huffman code
     */


    public void traverseTree(Node node, int depth, BitSet bit) {
        if (node != null) {
            System.err.println(node.data);
        }
        BitSet left = new BitSet();
        BitSet right = new BitSet();
        right = (BitSet) bit.clone();
        left = (BitSet) bit.clone();

        right.set(depth);

        if (node == null)
            return;

        if (node.data != null) {
            depthMap.put(node.data, depth);
            codeMap.put(node.data, bit);
        }

        traverseTree(node.left, depth + 1, left);
        traverseTree(node.right, depth + 1, right);


    }

    /**
     * Creates a new bitset and calls the traverse tree method.
     */
    public void callTraversal() {
        BitSet newSet = new BitSet();
        traverseTree(root, 0, newSet);
    }


    public HashMap<Character, BitSet> getCodeMap() {
        return codeMap;
    }

    public HashMap<Character, Integer> getDepthMap() {
        return depthMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);

        return sb.toString();
    }

    /**
     * Perform a preorder traversal. This method is used for printing the tree for testing.
     * 
     * @param node  The local root
     * @param depth The depth
     * @param sb    The string buffer to save the output
     */
    private void preOrderTraverse(
        Node node,
        int depth,
        StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }
}

