package encryption;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encryption.CryptographyGUI;

class CryptographyTest {

	private static final String CAESAR = "Caesar cipher";
    private static final String SCYTALE = "Scytale";
    private static final String COPY = "Copy";


	@Test
	void copyOneLowLetter() {
		/*
         * Purpose: Tests copying one lowercase letter
         * Method: copy
         * Initialization: None
         * Parameters: a lowercase letter
         * Correct result: the same lowercase letter
         */
		String myLetter = "a";
		assertEquals(myLetter, CryptographyGUI.copy("a"));
	}
	
	@Test
	void copyOneUpLetter() {
		/*
         * Purpose: Tests copying one uppercase letter
         * Method: copy
         * Initialization: None
         * Parameters: an uppercase letter
         * Correct result: the same uppercase letter
         */
		String myLetter = "B";
		assertEquals(myLetter, CryptographyGUI.copy("B"));
	}
	
	@Test
	void copyOneDigit() {
		/*
         * Purpose: Tests copying one digit
         * Method: copy
         * Initialization: None
         * Parameters: a digit
         * Correct result: the same digit
         */
		String myDigit = "1";
		assertEquals(myDigit, CryptographyGUI.copy("1"));
	}
	
	@Test
	void copyOneSign() {
		/*
         * Purpose: Tests copying one sign
         * Method: copy
         * Initialization: None
         * Parameters: a sign
         * Correct result: the same sign
         */
		String mySign = "&";
		assertEquals(mySign, CryptographyGUI.copy("&"));
	}
	
	@Test
	void copySpace() {
		/*
         * Purpose: Tests copying a space
         * Method: copy
         * Initialization: None
         * Parameters: a space
         * Correct result: the same space
         */
		String mySpace = " ";
		assertEquals(mySpace, CryptographyGUI.copy(" "));
	}
	
	@Test
	void copyNoting() {
		/*
         * Purpose: Tests copying an empty string
         * Method: copy
         * Initialization: None
         * Parameters: an empty string
         * Correct result: an empty string
         */
		String myNothing = "";
		assertEquals(myNothing, CryptographyGUI.copy(""));
	}
	
	@Test
	void copyLongText() {
		/*
         * Purpose: Tests copying a long text
         * Method: copy
         * Initialization: None
         * Parameters: a long text
         * Correct result: the same text
         */
		String myText = "Miusov, as a man man of breeding and deilcacy, could not but "
				+ "feel some inwrd qualms, when he reached the Father Superior's with Ivan: "
				+ "he felt ashamed of havin lost his temper. He felt that he ought to have "
				+ "disdaimed that despicable wretch, Fyodor Pavlovitch, too much to "
				+ "have been upset by him in Father Zossima's cell, and so to have "
				+ "forgotten himself. \"Teh monks were not to blame, in any case,\" he "
				+ "reflceted, on the steps. \"And if they're decent people here (and the "
				+ "Father Superior, I understand, is a nobleman) why not be friendly and "
				+ "courteous withthem? I won't argue, I'll fall in with everything, I'll"
				+ " win them by politness, and show them that I've nothing to do with that"
				+ " Aesop, thta buffoon, that Pierrot, and have merely been takken in over"
				+ " this affair, just as they have.\"\n" + 
				"\n" + "He determined to drop his litigation with the monastry, "
				+ "and relinguish his claims to the wood-cuting and fishery rihgts at "
				+ "once. He was the more ready to do this becuase the rights had becom "
				+ "much less valuable, and he had indeed the vaguest idea where the wood "
				+ "and river in quedtion were.\n" + 
				"";
		assertEquals(myText, CryptographyGUI.copy("Miusov, as a man man of breeding and deilcacy, could not but "
				+ "feel some inwrd qualms, when he reached the Father Superior's with Ivan: "
				+ "he felt ashamed of havin lost his temper. He felt that he ought to have "
				+ "disdaimed that despicable wretch, Fyodor Pavlovitch, too much to "
				+ "have been upset by him in Father Zossima's cell, and so to have "
				+ "forgotten himself. \"Teh monks were not to blame, in any case,\" he "
				+ "reflceted, on the steps. \"And if they're decent people here (and the "
				+ "Father Superior, I understand, is a nobleman) why not be friendly and "
				+ "courteous withthem? I won't argue, I'll fall in with everything, I'll"
				+ " win them by politness, and show them that I've nothing to do with that"
				+ " Aesop, thta buffoon, that Pierrot, and have merely been takken in over"
				+ " this affair, just as they have.\"\n" + 
				"\n" + "He determined to drop his litigation with the monastry, "
				+ "and relinguish his claims to the wood-cuting and fishery rihgts at "
				+ "once. He was the more ready to do this becuase the rights had becom "
				+ "much less valuable, and he had indeed the vaguest idea where the wood "
				+ "and river in quedtion were.\n" + 
				""));
	}
	
