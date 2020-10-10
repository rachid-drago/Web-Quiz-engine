import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String[] str = scanner.next().split("");
        String[] str2 = scanner.next().split("");
        if (str.length == str2.length) {
            for (int i = 0; i < str.length; i++) {
                if (map.containsKey(str[i])) {
                    Integer v = map.get(str[i]);
                    if (v == null)
                        v = 0;
                    v++;
                    map.put(str[i].toLowerCase(), v);
                }
                if (map2.containsKey(str2[i])) {
                    Integer v = map2.get(str2[i]);
                    if (v == null)
                        v = 0;
                    v++;
                    map.put(str2[i].toLowerCase(), v);
                }
            }
            if (map.equals(map2)) {
                System.out.println("yes");
            } else System.out.println("no");
        } else System.out.println("no");


    }
}