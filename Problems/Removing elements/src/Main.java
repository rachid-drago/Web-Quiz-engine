import java.util.*;
import java.util.stream.Collectors;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        // write your code here
        Set<String> setOfString = new HashSet<>(Arrays.asList(str.split(" ")));
        Set<Integer> setOfInteger = setOfString.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toSet());
        return setOfInteger;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        // write your code here
       /* set = set.stream()
                .filter(e -> e <= 10)
                .collect(Collectors.toSet());
        //set.forEach(e -> System.out.println(e));*/
        set.removeIf(s -> s > 10);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}