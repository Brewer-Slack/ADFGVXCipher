import java.util.ArrayList;
import java.util.Collections;

public class Cipher {
    // fields
    private String pText;
    private String matrixText;
    private String cipherText;
    private String cText2;
    private String key;
    private String keyAlpha;
    private int keyLength;

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    private int numRows;
    private ArrayList<String> preSortArray;
    private ArrayList<String> postSortArray;
    private ArrayList<String> matrixArray;
    private ArrayList<String> adfgvxList;
    private ArrayList<Integer> decode;

    // DVC
    public Cipher(){
        this.pText = "SEEMEAT10";
        this.cipherText = "XAGXGXVVGXAGXVAFXGXXX";
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
        this.decode = new ArrayList<>();
    }

    // EVC
    public Cipher(String plainText, String cipherText, String key) {
        this.pText = plainText;
        this.cipherText = cipherText;
        this.key = key;
        this.keyLength = key.length();
    }

    /**
     *
     * @return
     */
    public String encrypt(String plainText, String key){
        setPlainText(plainText);
        setKeyLength(key.length());
        createMatix();

        ArrayList<String> splitPlain = new ArrayList<>();
        ArrayList<ArrayList<Integer>> coordinatesList= new ArrayList<>();
        for(int i = 0; i < plainText.length(); i++) {
            splitPlain.add(String.valueOf(plainText.charAt(i)));
            coordinatesList.add(convertLetterToCoordinate(splitPlain.get(i)));
        }

        ArrayList<ArrayList<String>> listOfLetterCoordinates = new ArrayList<>();
        for(int i = 0; i < coordinatesList.size(); i++){
            listOfLetterCoordinates.add(convertCoordToADFGVX(coordinatesList.get(i)));
        }

        String letterCoordinatesListText = concatenateADFGVXStrings(listOfLetterCoordinates);
        String matrixText = generateMatrixTextFromString(letterCoordinatesListText);
        String alphabetizedMatrixText = alphabetizeMatrixText(matrixText);
        String cipherText = generateCipherText(alphabetizedMatrixText);
        System.out.println(cipherText);

        return cipherText;
    }

    public String decrypt(String cipherText, String key){
        setCipherText(cipherText);
        setKey(key);
        createMatix();

        String alphabetizedMatrixText = dropXsFromCipherText(cipherText);
        String matrixText = undoAlphabetized(alphabetizedMatrixText);
        String coordinatesListText = dropXsFromConcatenatedADFGVXString(matrixText);
        ArrayList<ArrayList<String>> listOfLetterCoordinates = undoConcatenate(coordinatesListText);

        ArrayList<ArrayList<Integer>> listOfCoordinates = new ArrayList<>();
        for(int i = 0; i < listOfLetterCoordinates.size(); i++){
            listOfCoordinates.add(convertADFGVXToCoord(listOfLetterCoordinates.get(i)));
        }

        ArrayList<String> splitPlain = new ArrayList<>();
        String plainText = "";
        for (int i = 0; i < listOfCoordinates.size(); i++){
            splitPlain.add(convertCoordinateToLetter(listOfCoordinates.get(i)));
            plainText += splitPlain.get(i);
        }


        return plainText;
    }

    private void createMatix(){
        this.matrixArray = new ArrayList<>();

        matrixArray.add("F");
        matrixArray.add("L");
        matrixArray.add("1");
        matrixArray.add("A");
        matrixArray.add("O");
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
    }

    private ArrayList<Integer> convertLetterToCoordinate(String letter){
        int i = matrixArray.indexOf(letter);

        int row = (i/6);
        int col = i - ((row) * 6);

        ArrayList<Integer> rowCol = new ArrayList<>();

        rowCol.add(row);
        rowCol.add(col);

        return rowCol;
    }

