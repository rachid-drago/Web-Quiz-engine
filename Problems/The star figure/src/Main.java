import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n / 2 || i == n / 2 || j == i || j == n - (i + 1)) {
                    matrix[i][j] = "*";
                } else matrix[i][j] = ".";

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}