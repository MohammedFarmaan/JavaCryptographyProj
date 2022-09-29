package caesarcipher;
import java.util.Scanner;

public class CaesarCipher {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String encoding(String pText, int key){
        pText = pText.toLowerCase();
        String cText = "";
        for(int i = 0; i<pText.length(); i++ ){
            int charIndex = alphabet.indexOf(pText.charAt(i));
            int newIndex = (charIndex + key) % 26;
            char cipherChar = alphabet.charAt(newIndex);
            cText = cText + cipherChar;
        }
        return cText;
    }

    public static String decoding(String cText, int key){
        cText = cText.toLowerCase();
        String pText = "";
        for(int i = 0; i<cText.length(); i++){
            int charIndex = alphabet.indexOf(cText.charAt(i));
            int newIndex = (charIndex - key) % 26;
            if (newIndex < 0){
                newIndex = alphabet.length() + newIndex;
            }
            char plainChar = alphabet.charAt(newIndex);
            pText = pText + plainChar;
        }
        return pText;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Plain Text >> ");
        String plain = scan.nextLine();

        System.out.print("Enter Key >> ");
        int key = scan.nextInt();

        String cipherText = encoding(plain, key);

        System.out.println("The Cipher Text: " + cipherText);

        System.out.println("The Decoded Message is: " + decoding(cipherText, key));
    }
}