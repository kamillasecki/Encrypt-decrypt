public class Shift extends Cipher {

    public Shift(int key) {
        super(key);
    }

    @Override
    public String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                int alphLetter = ((letter - 'a' + getKey()) % 26) + 'a';
                sb.append((char) alphLetter);
            } else {
                sb.append(letter);
            }

        }
        return sb.toString();
    }

    @Override
    public String decrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                int alphLetter = ((letter - 'a' + 26 - (getKey() % 26)) % 26) + 'a';
                sb.append((char) alphLetter);
            } else {
                sb.append(letter);
            }

        }
        return sb.toString();
    }
}
