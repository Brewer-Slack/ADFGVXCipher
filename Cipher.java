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
    private ArrayList<String> adfgvxList;

    // DVC
    public Cipher(){
        this.pText = "SEEMEAT10";
        this.cText = "XAGXGXVVGXAGXVAFXGXXX";
        this.key = "ENCRYPT";
        this.keyAlpha = "CENPRTY";
        this.keyLength = 7;
        this.adfgvxList = new ArrayList<>();
        adfgvxList.add("A");
        adfgvxList.add("D");
        adfgvxList.add("F");
        adfgvxList.add("G");
        adfgvxList.add("V");
        adfgvxList.add("X");
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

    private ArrayList<Integer> letterToCoordinate(String letter){
        int i = matrixArray.indexOf(letter);

        int row = (i/6);
        int col = i - ((row) * 6);

        ArrayList<Integer> rowCol = new ArrayList<>();

        rowCol.add(row);
        rowCol.add(col);

        return rowCol;
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

    private String convertCoordToLetter(ArrayList<Integer> coords){
        int row = coords.get(0);
        int col = coords.get(1);
        int index = (6 * row) + col;
        String letter = matrixArray.get(index);
        return letter;
    }

    private ArrayList<String> convertCoordToADFGVX(ArrayList<Integer> coords){
        int row = coords.get(0);
        int col = coords.get(1);
        ArrayList<String> adfgvx = new ArrayList<>();
        adfgvx.add(adfgvxList.get(row));
        adfgvx.add(adfgvxList.get(col));
        return adfgvx;
    }

    private ArrayList<Integer> convertADFGVXToCoord(ArrayList<String> adfgvx){
        String row = adfgvx.get(0);
        String col = adfgvx.get(1);
        int rowIndex = adfgvxList.indexOf(row);
        int colIndex = adfgvxList.indexOf(col);
        ArrayList<Integer> coord = new ArrayList<>();
        coord.add(rowIndex);
        coord.add(colIndex);
        return coord;
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
