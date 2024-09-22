# File Compressor Program

**Overview:**
  
This project is designed to compress text files using the Huffman coding algorithm. Huffman coding is a popular method used to compress files. The program takes an input string, creates a binary tree according to each character and its frequency, calculates Huffman codes for each character in the string, and then displays the compressed string size along with the Huffman codes for each character.

**What I learnt:**

- Huffman Coding Basics: Learned how to implement Huffman coding for compressing text by building a binary tree based on character frequencies.

- Efficient Tree Traversal: Gained experience in tree traversal using preorder methods to generate and store Huffman codes and their depths.

- Priority Queues: Understood how to use min-heaps and priority queues to efficiently build Huffman trees by combining nodes with the lowest frequencies.

- User Interface Design: Developed a GUI to interact with users, displaying compression results and Huffman codes in a clear, visual format.

- Program Testing and Debugging: Encountered challenges in ensuring that integrated tests pass, highlighting the importance of testing throughout development.

**Class decomposition:**
  
- FileGUI:

Manages user interaction. Allows input of a string for compression and displays the original and compressed sizes. The window also shows Huffman codes for each character, which can be used for decoding.

- Huffman file
  
Implements the Huffman algorithm. The readFile method reads the input string and builds a frequency map. createQueue builds a priority queue using a min-heap, which is passed to constructTree, where nodes with the lowest frequency are combined until a single root node remains. The encode method generates Huffman codes for each character.

- BitDepth
  
Tracks the depth of each character in the Huffman tree and its associated code.

- HuffmanTree

Traverses the Huffman tree using traverseTree to calculate and store Huffman codes and their depths in hash maps. It also has a method for preorder traversal for debugging.

- Node

Represents a tree node with character and frequency values. Includes methods for comparing frequencies and converting data to strings.

- Huffman Test 

Contains test cases for methods in the Huffman and HuffmanTree classes.

**Running the code:**

To run the program, execute the FileGUI class. Enter text in the input box, and click "Compress Text" to see the original and compressed sizes along with Huffman codes.

**Limitations of the program and future goals:**
  
The program currently only encodes strings, not actual files, and lacks a decoding feature. It must be restarted to compress a new string. The user interface shows redundant character codes, which should be minimized. Finally, tests in the HuffmanTest class fail after integrating the code, though they worked individually.
