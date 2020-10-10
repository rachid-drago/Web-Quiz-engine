import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 1;
        do {
            System.out.println(i * i);
            i++;
        } while (i * i <= n);
    }
}