package encryption;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class provides a graphical user interface that allows a user to enter
 * text and select an encryption algorithm and key to encrypt the text. The user
 * can also enter encrypted text, select an algorithm and key to decrypt the
 * text.
 *
 */
public class CryptographyGUI extends JPanel {
    // Error message if the user does not enter a number for the key.
    private static final String KEY_ERROR_MESSAGE = 
            "Enter a number for the key.";

    // The width of the text areas for entering encrypted and decrypted text,
    // in characters
    private static final int TEXT_WIDTH = 50;

    // The number of rows in the text areas for entering encrypted and decrypted
    // text,
    // in characters
    private static final int TEXT_HEIGHT = 5;

    // The three kinds of encryption we know. These go in the menu.
    private static final String CAESAR = "Caesar cipher";
    
    private static final String SCYTALE = "Scytale";
    
    private static final String COPY = "Copy";
    
 // Variable to remember which encyption was selected
    private static int choice = 1;

    // Where the unencrypted text appears on the screen
    private JTextArea plainTextArea = new JTextArea(TEXT_HEIGHT, TEXT_WIDTH);

    // Where the encrypted text appears on the screen
    private JTextArea cipherTextArea = new JTextArea(TEXT_HEIGHT, TEXT_WIDTH);

    // The menu to select encryption algorithm.
    private JComboBox<String> encryptionMenu = new JComboBox<>();

    // The text field where the user enters the key to use
    private JTextField keyField = new JTextField(10);
    
    
    

    /**
     * Constructs the user interface for the program.
     */
    public CryptographyGUI() {
        // Create the two text areas for plain text and cipher text.
        plainTextArea.setBorder(BorderFactory.createTitledBorder("Plain text"));
        cipherTextArea
                .setBorder(BorderFactory.createTitledBorder("Cipher text"));
        
        // Create the menu containing encryption options
        createMenu();

        // Add the buttons and key field to control the encryption and
        // decryption.
        JPanel buttonPanel = new JPanel();
        JButton encryptButton = createEncryptButton();
        JButton decryptButton = createDecryptButton();
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        buttonPanel.add(encryptionMenu);
        buttonPanel.add(new JLabel("Key:"));
        buttonPanel.add(keyField);

        // Add all the GUI elements to the display.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(plainTextArea);
        add(cipherTextArea);
        add(buttonPanel);
    }

