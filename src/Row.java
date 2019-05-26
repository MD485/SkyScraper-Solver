import java.util.HashSet;
import java.util.stream.Collectors;

public class Row {
    private HashSet<String> possibilities;
    Row(HashSet<String> possibilities) {
        this.possibilities = possibilities;
    }

    //Debugging
    void printRow() {
        System.out.print(possibilities.size() + ": ");
        for (String s : possibilities) {
            System.out.print(s + ", ");
        }
        System.out.println();
    }

    void retainList(HashSet<String> negationList) {
        possibilities.retainAll(negationList);
    }

    void setEntriesAtIndex(Integer index, HashSet<Character> values) {
        possibilities.removeIf((X) -> !values.contains(X.charAt(index)));
    }

    HashSet<Character> getPossibilitiesAtIndex(Integer index) {
        return possibilities.stream()
                            .map((X) -> X.charAt(index))
                            .collect(Collectors.toCollection(HashSet::new));
    }
}
