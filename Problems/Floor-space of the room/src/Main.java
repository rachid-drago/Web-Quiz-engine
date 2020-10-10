import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double res = 0.0;
        switch (scanner.next()) {
            case "triangle" :
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double p = (a + b + c) * 0.5; // half of paramiter of triangle
                res = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                break;
            case "rectangle" :
                double a1 = scanner.nextDouble();
                double b1 = scanner.nextDouble();
                res = a1 * b1;
                break;
            case  "circle" :
                double r = scanner.nextDouble();
                res = r * r * 3.14;
                //res = Math.round(res * 10) / 10.0;
                break;
            default:
                System.out.println("");
                break;
        }
        System.out.println(res);

    }
}
