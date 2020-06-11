public class Unicode extends  Cipher{

    public Unicode (int key) {
        super(key);
    }

    public String encrypt (String text) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<text.length(); i++) {
            sb.append((char) (text.charAt(i) + getKey()));
        }
        return sb.toString();
    }

    public String decrypt (String text) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<text.length(); i++) {
            sb.append((char) (text.charAt(i) - getKey()));
        }
        return sb.toString();
    }
}