    /**
     * Creates the decrypt button.
     * @return the button
     */
    private JButton createDecryptButton() {
        JButton decryptButton = new JButton("Decrypt");
        decryptButton.addActionListener(new ActionListener() {
            // Define the action to take when the user clicks the decrypt
            // button.
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Get the key
                    String keyText = keyField.getText();
                    int key = Integer.parseInt(keyText);
                    
                    // Do the decryption.
                    String decryptedText = 
                            decryptWithKey(cipherTextArea.getText(), key);
                    
                    // Display the decrypted text.
                    plainTextArea.setText(decryptedText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(CryptographyGUI.this,
                            KEY_ERROR_MESSAGE);
                }
            }

        });
        return decryptButton;
    }

    /**
     * Creates the encrypt button.
     * @return the button
     */
    private JButton createEncryptButton() {
        JButton encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(new ActionListener() {
            // Define the action to take when the user clicks the encrypt
            // button.
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Get the key
                    String keyText = keyField.getText();
                    int key = Integer.parseInt(keyText);
                    
                    // Do the encryption
                    String encryptedText = 
                            encryptWithKey(plainTextArea.getText(), key);
                    
                    // Display the encrypted text
                    cipherTextArea.setText(encryptedText);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(CryptographyGUI.this,
                            KEY_ERROR_MESSAGE);
                }
            }
        });
        return encryptButton;
    }

    /**
     * Creates the menu containing the encryption algorithms to choose from.
     */
    private void createMenu() {
        encryptionMenu.addItem(COPY);
        encryptionMenu.addItem(CAESAR);
        encryptionMenu.addItem(SCYTALE);
        encryptionMenu.addItemListener(new ItemListener() {

            // Define the action to take when the user changes which 
            // algorithm to use.
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    String selected = 
                            encryptionMenu.getSelectedItem().toString();
                    selectEncryption(selected);
                }
            }
        });
    }
    
    /**
     * Copies the text passed in as an argument.
     * Method used for the "copy" encryption
     * @param toCopy the string to copy
     * @return toCopy the copied string
     */
    static String copy(String toCopy) {
    	   //the original string
        return toCopy;
    }

    /**
     * Shifts each letter a fixed amount
     * Method used for the "ceasar" encryption
     * @param toShift the string to encrypt
     * @return encrypted the encrypted string
     */
    static String ceasarCipher(String toShift, int key) {
    	//Creating an empty string to store the encrypted text
    	String encrypted = "";
    	   //Turning the string into an array of characters
        char [] charsArr = toShift.toCharArray();
        //Iterating through the characters
        for (char c : charsArr ) {
        	   //Shifting the character by the key
            c += key; 
            //Adding the corresponding chars to the ecrypted string
            encrypted += Character.toString(c);
        }
        
        return encrypted;
    }
    
    /**
     * Writing the letters in rows with a fixed number 
     * of columns,then printing out the columns
     * Method used for the "scytale" encryption
     * @param toTranspose the string to encrypt
     * @return encrypted the encrypted string
     */
    static String scytaleCipher(String toTranspose, int numColumns) {
            String encrypted = "";
            for (int i = 0; i < numColumns; i++)
            {
                for (int j = 0; i+j < toTranspose.length(); j += numColumns)
                {
                    encrypted += String.valueOf(toTranspose.charAt(i+j));
                }
            }
            return encrypted;
        
        }
    
    public static String decrypt(String text, int kth)
    {
        return scytaleCipher(text, kth);
    }
            
     /**
     * Selects the encryption algorithm to use
     * @param selected the name of the algorithm
     */
     static void selectEncryption(String selected) {
    	   //If the user selects copy choice becomes 1
        if (selected.equals(COPY)) {
            choice = 1;
        //If the user selects ceasar choice becomes 2
        } else if (selected.equals(CAESAR)) {
            choice = 2;
        //If the user selects scytale choice becomes 3
        } else if (selected.equals(SCYTALE)) {
            choice = 3;
        }
    }

    /**
     * Encrypts text using the currently selected algorithm
     * @param plainText the text to encrypt
     * @param key the key the algorithm should use
     * @return the encrypted text
     */
    static String encryptWithKey(String plainText, int key) {
    	//encryptedText will hold our encrypted message
    	String encryptedText = null;
        switch(choice) {
        //Copying the original text
        case 1 : 
        	encryptedText = copy(plainText);
        	break;
        //Using the ceasar cipher
        case 2 : 
        	encryptedText = ceasarCipher(plainText, key);
        	break;
        //Usinf the scytale cipher
        case 3 : 
        	encryptedText = scytaleCipher(plainText, key);
        	break;
		default:
			break;
        }
        return encryptedText;
    }
    
    /**
     * Decrypts text using the currently selected algorithm
     * @param cipherText the text to encrypt
     * @param key the key the algorithm should use
     * @return the decrypted text
     */
    static String decryptWithKey(String cipherText, int key) {
    	   //decryptedText will hold our decrypted message
        String decryptedText = null;
        switch(choice) {
        //Copying the decrypted text
        case 1 : 
            decryptedText = copy(cipherText);
            break;
        //Using the ceasar cipher with inverse key to shift back
        case 2 : 
            decryptedText = ceasarCipher(cipherText, -key);
            break;
        //Using scytale cipher with number of rows as key to put back in a row
        case 3 : 
            decryptedText = decrypt(cipherText, cipherText.length()/key);
            break;
		default:
			break;
        }

        return decryptedText;
    }
    
    /**
     * The main method to start the program.
     * 
     * @param args None required
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new CryptographyGUI());
        frame.pack();
        frame.setVisible(true);
    }
    
    static int giveChoice()
    {
    	return choice;
    }

}
