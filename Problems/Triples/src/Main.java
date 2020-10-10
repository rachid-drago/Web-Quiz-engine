import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        String[] l = str.split(" ");
        int count = 0;
        int v = 0;
        for (int i = 1; i < n-1; i++) {
            if (Integer.parseInt(l[i]) == Integer.parseInt(l[i-1]) + 1 && Integer.parseInt(l[i+1]) == Integer.parseInt(l[i]) + 1) {
                count++;
            }

        }

        System.out.println(count);
    }
}