    private String convertCoordinateToLetter(ArrayList<Integer> coords){
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

    private String convertADFGVXToString(ArrayList<String> adfgvx) {
        String adfgvxString = "";
        adfgvxString += adfgvx.get(0);
        adfgvxString += adfgvx.get(1);
        return adfgvxString;
    }

    private ArrayList<String> convertStringToADFGVX (String adfgvxString){
        ArrayList<String> adfgvx = new ArrayList<>();
        adfgvx.add(String.valueOf(adfgvxString.charAt(0)));
        adfgvx.add(String.valueOf(adfgvxString.charAt(1)));
        return adfgvx;
    }

    private String concatenateADFGVXStrings(ArrayList<ArrayList<String>> listOfLetterCoordinates){
        String coordinatesListText = "";
        for ( ArrayList<String> letterCoordinates : listOfLetterCoordinates ){
            coordinatesListText += letterCoordinates.get(0) + letterCoordinates.get(1);
        }
        return coordinatesListText;
    }

    private ArrayList<ArrayList<String>> undoConcatenate(String coordinatesListText){
        ArrayList<ArrayList<String>> listOfLetterCoordinates = new ArrayList<>();
        for (int i = 0; i < keyLength; i++){
            ArrayList<String> letterCoordinates = new ArrayList<>();
            letterCoordinates.add(String.valueOf(coordinatesListText.charAt(i)));
            i++;
            letterCoordinates.add(String.valueOf(coordinatesListText.charAt(i)));
            listOfLetterCoordinates.add(letterCoordinates);
        }
        return listOfLetterCoordinates;
    }

    /**
     * adds Xs to the end of the coordinates list, providing the matrix text
     */
    private String generateMatrixTextFromString(String concatenatedADFGVXString){
        String matrixText = concatenatedADFGVXString;
        int stringLength = concatenatedADFGVXString.length();
        int numRows = (stringLength/keyLength) + 1;
        setNumRows(numRows);
        int numXs = ((numRows * keyLength) - stringLength);
        for (int i = 0; i<numXs; i++){
            matrixText += "X";
        }

        return matrixText;
    }

    /**
     * drops Xs from the end of the matrix text, providing the coordinates list text
     */
    String dropXsFromConcatenatedADFGVXString(String matrixText){
        String concatenatedADFGVXString = matrixText;
        if(matrixText.length()%2 == 1){
            concatenatedADFGVXString = matrixText.substring(0,matrixText.length()-1);
        }
        return concatenatedADFGVXString;
    }

    /**
     * alphabetized matrix columns (for example, columns E, N, C, R, Y, P, T rearrange to C, E, N, P, R, T, Y)
     */
    private String alphabetizeMatrixText(String matrixText){
        String alphabeticalMatrixText = "";
        ArrayList<ArrayList<String>> columnsList = new ArrayList<>();
        for (int col = 0; col < keyLength; col++){
            ArrayList<String> column = new ArrayList<>();
            for (int row = 0; row < getNumRows(); row++) {
                column.add(String.valueOf(matrixText.charAt(row*keyLength + col)));
            }
            columnsList.add(column);
        }
        alphabetizeKey();
        ArrayList<ArrayList<String>> sortedColumnsList = new ArrayList<>();
        for(int i = 0; i < keyLength; i++){
            sortedColumnsList.add(columnsList.get(i));
        }
        for (int i = 0; i < keyLength; i++){
            sortedColumnsList.set(decode.get(i), columnsList.get(i));
        }

        for (int col = 0; col < keyLength; col++){
            for (int row = 0; row < numRows; row++){
                alphabeticalMatrixText += sortedColumnsList.get(col).get(row);
            }
        }

        return alphabeticalMatrixText;
    }

    private String undoAlphabetized(String alphabeticalMatrixText){
        String matrixText = "";
        ArrayList<ArrayList<String>> sortedColumnsList = new ArrayList<>();
        for (int col = 0; col < keyLength; col++){
            ArrayList<String> column = new ArrayList<>();
            for (int row = 0; row < numRows; row++) {
                column.add(String.valueOf(matrixText.charAt(col*keyLength + row)));
            }
            sortedColumnsList.add(column);
        }

        ArrayList<ArrayList<String>> columnsList = new ArrayList<>();
        for (int i = 0; i < keyLength; i++){
            columnsList.set(i, sortedColumnsList.get(decode.get(i))); // not sure if this is the right order
        }

        for (int col = 0; col < keyLength; col++){
            for (int row = 0; row < numRows; row++){
                matrixText += sortedColumnsList.get(col).get(row);
            }
        }
        return matrixText;
    }

    /**
     * adds Xs to the end of the the alphabetized matrix text to mask the key length
     */
    private String generateCipherText(String alphabeticalMatrixText){
        String cipherText = alphabeticalMatrixText;
        int stringLength = alphabeticalMatrixText.length();
        int numWords = (stringLength/6) + 1;

        int numXs = ((numWords * 6) - stringLength);
        for (int i = 0; i < numWords; i++){
            cipherText += "X";
        }

        return cipherText;
    }

    /**
     * drops all the Xs allowed without allowing information loss, providing the alphabetized matrix text
     */
    private String dropXsFromCipherText(String cipherText){
        String alphabeticalMatrixText = cipherText;
        int cipherTextLength = cipherText.length();
        int numRows = cipherTextLength/keyLength;
        int matrixTextLength = numRows * keyLength;
        int charactersToDrop = cipherTextLength - matrixTextLength;
        for (int i = 0; i < charactersToDrop; i++){
            alphabeticalMatrixText = alphabeticalMatrixText.substring(0, alphabeticalMatrixText.length() - 1);
        }

        return alphabeticalMatrixText;
    }

    /**
     * alphabetizes the key and provides another arraylist storing index values so that we can decrypt
     */
    private void alphabetizeKey(){
        ArrayList<String> alphabetized = new ArrayList<>();
        ArrayList<String> keyList = new ArrayList<>();
        for (char c : key.toCharArray()){
            alphabetized.add(Character.toString(c));
            keyList.add(Character.toString(c));
        }

        Collections.sort(alphabetized);

        setKeyAlpha(alphabetized.toString());

        for(int i = 0; i < keyLength; i++){
            decode.add(alphabetized.indexOf(keyList.get(i)));
        }
    }


    public String getPlainText() {
        return pText;
    }

    public void setPlainText(String plainText) {
        this.pText = plainText;
    }

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
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

    public String getMatrixText() { return matrixText; }

    public void setMatrixText(String matrixText) { this.matrixText = matrixText; }
}
