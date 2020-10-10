import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int r = scanner.nextInt();
        String s[] = str.split(" ");
        int min = Math.abs(r - Integer.parseInt(s[0]));
        for (int i = 1; i < s.length; i++) {
            if (Math.abs(r - Integer.parseInt(s[i])) < min) {
                min = Math.abs(r - Integer.parseInt(s[i]));
            }
        }
        ArrayList<Integer> l  = new ArrayList();
        for (int i = 0; i < s.length; i++) {
            if (Math.abs(r - Integer.parseInt(s[i])) == min) {
                l.add(Integer.parseInt(s[i]));
            }
        }
        Collections.sort(l);
        for (int i : l) {
            System.out.print(i + " ");
        }
        // write your code here
    }
}
