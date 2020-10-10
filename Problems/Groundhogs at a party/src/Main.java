import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        if ("false".equals(s[1])) {
            if (Integer.parseInt(s[0]) >= 10 && Integer.parseInt(s[0]) <= 20) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } else {
            if (Integer.parseInt(s[0]) >= 15 && Integer.parseInt(s[0]) <= 25) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
        // put your code here
    }
}