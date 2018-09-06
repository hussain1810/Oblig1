import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static void main (String[] args) {
        /*
        int[] a = {7, 2, 13, 10, 4};
        int[] b = Arrays.copyOf(a, a.length);
        int[]c = {};

        int[] d = {};
        int[] e = {5, 3, 7, 4, 3, 5, 7, 8, 6, 7};
        int[] f = Arrays.copyOf(e, e.length);
        Arrays.sort(f);


        System.out.println("*************************************** OPPGAVE 1 ***************************************");
        System.out.println("FØR: " + Arrays.toString(a));
        System.out.println("Største tall: " + maks(a));
        System.out.println("Antall ombyttinger: " + ombyttinger(b));
        System.out.println("ETTER: " + Arrays.toString(a));
        System.out.println("*****************************************************************************************");

        System.out.println();

        System.out.println("*************************************** OPPGAVE 2 ***************************************");
        //System.out.println("USORTERT LISTE: " + antallUlikeSortert(d));
        System.out.println("TOM LISTE; ANTALL ULIKE: " + antallUlikeSortert(d));
        System.out.println("SORTERT LISTE; ANTALL ULIKE: " + antallUlikeSortert(f));
        System.out.println("*****************************************************************************************");

        System.out.println();

        int[] t = {6,2,4,6,9,1,4,9,10};
        System.out.println("*************************************** OPPGAVE 3 ***************************************");
        //System.out.println("USORTERT LISTE: " + antallUlikeSortert(d));
        //System.out.println("TOM LISTE; ANTALL ULIKE: " + antallUlikeUsortert(d));
        System.out.println("USORTERT LISTE; ANTALL ULIKE: " + antallUlikeUsortert(t));
        //System.out.println("SORTERT LISTE; ANTALL ULIKE: " + antallUlikeUsortert(f));
        System.out.println("*****************************************************************************************");

        System.out.println();

        System.out.println("*************************************** OPPGAVE 4 ***************************************");
        int[] h = {6, 10, 9, 4, 1, 3, 8, 5, 2, 7};
        System.out.println("FØR: " + Arrays.toString(h));
        delsortering(h);
        System.out.println("ETTER: " + Arrays.toString(h));
        System.out.println("*****************************************************************************************");
    */
    /*
        int[] x = {-4,-1,3,0,2,-3};
        int[] z = {1,2,3,4,5,6};
        System.out.println("*************************************** OPPGAVE 5 ***************************************");
        //delsortering(x);
        delsortering(z);
        //System.out.println("LISTE SORTERT X: " + Arrays.toString(x));
        System.out.println("LISTE SORTERT Z: " + Arrays.toString(z));
        System.out.println("*****************************************************************************************");
    */
    /*
        char[] a = {};
        System.out.println("*************************************** OPPGAVE 5 ***************************************");
        rotasjon(a);
        System.out.println("LISTE ROTERT: " + Arrays.toString(a));
        System.out.println("*****************************************************************************************");


        char[] a = {'A','B','C','D','E','F','G','H','I','J'};
        System.out.println("*************************************** OPPGAVE 6 ***************************************");
        System.out.println(Arrays.toString(a));
        rotasjon(a,3);
        System.out.println(Arrays.toString(a));rotasjon(a,-2);
        System.out.println(Arrays.toString(a));
        System.out.println("*****************************************************************************************");
*/

        System.out.println("*************************************** OPPGAVE 7 ***************************************");
        String a = flett("ABC","DEFGH");
        String b = flett("IJKLMN","OPQ");
        String c = flett("","AB");
        System.out.println(a + " " + b + " " + c);

        System.out.println();

        String d = flett("AFK", "BGLP", "CHMQT", "DINRUW", "EJOSVXY");
        System.out.println(d);
        System.out.println("*****************************************************************************************");
    }


    /****
     * Metode som setter det største tallet i listen bakerst i listen
     * @param a - liste med tall
     * @return returnerer det siste tallet i listen (som skal være det største)
     */
    public static int maks(int[] a)
    {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen er tom!");
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


    /****
     * Metode som teller antall ombyttinger som skjer
     * @param a - liste med tall
     * @return returnerer antall ombyttinger
     */
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


    public static int antallUlikeSortert(int[] a){
        if (a.length == 0){
            return 0;
        }

        int antallUlike = 1;

        for(int i = 0; i < a.length-1; i++){
            if(a[i] > a[i+1]){
                throw new IllegalStateException("Tabellen er ikke sortert!");
            }
        }

        for(int i=0; i < a.length-1; i++){
            if(a[i] != a[i+1]){
                antallUlike++;
            }
        }

        return antallUlike;
    }

    public static int antallUlikeUsortert(int[] a){
        if (a.length == 0){
            return 0;
        }

        if(a.length == 1){
            return 1;
        }

        int antallUlike = 0;
        int m = maks0(a);
        int startVerdi = 0;

        for(int i = 0; i <= m; i++){
            for (int j : a){
                if(startVerdi == j){
                    antallUlike++;
                    break;
                }
            }
            if(startVerdi > m){
                break;
            }
            startVerdi++;
        }

        return antallUlike;
    }

    public static int maks0(int[] a){

        int m = 0;            // indeks til minste verdi i a[fra:til>
        int maksverdi = a[0];  // minste verdi i a[fra:til>

        for(int i = 0 + 1; i < a.length; i++){
            if(a[i] > maksverdi){
                m = i;              // indeks til minste verdi oppdateres
                maksverdi = a[m];    // minste verdi oppdateres
            }
        }

        return a[m];       // posisjonen til minste verdi i a[fra:til>
    }


    /***
     * Oppgave 4
     * @param a - liste a
     */
    public static void delsortering(int[] a){
        int v = 0; int h = a.length-1;

        int antallOddetall = finnOddetall(a);

        for(int i = v; i < a.length; i++){
            for(int j = h; j >= antallOddetall; j--){
                if((a[v] % 2 == 0) && (a[h] % 2 != 0)){
                    bytt(a, v++, h--);
                    break;
                } else if((a[v] % 2 == 0) && (a[h] % 2 == 0)) {
                    h--;
                    break;
                }
                else if((a[v] % 2 != 0) && (a[h] % 2 != 0)){
                    v++;
                    break;
                }
                else if((a[v] % 2 != 0) && (a[h] % 2 == 0)){
                    v++;
                    h--;
                    break;
                }
            }
        }
        Arrays.sort(a, 0, antallOddetall);
        Arrays.sort(a, antallOddetall, a.length);
    }

    public static int finnOddetall(int[]a){
        int antallOddetall = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 != 0) antallOddetall++;
        }

        return antallOddetall;
    }

    public static void bytt(int[] a, int i, int j){
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    // OPPGAVE 5
    public static void rotasjon(char[] a){
        char temp = 0;

        if(a.length > 0){
            temp = a[a.length-1];
        }
        char[] b = new char[a.length];


        for(int i = 0; i < a.length-1; i++){
            b[i+1] = a[i];
        }

        if(temp > 0) {
            b[0] = temp;
        }

        for(int i = 0; i < a.length; i++){
            a[i] = b[i];
        }
    }

    // OPPGAVE 6
    public static void rotasjon(char[] a, int k){
        int l = a.length;
        if(l < 2) return;

        if ((k %= l) < 0) k += l;

        int s = gcd(l, k);

        for (int i = 0; i < s; i++) {
            char verdi = a[i];

            for(int j = i - k, t = i; j != i; j -= k){
                if (j < 0) {
                    j += l;
                }
                a[t] = a[j]; t = j;
            }

            a[i + k] = verdi;
        }
    }

    public static int gcd(int l, int k){
        return k == 0 ? l : gcd(k, l % k);
    }

    // OPPGAVE 7 a)
    public static String flett(String s, String t){
        int k = Math.min(s.length(), t.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++){
            sb.append(s.charAt(i)).append(t.charAt(i));
        }

        sb.append(s.substring(k)).append(t.substring(k));

        return sb.toString();
    }

    // OPPGAVE 7 b)
    public static String flett(String... s){
        StringBuilder sb = new StringBuilder();

        int max = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i].length() > max) max = s[i].length();
        }

        for(int i = 0; i < max; i++){
            for(int j = 0; j < s.length; j++){
                if(s[j].length() <= i){
                    continue;
                }else {
                    sb.append(s[j].charAt(i));
                    continue;
                }
            }
        }

        return sb.toString();
    }
}
