import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HuffmanTest {

    Huffman huffman;
    Huffman queueHuffman;


    public HuffmanTest() {

    }

    @BeforeEach
    public void makeTree() {
        queueHuffman = new Huffman();
        queueHuffman.encode("aaaaaabbbccccdddddee");
        queueHuffman.constructTree();
        HuffmanTree tree = queueHuffman.getTree();
        tree.callTraversal();


    }


    @Test
    public void testReadFile() {
        Map<Character, Integer> newMap = queueHuffman.readFile("aaaaaabbbccccdddddee");
        assertEquals(5, newMap.size());
        assertEquals(6, newMap.get('a'));
        assertEquals(3, newMap.get('b'));
        System.out.println(newMap.toString());
    }


    @Test
    public void testCreateQueue() {
        System.out.println(queueHuffman.minHeap);
        assertEquals(5, queueHuffman.minHeap.size());
        assertEquals(2, queueHuffman.minHeap.poll().frequency);
        assertEquals(3, queueHuffman.minHeap.poll().frequency);
        assertEquals(4, queueHuffman.minHeap.poll().frequency);
        assertEquals(5, queueHuffman.minHeap.poll().frequency);
        assertEquals(6, queueHuffman.minHeap.poll().frequency);
    }

    @Test
    public void printTreeTraversal() {
        huffman = new Huffman();
        huffman.constructTree();
        HuffmanTree tree = huffman.getTree();
        tree.callTraversal();
        System.out.println(tree.toString());
    }


    @Test

    public void testBitToString() {
        BitSet bitSet = new BitSet(3);
        bitSet.set(1);
        BitDepth bitDepth = new BitDepth(3, bitSet, 'a');

        BitSet bitSetNew = new BitSet(5);
        bitSetNew.set(1);
        bitSetNew.set(2);
        bitSetNew.set(4);
        System.out.println("-------");
        System.out.println(bitSetNew.size());
        BitDepth bitDepthNew = new BitDepth(5, bitSetNew, 'a');

        assertEquals("010", bitDepth.toString());
        assertEquals("01101", bitDepthNew.toString());

    }

    @Test

    public void encode() {
        List<BitDepth> bdArray = queueHuffman.encode("aaaaaabbbccccdddddee");
        assertEquals(20, bdArray.size());
        assertEquals(2, bdArray.get(0).getDepth());
        BitSet bitSet = new BitSet(2);
        bitSet.set(0);
        bitSet.set(1);
        assertEquals(bitSet, bdArray.get(0).getBitSet());

    }


}

