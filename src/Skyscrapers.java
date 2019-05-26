import java.util.ArrayList;
import java.util.Arrays;

public class Skyscrapers {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> cluesList = new ArrayList<>();
        cluesList.add(new ArrayList<>(Arrays.asList(0,2,3,0,2,0,0, 5,0,4,5,0,4,0, 0,4,2,0,0,0,6, 5,2,2,2,2,4,1)));
        cluesList.add(new ArrayList<>(Arrays.asList(7,0,0,0,2,2,3, 0,0,3,0,0,0,0, 3,0,3,0,0,5,0, 0,0,0,0,5,0,4)));
        cluesList.add(new ArrayList<>(Arrays.asList(0,4,0,7,5,2,0, 0,1,4,0,4,0,0, 3,0,0,0,0,0,2, 0,3,0,6,0,0,1)));
        cluesList.add(new ArrayList<>(Arrays.asList(4,1,2,5,3,3,2, 4,1,2,4,5,4,2, 2,5,1,2,4,3,3, 3,3,1,2,3,5,2)));
        cluesList.add(new ArrayList<>(Arrays.asList(0,2,3,0,2,0,0, 5,0,4,5,0,4,0, 0,4,2,0,0,0,6, 0,0,0,0,0,0,0)));
        cluesList.add(new ArrayList<>(Arrays.asList(0,0,5,0,0,0,6, 4,0,0,2,0,2,0, 0,5,2,0,0,0,5, 0,3,0,5,0,0,3)));
        cluesList.add(new ArrayList<>(Arrays.asList(0,0,5,3,0,2,0, 0,0,0,4,5,0,0, 0,0,0,3,2,5,4, 2,2,0,0,0,0,5)));
        cluesList.add(new ArrayList<>(Arrays.asList(6,4,0,2,0,0,3, 0,3,3,3,0,0,4, 0,5,0,5,0,2,0, 0,0,0,4,0,0,3)));
        cluesList.add(new ArrayList<>(Arrays.asList(0,0,0,5,0,0,3, 0,6,3,4,0,0,0, 3,0,0,0,2,4,0, 2,6,2,2,2,0,0)));
        cluesList.add(new ArrayList<>(Arrays.asList(3,3,2,1,2,2,3, 4,3,2,4,1,4,2, 2,4,1,4,5,3,2, 3,1,4,2,5,2,3)));

        for (ArrayList<Integer> clues : cluesList) {
            Board a = new Board(clues);
        }

    }
}
