package com.university;

public class Utils {
	public static String capitalize(String str) {
		str = str.toLowerCase();

		// stores each characters to a char array
		char[] charArray = str.toCharArray();
		boolean foundSpace = true;

		for (int i = 0; i < charArray.length; i++) {

			// if the array element is a letter
			if (Character.isLetter(charArray[i])) {

				// check space is present before the letter
				if (foundSpace) {

					// change the letter into uppercase
					charArray[i] = Character.toUpperCase(charArray[i]);
					foundSpace = false;
				}
			} else {
				// if the new character is not character
				foundSpace = true;
			}
		}

		// convert the char array to the string
		str = String.valueOf(charArray);
		return str;
	}


}
