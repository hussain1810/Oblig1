public class Oblig1 {
    public static void main (String[] args) {
        int[] a = {5, 3, 1, 10, 4};
        System.out.println("Største tall: " + maks(a));
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
}
