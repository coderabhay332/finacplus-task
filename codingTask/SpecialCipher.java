/*
Write a special cipher that is a combination of Caesar’s cipher followed by a simple
RLE. The function should receive a string and the rotation number as parameters.
Input: special Cipher(“AABCCC”, 3) Output: D2EF3

*/


public class SpecialCipher {

    public static String specialCipher(String input, int shift) {
        if (input == null || input.isEmpty()) return "";

           StringBuilder caesar = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + shift) % 26 + base);
            }
            caesar.append(c);
        }


        StringBuilder rle = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= caesar.length(); i++) {
            if (i < caesar.length() && caesar.charAt(i) == caesar.charAt(i - 1)) {
                count++;
            } else {
                rle.append(caesar.charAt(i - 1));
                if (count > 1) rle.append(count);
                count = 1;
            }
        }

        return rle.toString();
    }

    public static void main(String[] args) {
        String output = specialCipher("", 26); 
        System.out.println(output); 
    }
}
