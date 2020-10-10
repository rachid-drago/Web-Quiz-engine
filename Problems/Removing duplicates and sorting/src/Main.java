import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();

        Set<String> set = new TreeSet<>();
        for (int i = 0; i <= lines; i++) {
            set.add(scanner.nextLine());
        }

        set.forEach(System.out::println);
    }

}