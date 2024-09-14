# File Compressor Program

**Overview:**
  
This project is designed to compress text files using the Huffman coding algorithm. Huffman coding is a popular method used to compress files. The program takes an input string, creates a binary tree according to each character and its frequency, calculates Huffman codes for each character in the string, and then displays the compressed string size along with the Huffman codes for each character.

**Information on each class:**
  
- FileGUI:

The FileGui class is responsible for interacting with the user. This class allows the user to input the string they need to compress. It also allows the user to see how much space they used before the algorithm and after. This file opens a window that displays the resulting Huffman codes for individual characters in the input string to the user. These codes are not only important for the user to see the process of the algorithm but can also be used for decoding the text back to its original form. The Huffman codes are displayed alongside their corresponding characters.

- Huffman file
  
The Huffman file is responsible for creating the main huffman code algorithms. It has a readfile method that reads the input string. Then it creates a hash map, that maps the character and how frequent that character appears in the string. It also has a createQueue method that creates a priority queue implemented using a min heap. This queue is passed on to the constructTree method which takes the characters with the lowest frequency and combines them together making a parentnode. This parentnode is then added to the queue. This is repeatedly done until there is one node left. That node becomes the parent node. The encode method then generates Huffman code for each character depending on where it is in the tree.

- BitDepth
  
  The BitDepth class is responsible for having the depth of each character in the Huffman tree and the Huffman code associated with that character.

- HuffmanTree

The HuffmanTree class is used to traverse the tree made in Huffman. The traverseTree method does a preorder traversal on the tree. During the traversal, it calculates the Huffman code for each character, storing them in a HashMap named codeMap, alongside their depths in a HashMap named depthMap. It also has a method to perform pre order traversal for printing the tree for debugging purpose. 

- Node

The node class represents a node object. It initializes character and frequency. It also has right, left and parentnode objects. In the class there is a method that compares the frequency of the characters as well as a toString method that turns the data into a string.

- Huffman Test 

This class contains tests for methods in Huffman class and Huffman Tree class. 

**Running the code:**

To see how the algorithm works, the main method in the FileGUI class needs to be run. The user can input text into the inputText box in the user interface. Clicking the Compress Text button compresses the text and displays the original string size and compressed string size, along with the characters and their Huffman codes.

**Limitations of the program and future goals:**
  
This program only implements the Huffman algorithm for encoding the text using a string input, not an actual file. Future work needs to be done to implement the decoding method and to make the program take a file as an input over just a string. Furthermore, to re-run the string compression, the program needs to be run again. It does not automatically reset the program when a new string is typed in for compression. The user interface also shows every character in the string and its huffman code as many times as the character appears. There is thus redudency which needs to be minimised by displaying each character only once. 
Furthermore, after putting all the code together and calling all methods within the program, the huffman tests no longer pass. However, they were all individually called while building the program and passed all tests. 
