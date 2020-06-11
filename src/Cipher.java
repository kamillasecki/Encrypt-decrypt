import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

abstract public class Cipher {
    private int key;

    public Cipher (int key) {
        this.key = key;
    }

    abstract public String encrypt (String text);

    abstract public String decrypt (String text);

    public void encryptString (String s, String fileOut) {
        if(fileOut.equals("")){
            System.out.println(encrypt(s));
        } else {
            try (PrintWriter printWriter = new PrintWriter(fileOut)) {
                printWriter.println(encrypt(s));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void decryptString (String s, String fileOut) {
            if(fileOut.equals("")){
                System.out.println(decrypt(s));
            } else {
                try (PrintWriter printWriter = new PrintWriter(fileOut)) {
                    printWriter.println(decrypt(s));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
    }

    public void encryptFromFile(String fileNameIn, String fileNameOut) {
        File fileIn = new File(fileNameIn);
        File fileOut = new File(fileNameOut);

        try (Scanner sc = new Scanner(fileIn)) {
            while (sc.hasNext()) {
                if(fileOut.equals("")){
                    System.out.println(encrypt(sc.nextLine()));
                } else {
                    try (PrintWriter printWriter = new PrintWriter(fileOut)) {
                        printWriter.println(encrypt(sc.nextLine()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void decryptFromFile(String fileNameIn, String fileNameOut) {
        File fileIn = new File(fileNameIn);
        File fileOut = new File(fileNameOut);

        try (Scanner sc = new Scanner(fileIn)) {
            while (sc.hasNext()) {
                if(fileOut.equals("")){
                    System.out.println(decrypt(sc.nextLine()));
                } else {
                    try (PrintWriter printWriter = new PrintWriter(fileOut)) {
                        printWriter.println(decrypt(sc.nextLine()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getKey () {
        return key;
    }
}
