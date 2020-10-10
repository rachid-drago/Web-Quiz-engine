import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        int[] a = {9, 8, 3, 1, 5, 4};

        for (int i = 0; i <a.length; i ++) {
            if (a [i]% 2 == 0) {
                a [i] += 1;
            }
            else{
                a [i] -= 1;
            }
            System.out.print (a[i] +" ");
        }
    }
}