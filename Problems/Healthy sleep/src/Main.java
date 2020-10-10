import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int H = scanner.nextInt();
        if (H < A) System.out.println("Deficiency");
        if (H > B) System.out.println("Excess");
        if (H >= A && H <= B) System.out.println("Normal");
    }
}