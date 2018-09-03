import java.util.Arrays;

public class Oblig1 {
    public static void main (String[] args) {
        int[] a = {2, 7, 3, 10, 4};
        int[] b = {2, 7, 3, 10, 4};
        int[]c = {};

        System.out.println("FØR: " + Arrays.toString(a));
        System.out.println("Største tall: " + maks(a));
        System.out.println("Antall ombyttinger: " + ombyttinger(b));
        System.out.println("ETTER: " + Arrays.toString(a));
    }

    public static int maks(int[] a)
    {
        if (a.length < 0) {
            throw new IllegalArgumentException("Tabellen er tom!");
        }

        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }

        return a[a.length-1];
    }

    public static int ombyttinger(int[] a)
    {
        if (a.length < 0) {
            throw new IllegalArgumentException("Tabellen er tom!");
        }

        int antallOmb = 0;

        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                antallOmb++;
            }
        }

        return antallOmb;
    }
}
