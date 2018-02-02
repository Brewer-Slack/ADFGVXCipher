import java.util.ArrayList;

public class Cipher {
    // fields
    private String pText;
    private String matrixText;
    private String kText;
    private String kaText;
    private String cText;
    private String cText2;
    private String key;
    private String keyAlpha;
    private int keyLength;
    private ArrayList<String> preSortArray;
    private ArrayList<String> postSortArray;
    private ArrayList<String> matrixArray;

    // DVC
    public Cipher(){
        this.pText = "SEEMEAT10";
        this.cText = "XAGXGXVVGXAGXVAFXGXXX";
        this.key = "ENCRYPT";
        this.keyAlpha = "CENPRTY";
        this.keyLength = 7;
    }

    // EVC
    public Cipher(String plainText, String cipherText, String key) {
        this.pText = plainText;
        this.cText = cipherText;
        this.key = key;
        this.keyLength = key.length();
    }

    /**
     *
     * @return
     */
    private String encrypt(){





        return cText;
    }

    private ArrayList<String> createMatix(){
        this.matrixArray = new ArrayList<>();

        matrixArray.add("F");
        matrixArray.add("L");
        matrixArray.add("1");
        matrixArray.add("A");
        matrixArray.add("0");
        matrixArray.add("2");

        matrixArray.add("J");
        matrixArray.add("D");
        matrixArray.add("W");
        matrixArray.add("3");
        matrixArray.add("G");
        matrixArray.add("U");

        matrixArray.add("C");
        matrixArray.add("I");
        matrixArray.add("Y");
        matrixArray.add("B");
        matrixArray.add("4");
        matrixArray.add("P");

        matrixArray.add("R");
        matrixArray.add("5");
        matrixArray.add("Q");
        matrixArray.add("8");
        matrixArray.add("V");
        matrixArray.add("E");

        matrixArray.add("6");
        matrixArray.add("K");
        matrixArray.add("7");
        matrixArray.add("Z");
        matrixArray.add("M");
        matrixArray.add("X");

        matrixArray.add("S");
        matrixArray.add("N");
        matrixArray.add("H");
        matrixArray.add("0");
        matrixArray.add("T");
        matrixArray.add("9");

        return matrixArray;
    }

    public String getPlainText() {
        return pText;
    }

    public void setPlainText(String plainText) {
        this.pText = plainText;
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
