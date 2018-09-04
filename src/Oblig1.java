import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static void main (String[] args) {
        /*
    }
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
*/
        int[] t = {3, 1, 2, 3, 1, 2};
        System.out.println("*************************************** OPPGAVE 3 ***************************************");
        //System.out.println("USORTERT LISTE: " + antallUlikeSortert(d));
        //System.out.println("TOM LISTE; ANTALL ULIKE: " + antallUlikeUsortert(d));
        System.out.println("USORTERT LISTE; ANTALL ULIKE: " + antallUlikeUsortert(t));
        //System.out.println("SORTERT LISTE; ANTALL ULIKE: " + antallUlikeUsortert(f));
        System.out.println("*****************************************************************************************");
/*
        System.out.println();

        System.out.println("*************************************** OPPGAVE 4 ***************************************");
        int[] h = {6, 10, 9, 4, 1, 3, 8, 5, 2, 7};
        System.out.println("FØR: " + Arrays.toString(h));
        delsortering(h);
        System.out.println("ETTER: " + Arrays.toString(h));
        System.out.println("*****************************************************************************************");
    */}


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

        int antallUlike = 0;
        int m = maks0(a);
        System.out.println("maks: " + m);
        int startVerdi = 0;

        for(int i = 0; i < m; i++){
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

        for(int i = 0 + 1; i < a.length-1; i++){
            if(a[i] > maksverdi){
                m = i;              // indeks til minste verdi oppdateres
                maksverdi = a[m];    // minste verdi oppdateres
            }
        }

        return a[m];       // posisjonen til minste verdi i a[fra:til>
    }

    public static void delsortering(int[] a){
        selectionSort(a);

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length-1; j++){
                if(a[j] % 2 == 0){
                    bytt(a, j+1, j);
                }
            }
        }
    }

    public static void selectionSort(int[] a){
        for(int i = 0; i < a.length-1; i++){
            int max_index = findMin(a, i, a.length);
            int temp = a[max_index];
            a[max_index] = a[i];
            a[i] = temp;
        }
    }

    public static int findMin(int[] a, int fra, int til){
        int current_min = a[fra];
        int current_index = fra;

        for(int i = fra+1; i < til; i++){
            if(a[i] < current_min){
                current_min = a[i];
                current_index = i;
            }
        }

        return current_index;
    }

    public static void bytt(int[] a, int i, int j){
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
