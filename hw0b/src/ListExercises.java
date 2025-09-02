import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        int sum = 0;
        for (int num : L) {
            sum += num;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer> even = new ArrayList<>();
        for (int num : L) {
            if (num % 2 == 0){
                even.add(num);
            }
        }
        return even;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        List<Integer> commom = new ArrayList<>();
        for (int num : L1){
            if (L1.contains(num) && L2.contains(num)){
                commom.add(num);
            }
        }
        return commom;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int num = 0;
        for (String word : words){
            for (char character : word.toCharArray()){
                if (character == c){
                    num++;
                }
            }
        }
        return num;
    }
}
