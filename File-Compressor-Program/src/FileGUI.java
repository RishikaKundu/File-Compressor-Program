import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;
import java.awt.Color;
import java.util.*;

/**
 * The window and user interface for inputing the string and calculating and displaying the size and
 * codes of the compressed strings.
 */
public class FileGUI {
    private CanvasWindow canvas;
    private TextField inputText;
    private GraphicsText title;
    private Button addTextButton;
    private HuffmanTree huffmanTree;
    private GraphicsText stringSize;
    private GraphicsText instructionText;
    private GraphicsText compressedSize;
    private Huffman huffman;
    private GraphicsGroup codes;

    /**
     * Sets up the FileGUI and initialises the constructor.
     */

    public FileGUI() {
        canvas = new CanvasWindow("File Compressor Program", 900, 800);
        inputText = new TextField();
        title = new GraphicsText();
        instructionText = new GraphicsText();
        addTextButton = new Button("Compress Text");
        huffmanTree = new HuffmanTree();
        stringSize = new GraphicsText();
        compressedSize = new GraphicsText();
        huffman = new Huffman();
        setUpUI();
    }

    /**
     * Calculates the size of the original text in bytes.
     */

    public void calculateTextSize() {
        Integer textSize = getUserInput().length() * 2;
        stringSize.setText("Original String size: " + textSize.toString() + " Bytes");

    }

    /**
     * Calculates the size of the compressed text in bytes.
     */

    public void calculateCompressedSize(List<BitDepth> bdArray) {
        Integer sizeCompText = 0;
        for (BitDepth bitDepth : bdArray) {
            sizeCompText = bitDepth.getDepth() + sizeCompText;
        }
        sizeCompText = sizeCompText / 8;
        if (sizeCompText == 1) {
            compressedSize.setText("Compressed String Size: " + sizeCompText.toString() + " Byte");
        } else {
            compressedSize.setText("Compressed String Size: " + sizeCompText.toString() + " Bytes");
        }


    }

    /**
     * Create the user interface
     */
    public void setUpUI() {

        inputText.setPosition(120, 300);
        inputText.setBackground(Color.LIGHT_GRAY);

        title.setText("File Compressor Program");
        title.setFont(FontStyle.BOLD_ITALIC, 40);
        title.setPosition(200, 75);

        instructionText.setPosition(100, 250);
        instructionText.setText("Input the text you would like to compress: ");
        instructionText.setFont(FontStyle.BOLD, 15);


        stringSize.setPosition(100, 400);

        compressedSize.setPosition(100, 450);


        canvas.add(title);
        canvas.add(inputText);
        canvas.add(stringSize);
        canvas.add(instructionText);
        canvas.add(compressedSize);

        addTextButton.setPosition(230, 300);
        canvas.add(addTextButton);

        addTextButton.onClick(() -> calculateTextSize());
        addTextButton.onClick(() -> displayOutput());
    }


    /**
     * Displays the characters in the string and their respective huffman codes.
     */

    public void displayOutput() {
        List<BitDepth> finalList = huffman.encode(getUserInput());
        calculateCompressedSize(finalList);
        int y = 200;
        int x = 500;
        codes = new GraphicsGroup();
        for (BitDepth bitDepth : finalList) {
            GraphicsText letterCode = new GraphicsText();

            letterCode.setText(bitDepth.getLetter() + ": " + bitDepth.toString());
            if (y > 770) {
                y = 200;
                x = x + 100;
            }
            letterCode.setPosition(x, y);
            y = y + 30;
            codes.add(letterCode);
            canvas.add(letterCode);
        }
    }

    /**
     * Returns the text from the user input.
     */

    public String getUserInput() {
        return inputText.getText();

    }

    /**
     * Returns the huffman tree.
     */

    public HuffmanTree getHuffmanTree() {
        return huffmanTree;
    }

    public static void main(String[] args) {
        FileGUI window = new FileGUI();
    }

}