	@Test
	void copySpacesAndNums() {
		/*
         * Purpose: Tests copying a string of 
         * spaces and numbers
         * Method: copy
         * Initialization: None
         * Parameters: a string of spaces and 
         * numbers
         * Correct result: the same string
         */
		String mySpacesAndNums = "12   3 78899  ";
		assertEquals(mySpacesAndNums, CryptographyGUI.copy("12   3 78899  "));
	}
	
	@Test
	void copySignsAndNums() {
		/*
         * Purpose: Tests copying a string of 
         * signs and numbers
         * Method: copy
         * Initialization: None
         * Parameters: a string of signs and 
         * numbers
         * Correct result: the same string
         */
		String mySignsAndNums = "12&&3!!!78899,,";
		assertEquals(mySignsAndNums, CryptographyGUI.copy("12&&3!!!78899,,"));
	}
	
	@Test
	void copyEverything() {
		/*
         * Purpose: Tests copying a string of 
         * signs, spaces and numbers
         * Method: copy
         * Initialization: None
         * Parameters: a string of signs, spaces and 
         * numbers
         * Correct result: the same string
         */
		String myEverything = "12&&3!!a!78899,,   a";
		assertEquals(myEverything, CryptographyGUI.copy("12&&3!!a!78899,,   a"));
	}
	
