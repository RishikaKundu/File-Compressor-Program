# File-Compressor-Program

Overview:

This project is designed to compress text files using the Huffman coding algorithm. Huffman coding is a popular method used to compress files. The program takes an input string, creates a tree according to each character and its frequency, compresses it using Huffman coding, and then displays the compressed size along with the Huffman codes for each character.

More Indepth Information on each class

FileGUI:

The FileGui class is responsible for interacting with the user. This class allows the user to input the string they need to compress. It also allows the user to see how much space they used before the algorithm and after. This file opens a window that displays the resulting Huffman codes for individual characters in the input string to the user. These codes are not only important for the user to see the process of the algorithm but also are essential for decoding the text back to its original form. The Huffman codes are displayed alongside their corresponding characters.

Huffman file The Huffman file is responsible for creating the main huffman code algorithms. It has a readfile method that reads the input string. Then it creates a frequency map, that maps the character and how frequent that character appears in the string. It also has a createQueue method that creates a priority queue. This queue is passed on to the constructTree method which takes the characters with the lowest frequency and combines them together making a parentnode. This parentnode is then added to the queue. This is repeatedly done until there is one node left. That node becomes the parent node. The encode method then generates Huffman code for each character depending on where it is in the tree.

BitDepth The BitDepth class is responsible for having the depth of each character in the Huffman tree and the Huffman code associated with that character.

HuffmanTree

The HuffmanTree class is used to traverse the tree made in Huffman. The traverseTree method does a preorder traversal on the tree. During the traversal, it calculates the Huffman code for each character, storing them in a HashMap named codeMap, alongside their depths in a HashMap named depthMap

Node
The node class represents a node object. It initializes character and frequency. It also has right, left and parentnode objects.In the class there is a method that compares the frequency of the characters as well as a toString method that turns the data into a string.

Running the code
To see how the algorithm works, all you need to do is run the code, then put your text into the inputText box. Wen you do that you would click Compress Text and your text should be compressed and displayed with the characters and the Huffman codes alongside it.
