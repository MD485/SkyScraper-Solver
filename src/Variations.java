import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Variations {

    private static HashMap<Integer, HashSet<String>> variations;

    //Generates patterns and anti-patterns of all heights possible given the input size.
    static HashMap<Integer, HashSet<String>> getVariations (Integer boardSize) {
        variations = new HashMap<>();
        for (int i = -boardSize; i < boardSize + 1; i++)
            variations.put(i, new HashSet<>());
        generateVariations(generatePossibilities(boardSize), "");
        return variations;
    }

    //Used for debugging
    static void printVariations() {
        for (Map.Entry<Integer, HashSet<String>> entry: variations.entrySet() ) {
            System.out.println(entry.getKey()+ ": ");
            for (String s : entry.getValue()) {
                System.out.print(s + ",");
            }
            System.out.println();
        }
    }

    //Recursively generate all unique combinations of a string.
    static void generateVariations(String a, String b){
        if (a.equals("")) {
            variations.get(0).add(b); //0 will be a superset of all variations.
            variations.get(getHeight(b)).add(b);
            String revB = reverseString(b);
            variations.get(-getHeight(b)).add(revB);
        } else {
            for (int i = 0; i < a.length(); i++) {
                generateVariations(a.subSequence(0,i) + a.substring(i+1), b + a.charAt(i));
            }
        }
    }

    //Gets the "height" of a string, e.g. 1234 - height 4, 4321 - height 1, 2143 - height 2
    static Integer getHeight(String a) {
        Integer height = 1;
        char largest = a.charAt(0);
        for (int i = 1; i < a.length(); i++) {
            if (largest < a.charAt(i)) {
                height++;
                largest = a.charAt(i);
            }
        }
        return height;
    }

    static String reverseString(String a) {
        StringBuilder b = new StringBuilder(a.length());
        for (int i = a.length() - 1; i > -1; i--)
            b.append(a.charAt(i));
        return b.toString();
    }

    //Generates ascii representations of possibilities starting at "1", can be expanded to skip
    //over non-alphanumeric characters, if a board is larger than 9x9 but currently the code
    //doesn't do this.
    static private String generatePossibilities(Integer boardSize) {
        StringBuilder possibilities = new StringBuilder(boardSize);
        char charCode = 49; //Char code 1
        for(int i = boardSize; i > 0; i--) {
            possibilities.append(charCode++);
        }
        return possibilities.toString();
    }

}
