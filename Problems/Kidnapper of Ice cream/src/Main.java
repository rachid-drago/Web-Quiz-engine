import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> map = new HashMap<>();
        String[] str = scanner.nextLine().split("\\s+");;
        String[] str2 = scanner.nextLine().split("\\s+");;
        for (int i = 0; i < str.length; i++) {
            map.put(i,str[i]);
        }
        int i = 0;
        for (; i < str2.length; i++) {
            if (!map.containsValue(str2[i])) {
                System.out.println("You are busted");
            }
        }
        if (i == str2.length) System.out.println("You get money");
        //System.out.println(map);

    }
}