import java.util.ArrayList;

public class Cipher {
    // fields
    private String plainText;
    private String cText;
    private String cText2;
    private String key;
    private String keyAlpha;
    private int keyLength;
    private ArrayList<String> preSortArray;
    private ArrayList<String> postSortArray;

    // DVC
    public Cipher(){
        this.plainText = "test code";
        this.cText = "placeholder";
        this.key = "ENCRYPT";
        this.keyLength = 7;
    }

    // EVC
    public Cipher(String plainText, String cipherText, String key) {
        this.plainText = plainText;
        this.cText = cipherText;
        this.key = key;
        this.keyLength = key.length();
    }

    /**
     *
     * @return
     */
    private String Encrypt(){





        return cText;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getcText() {
        return cText;
    }

    public void setcText(String cText) {
        this.cText = cText;
    }

    public String getcText2() {
        return cText2;
    }

    public void setcText2(String cText2) {
        this.cText2 = cText2;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyAlpha() {
        return keyAlpha;
    }

    public void setKeyAlpha(String keyAlpha) {
        this.keyAlpha = keyAlpha;
    }

    public int getKeyLength() {
        return keyLength;
    }

    public void setKeyLength(int keyLength) {
        this.keyLength = keyLength;
    }

    public ArrayList<String> getPreSortArray() {
        return preSortArray;
    }

    public void setPreSortArray(ArrayList<String> preSortArray) {
        this.preSortArray = preSortArray;
    }

    public ArrayList<String> getPostSortArray() {
        return postSortArray;
    }

    public void setPostSortArray(ArrayList<String> postSortArray) {
        this.postSortArray = postSortArray;
    }
}
