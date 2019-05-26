import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Board {
    private final int boardSize;
    private ArrayList<Row> rows;

    Board(ArrayList<Integer> clues) {
        //A quarter of a square's perimeter is the size of one side.
        boardSize = clues.size() / 4; //28 inputs = 7x7 board.

        if (boardSize > 9) {
            //I'm using [1-9] ascii to represent the fields.
            System.out.println("Board size too big");
        } else {
            generateRows(clues);
            solve();
        }
    }

    //Debugging
    void printRows() {
        for(Row row : rows) {
            row.printRow();
        }
    }

    /* The board is represented in code as only two sides, with anti-patterns on each of the
     * side to ensure consistency with the original board input.
     *  0 0
     * 2   1
     * 1   2
     *  0 2
     * For instance the board above would be reduced to the top and right sides, with negation
     * patterns on the top right 0, only allowing patterns that are the reverse of 2, and negation
     * patterns on the whole right side.
     * Winding up with 4 rows to represent 8 clues.
     * A lot of the code below is just to make sure that the correct negation patterns are applied
     * to the correct rows. e.g index 4 negated on index 1, i[5] on i[0], i[6] on i[3],
     * i[7] on i[2], etc. Left mapped to right bottom mapped to top.
    */
    private void generateRows(ArrayList<Integer> clues) {
        rows = new ArrayList<>();
        HashMap<Integer, HashSet<String>> variations = Variations.getVariations(boardSize);
        int i = 0;
        for (; i < clues.size()/2; i++) {
            rows.add(new Row(new HashSet<>(variations.get(clues.get(i)))));
        }
        int offset = (clues.size()*3)/4 - 1;
        for (; i < offset + 1; i++){
            int rowIndex = Math.abs(i - offset); //Like above, i[4] => i[1], i[5] => i[0],etc.
            Row row = rows.get(rowIndex);
            int clue = -(clues.get(i)); //We want the negation pattern of the clue.
            HashSet<String> negationList = variations.get(clue);
            row.retainList(negationList);
            //The following code is identical to the code above:
            //rows.get(Math.abs(i - offset)).retainList(variations.get(-clues.get(i)));
        }
        offset += clues.size()/2;
        for (; i < clues.size(); i++) {
            rows.get(Math.abs(i - offset)).retainList(variations.get(-clues.get(i)));
        }
    }

    //This whole codebase is a refactor of my original code, except my original code required far
    //more steps in this method, including a removePairs, removeSets and finally recursiveDescent
    //methods, I question whether my original implementation had some logical flaws.
    private void solve() {
        while (!solveCheck()) {
            removeSingletons();
        }
        System.out.println(boardString());
    }

    private void removeSingletons() {
        for (int i = 0; i < boardSize; i++) {
            Row rowA, rowB;
            rowA = rows.get(i);
            for (int j = 0; j < boardSize; j++) {
                rowB = rows.get(boardSize + j);
                HashSet<Character> indexA, indexB;
                indexA = rowA.getPossibilitiesAtIndex(j);
                indexB = rowB.getPossibilitiesAtIndex(boardSize - i - 1);
                rowB.setEntriesAtIndex(boardSize - i - 1, indexA);
                rowA.setEntriesAtIndex(j, indexB);
            }
        }
    }

    //If there is more than one possibility in any index in any row, this returns false.
    private boolean solveCheck() {
        for (Row r : rows) {
            for (int i = 0; i < boardSize; i++) {
                if (r.getPossibilitiesAtIndex(i).size() != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    String boardString() {
        StringBuilder boardString = new StringBuilder();
        for (int j = 0; j < boardSize; j++) {
            for (int i = 0; i < boardSize; i++) {
                //The possibilities are offset to 7+ so the board will print as if the inputs were
                //given clockwise starting from the top row.
                HashSet<Character> possibilities =
                        rows.get(j + boardSize).getPossibilitiesAtIndex(i);
                if (possibilities.size() != 1) {
                    boardString.append("[" + possibilities.size() + "]");
                } else {
                    boardString.append(" " + possibilities.iterator().next() + " ");
                }
                boardString.append(",");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
