public class Encryption {
    private Cipher method;

    public void setMethod (Cipher c) {
        this.method = c;
    }

    public void encryptString (String s, String fileOut) {
        method.encryptString(s,fileOut);
    }

    public void decryptString (String s, String fileOut) {
        this.method.decryptString(s,fileOut);
    }

    public void encryptFromFile(String fileNameIn, String fileNameOut) {
        this.method.encryptFromFile(fileNameIn, fileNameOut);
    }

    public void decryptFromFile(String fileNameIn, String fileNameOut) {
        this.method.decryptFromFile(fileNameIn, fileNameOut);
    }
}