	@Test
	void ceasarPlusOne() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key 1
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift ".", the key 1
         * Correct result: "/"
         */
		String myShiftedChar = "/";
		assertEquals(myShiftedChar, CryptographyGUI.ceasarCipher(".", 1));
	}
	
	@Test
	void ceasarMinusOne() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key -1
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift "/", the key 1
         * Correct result: "."
         */
		String myShiftedChar = ".";
		assertEquals(myShiftedChar, CryptographyGUI.ceasarCipher("/", -1));
	}
	
	@Test
	void ceasarPlusTwo() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key 2
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift ".", the key 2
         * Correct result: "0"
         */
		String myShiftedChar = "0";
		assertEquals(myShiftedChar, CryptographyGUI.ceasarCipher(".", 2));
	}
	
	@Test
	void ceasarMinusTwo() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key -2
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift "0", the key -2
         * Correct result: "."
         */
		String myShiftedChar = ".";
		assertEquals(myShiftedChar, CryptographyGUI.ceasarCipher("0", -2));
	}
	
	@Test
	void ceasarNothingPlusTwo() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key 2 on an empty string
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift "", the key 2
         * Correct result: ""
         */
		String myShiftedChar = "";
		assertEquals(myShiftedChar, CryptographyGUI.ceasarCipher("", 2));
	}
	
	@Test
	void ceasarNothingMinusTwo() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key -2 on an empty string
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift "", the key -2
         * Correct result: ""
         */
		String myShiftedChar = "";
		assertEquals(myShiftedChar, CryptographyGUI.ceasarCipher("", -2));
	}
	
	@Test
	void ceasarPlusNintyFour() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key 94
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift " ", the key 94
         * Correct result: "~"
         */
		String myShiftedChar = "~";
		assertEquals(myShiftedChar, CryptographyGUI.ceasarCipher(" ", 94));
	}
	
	@Test
	void ceasarMinusNintyFour() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key -94
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift "~", the key -94
         * Correct result: " "
         */
		String myShiftedChar = " ";
		assertEquals(myShiftedChar, CryptographyGUI.ceasarCipher("~", -94));
	}
	
	@Test
	void scytaleSixColumns() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key -94
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift "~", the key -94
         * Correct result: " "
         */
		String transposedMessage = "Adr  itathlhigmro ";
		assertEquals(transposedMessage, CryptographyGUI.scytaleCipher("A third algorithm", 6));
	}
	
	@Test
	void scytaleFiveColumns() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key -94
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift "~", the key -94
         * Correct result: " "
         */
		String transposedMessage = "Aiarm rli tdgt h oh";
		assertEquals(transposedMessage, CryptographyGUI.scytaleCipher("A third algorithm", 5));
	}
	
	@Test
	void scytaleFiftyColumns() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key -94
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift "~", the key -94
         * Correct result: " "
         */
		String transposedMessage = "A third algorithm";
		assertEquals(transposedMessage, CryptographyGUI.scytaleCipher("A third algorithm", 50));
	}
	
	@Test
	void scytaleOneColumn() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key -94
         * Method: ceasarCipher
         * Initialization: None
         * Parameters: The string to shift "~", the key -94
         * Correct result: " "
         */
		String transposedMessage = "A third algorithm";
		assertEquals(transposedMessage, CryptographyGUI.scytaleCipher("A third algorithm", 1));
	}
	
	@Test
	void scytaleNoColumns() {
		/*
         * Purpose: Tests the ceasar cipher 
         * with key -94
         * Method: copy
         * Initialization: None
         * Parameters: The string to shift "~", the key -94
         * Correct result: " "
         */
		String transposedMessage = "A third algorithm";
		assertEquals(transposedMessage, CryptographyGUI.scytaleCipher("A third algorithm", 0));
		
	}
	
	@Test
	void selectCopy() {
		/*
         * Purpose: Tests the select method works
         * when user selects copy 
         * Method: selectEncryption
         * Initialization: Final String COPY
         * Parameters: COPY
         * Correct result: choice = 1
         */
		CryptographyGUI.selectEncryption(COPY);
		int expectedChoice = 1;
		assertEquals(expectedChoice, CryptographyGUI.giveChoice());
	}
	
	@Test
	void selectCeasar() {
		/*
         * Purpose: Tests the select method works
         * when user selects ceasar  
         * Method: selectEncryption
         * Initialization: Final String CEASAR
         * Parameters: CEASAR
         * Correct result: choice = 2
         */
		CryptographyGUI.selectEncryption(CAESAR);
		int expectedChoice = 2;
		assertEquals(expectedChoice, CryptographyGUI.giveChoice());
	}
	
	@Test
	void selectScytale() {
		/*
         * Purpose: Tests the select method works
         * when user selects scytale
         * Method: selectEncryption
         * Initialization: Final String SCYTALE
         * Parameters: SCYTALE
         * Correct result: choice = 3
         */
		CryptographyGUI.selectEncryption(SCYTALE);
		int expectedChoice = 3;
		assertEquals(expectedChoice, CryptographyGUI.giveChoice());
	}
	
	@Test
	void encryptWithCeasarOne() {
		/*
         * Purpose: Tests the encryption works
         * when user selects ceasar with key 1
         * Method: encryptWithKey
         * Initialization: None
         * Parameters: string to shift "." , key 1
         * Correct result: "/"
         */
		CryptographyGUI.selectEncryption(CAESAR);
		String expectedString = "/";
		assertEquals(expectedString, CryptographyGUI.encryptWithKey(".", 1));
	}
	
	@Test
	void encryptWithCeasarTwo() {
		/*
         * Purpose: Tests the encryption works
         * when user selects ceasar with key 2
         * Method: encryptWithKey
         * Initialization: None
         * Parameters: string to shift "." , key 2
         * Correct result: 0
         */
		CryptographyGUI.selectEncryption(CAESAR);
		String expectedString = "0";
		assertEquals(expectedString, CryptographyGUI.encryptWithKey(".", 2));
	}
	
	@Test
	void decryptWithCeasarTwo() {
		/*
         * Purpose: Tests the decryption works
         * when user selects ceasar with key 2
         * Method: encryptWithKey
         * Initialization: None
         * Parameters: string to shift "0" , key 2
         * Correct result: "."
         */
		CryptographyGUI.selectEncryption(CAESAR);
		String expectedString = ".";
		assertEquals(expectedString, CryptographyGUI.decryptWithKey("0", 2));
	}
	
	@Test
	void encryptWithCeasarNintyFour() {
		/*
         * Purpose: Tests the encryption works
         * when user selects ceasar with key 94
         * Method: encryptWithKey
         * Initialization: None
         * Parameters: string to shift " " , key 94
         * Correct result: "~"
         */
		CryptographyGUI.selectEncryption(CAESAR);
		String expectedString = "~";
		assertEquals(expectedString, CryptographyGUI.encryptWithKey(" ", 94));
	}
	
	@Test
	void decryptWithCeasarNintyFour() {
		/*
         * Purpose: Tests the decryption works
         * when user selects ceasar with key 94
         * Method: encryptWithKey
         * Initialization: None
         * Parameters: string to shift "~" , key 94
         * Correct result: " "
         */
		CryptographyGUI.selectEncryption(CAESAR);
		String expectedString = " ";
		assertEquals(expectedString, CryptographyGUI.decryptWithKey("~", 94));
	}
	
	@Test
	void encryptWithScytaleSixColumns() {
		CryptographyGUI.selectEncryption(SCYTALE);
		String expectedString = "Adr  itathlhigmro";
		assertEquals(expectedString, CryptographyGUI.encryptWithKey("A third algorithm", 6));
	}
	
	@Test
	void decryptWithScytaleSixColumns() {
		CryptographyGUI.selectEncryption(SCYTALE);
		String expectedString = "A third algorithm ";
		assertEquals(expectedString, CryptographyGUI.decryptWithKey("Adr  itathlhigmro ", 6));
	}
	
	@Test
	void encryptWithScytaleFiveColumns() {
		CryptographyGUI.selectEncryption(SCYTALE);
		String expectedString = "Aiarm rli tdgt h oh";
		assertEquals(expectedString, CryptographyGUI.encryptWithKey("A third algorithm", 5));
	}
	
	@Test
	void decryptWithScytaleFiveColumns() {
		CryptographyGUI.selectEncryption(SCYTALE);
		String expectedString = "A third algorithm";
		assertEquals(expectedString, CryptographyGUI.decryptWithKey("Argh domt r haiilt", 5));
	}
	
	@Test
	void encryptWithScytaleFiftyColumns() {
		CryptographyGUI.selectEncryption(SCYTALE);
		String expectedString = "A third algorithm";
		assertEquals(expectedString, CryptographyGUI.encryptWithKey("A third algorithm", 50));
	}
	
	@Test
	void decryptWithScytaleFiftyColumns() {
		CryptographyGUI.selectEncryption(SCYTALE);
		Throwable exception = assertThrows(ArithmeticException.class, () -> 
		CryptographyGUI.decryptWithKey("A third algorithm", 50));
		assertEquals("/ by zero", exception.getMessage());
	}
	
	@Test
	void encryptWithScytaleOneColumn() {
		CryptographyGUI.selectEncryption(SCYTALE);
		String expectedString = "A third algorithm";
		assertEquals(expectedString, CryptographyGUI.encryptWithKey("A third algorithm", 1));
	}
	
	@Test
	void decryptWithScytaleOneColumn() {
		CryptographyGUI.selectEncryption(SCYTALE);
		String expectedString = "A third algorithm";
		assertEquals(expectedString, CryptographyGUI.decryptWithKey("A third algorithm", 1));
	}
	
	@Test
	void encryptWithScytaleNoColumns() {
		CryptographyGUI.selectEncryption(SCYTALE);
		Throwable exception = assertThrows(ArithmeticException.class, () -> 
		CryptographyGUI.encryptWithKey("A third algorithm", 0));
		assertEquals("/ by zero", exception.getMessage());
	}
	
	@Test
	void encryptWithCopy() {
		/*
         * Purpose: Tests the encryption works
         * when user selects copy with key 1393
         * Method: encryptWithKey
         * Initialization: None
         * Parameters: a text to copy, key 1393
         * Correct result: the same text
         */
		CryptographyGUI.selectEncryption(COPY);
		String expectedString = "Miusov, as a man man of breeding and deilcacy, could not but "
				+ "feel some inwrd qualms, when he reached the Father Superior's with Ivan: "
				+ "he felt ashamed of havin lost his temper. He felt that he ought to have "
				+ "disdaimed that despicable wretch, Fyodor Pavlovitch, too much to "
				+ "have been upset by him in Father Zossima's cell, and so to have "
				+ "forgotten himself. \"Teh monks were not to blame, in any case,\" he "
				+ "reflceted, on the steps. \"And if they're decent people here (and the "
				+ "Father Superior, I understand, is a nobleman) why not be friendly and "
				+ "courteous withthem? I won't argue, I'll fall in with everything, I'll"
				+ " win them by politness, and show them that I've nothing to do with that"
				+ " Aesop, thta buffoon, that Pierrot, and have merely been takken in over"
				+ " this affair, just as they have.\"\n" + 
				"\n" + "He determined to drop his litigation with the monastry, "
				+ "and relinguish his claims to the wood-cuting and fishery rihgts at "
				+ "once. He was the more ready to do this becuase the rights had becom "
				+ "much less valuable, and he had indeed the vaguest idea where the wood "
				+ "and river in quedtion were.\n" + 
				"";
		assertEquals(expectedString, CryptographyGUI.encryptWithKey("Miusov, as a man man of breeding and deilcacy, could not but "
				+ "feel some inwrd qualms, when he reached the Father Superior's with Ivan: "
				+ "he felt ashamed of havin lost his temper. He felt that he ought to have "
				+ "disdaimed that despicable wretch, Fyodor Pavlovitch, too much to "
				+ "have been upset by him in Father Zossima's cell, and so to have "
				+ "forgotten himself. \"Teh monks were not to blame, in any case,\" he "
				+ "reflceted, on the steps. \"And if they're decent people here (and the "
				+ "Father Superior, I understand, is a nobleman) why not be friendly and "
				+ "courteous withthem? I won't argue, I'll fall in with everything, I'll"
				+ " win them by politness, and show them that I've nothing to do with that"
				+ " Aesop, thta buffoon, that Pierrot, and have merely been takken in over"
				+ " this affair, just as they have.\"\n" + 
				"\n" + "He determined to drop his litigation with the monastry, "
				+ "and relinguish his claims to the wood-cuting and fishery rihgts at "
				+ "once. He was the more ready to do this becuase the rights had becom "
				+ "much less valuable, and he had indeed the vaguest idea where the wood "
				+ "and river in quedtion were.\n" + 
				"", 1393));
	}
	
	@Test
	void decryptWithCopy() {
		/*
         * Purpose: Tests the decryption works
         * when user selects copy with key 1393
         * Method: encryptWithKey
         * Initialization: None
         * Parameters: a text to copy, key 1393
         * Correct result: the same text
         */
		CryptographyGUI.selectEncryption(COPY);
		String expectedString = "Miusov, as a man man of breeding and deilcacy, could not but "
				+ "feel some inwrd qualms, when he reached the Father Superior's with Ivan: "
				+ "he felt ashamed of havin lost his temper. He felt that he ought to have "
				+ "disdaimed that despicable wretch, Fyodor Pavlovitch, too much to "
				+ "have been upset by him in Father Zossima's cell, and so to have "
				+ "forgotten himself. \"Teh monks were not to blame, in any case,\" he "
				+ "reflceted, on the steps. \"And if they're decent people here (and the "
				+ "Father Superior, I understand, is a nobleman) why not be friendly and "
				+ "courteous withthem? I won't argue, I'll fall in with everything, I'll"
				+ " win them by politness, and show them that I've nothing to do with that"
				+ " Aesop, thta buffoon, that Pierrot, and have merely been takken in over"
				+ " this affair, just as they have.\"\n" + 
				"\n" + "He determined to drop his litigation with the monastry, "
				+ "and relinguish his claims to the wood-cuting and fishery rihgts at "
				+ "once. He was the more ready to do this becuase the rights had becom "
				+ "much less valuable, and he had indeed the vaguest idea where the wood "
				+ "and river in quedtion were.\n" + 
				"";
		assertEquals(expectedString, CryptographyGUI.decryptWithKey("Miusov, as a man man of breeding and deilcacy, could not but "
				+ "feel some inwrd qualms, when he reached the Father Superior's with Ivan: "
				+ "he felt ashamed of havin lost his temper. He felt that he ought to have "
				+ "disdaimed that despicable wretch, Fyodor Pavlovitch, too much to "
				+ "have been upset by him in Father Zossima's cell, and so to have "
				+ "forgotten himself. \"Teh monks were not to blame, in any case,\" he "
				+ "reflceted, on the steps. \"And if they're decent people here (and the "
				+ "Father Superior, I understand, is a nobleman) why not be friendly and "
				+ "courteous withthem? I won't argue, I'll fall in with everything, I'll"
				+ " win them by politness, and show them that I've nothing to do with that"
				+ " Aesop, thta buffoon, that Pierrot, and have merely been takken in over"
				+ " this affair, just as they have.\"\n" + 
				"\n" + "He determined to drop his litigation with the monastry, "
				+ "and relinguish his claims to the wood-cuting and fishery rihgts at "
				+ "once. He was the more ready to do this becuase the rights had becom "
				+ "much less valuable, and he had indeed the vaguest idea where the wood "
				+ "and river in quedtion were.\n" + 
				"", 1393));
	}
	
	
}
