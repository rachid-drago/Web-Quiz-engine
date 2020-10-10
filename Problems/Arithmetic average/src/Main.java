import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double b = scanner.nextDouble();
        double a = scanner.nextDouble();

        double count = 0.0;
        double sum = 0.0;
        for (; b <= a; b++) {
            if (b % 3 == 0) {
                count++;
                sum += b;

            }
        }
        System.out.println(sum / count);
    }
}
