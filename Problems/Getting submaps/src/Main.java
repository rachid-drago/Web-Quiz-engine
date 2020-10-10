import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int inclusive = scanner.nextInt();
        int exclusive = scanner.nextInt();
        int n = scanner.nextInt();
        SortedMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(scanner.nextInt(), scanner.next());
        }
        //System.out.println(map.subMap(inclusive,exclusive + 1));
        map.subMap(inclusive, exclusive + 1).forEach((k, v) -> System.out.println(k + " " + v));
    }
}
