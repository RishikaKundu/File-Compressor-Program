import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.util.PriorityQueue;

/**
 * Implememnts the steps of the Huffman coding algorithm
 */
public class Huffman {

    PriorityQueue<Node> minHeap;
    HuffmanTree tree;

    public HuffmanTree getTree() {
        return tree;
    }

    public Huffman() {
        minHeap = new PriorityQueue<>();
        tree = new HuffmanTree();
    }

    /**
     * Reads user input and counts the frequency of each character.
     * 
     * @param stringInput
     * @return map of character and corresponding frequency
     */
    public Map<Character, Integer> readFile(String stringInput) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        char[] charInput = stringInput.toCharArray();
        for (char eachChar : charInput) {
            if (frequencyMap.get(eachChar) != null) {
                Integer freq = frequencyMap.get(eachChar);
                freq = freq + 1;
                frequencyMap.put(eachChar, freq);
            } else {
                frequencyMap.put(eachChar, 1);
            }
        }
        return frequencyMap;
    }


    /**
     * Creates ordered queue of nodes from character/frequency map
     * 
     * @param inputMap
     * @return PriorityQueue of nodes
     */
    public PriorityQueue<Node> createQueue(Map<Character, Integer> inputMap) {
        for (Map.Entry<Character, Integer> entry : inputMap.entrySet()) {
            Node newNode = new Node(entry.getKey(), entry.getValue());
            minHeap.add(newNode);
        }
        return minHeap;
    }

    /**
     * Builds binary tree from priority queue
     */
    public void constructTree() {
        while (minHeap.size() > 1) {
            Node firstLeaf = minHeap.poll();
            Node secondleaf = minHeap.poll();
            int newFrequency = firstLeaf.frequency + secondleaf.frequency;
            Node parentNode = new Node(null, newFrequency);
            tree.root = parentNode;
            parentNode.left = firstLeaf;
            parentNode.right = secondleaf;
            minHeap.add(parentNode);
        }
    }

    /**
     * Iterates over user input and creates new BitDepth object to store each character and its code
     * 
     * @param input
     * @return list of BitDepth objects in order of original text
     */
    public List<BitDepth> encode(String input) {
        Map<Character, Integer> frequencMap = readFile(input);
        minHeap = createQueue(frequencMap);
        constructTree();
        tree.callTraversal();

        List<BitDepth> bdArray = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            BitSet bitSet = tree.getCodeMap().get(ch);
            Integer depth = tree.getDepthMap().get(ch);
            BitDepth bitDepth = new BitDepth(depth, bitSet, ch);
            bdArray.add(bitDepth);
        }
        return bdArray;
    }


}

