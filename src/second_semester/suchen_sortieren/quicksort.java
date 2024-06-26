package second_semester.suchen_sortieren;

import java.util.*;

public class quicksort {

    // quicksort Pivot mitte

    public static void quickSort(int[] zahlen, int links, int rechts) {
        if (links < rechts) {
            int linksindex = links;
            int rechtsindex = rechts;
            int pivot = zahlen[(links + rechts) / 2];
            do {
                while (zahlen[linksindex] < pivot) {
                    linksindex++;
                }
                while (zahlen[rechtsindex] > pivot) {
                    rechtsindex--;
                }
                if (linksindex <= rechtsindex) {
                    vertauschen(zahlen, linksindex, rechtsindex);
                    linksindex++;
                    rechtsindex--;
                }
            } while (linksindex <= rechtsindex);

            quickSort(zahlen, links, rechtsindex);
            quickSort(zahlen, linksindex, rechts);
        }

    }

    public static void vertauschen(int[] zahlen, int linksindex, int rechtsindex) {
        int hilf = zahlen[linksindex];
        zahlen[linksindex] = zahlen[rechtsindex];
        zahlen[rechtsindex] = hilf;
    }

    /**
     * Unsere Lieblingsmethode
     *
     * @param args die Kommandozeilenparameter
     */
    public static void main(String[] args) {
        int anzahl = 10;
        int[] a;

        a = bestArray(anzahl);
        System.out.println("aufsteigend geordnetes Array");
        printArray(a);
        System.out.println("quickSort:");
        quickSort(a, 0, a.length - 1);
        System.out.println();

        a = worstArray(anzahl);
        System.out.println("absteigend geordnetes Array");
        printArray(a);
        System.out.println("quickSort:");
        quickSort(a, 0, a.length - 1);

        System.out.println();

        a = randArray(anzahl);
        System.out.println("zufälliges Array");
        printArray(a);
        System.out.println("quickSort:");
        quickSort(a, 0, a.length - 1);
        printArray(a);

    }

    // Hilfsmethoden

    /**
     * Methode zum Ausgeben eines Arrays von int-Zahlen
     *
     * @param zahlen das auszugebende Array von int-Zahlen
     */
    public static void printArray(int[] zahlen) {
        System.out.println(Arrays.toString(zahlen));
    }

    /**
     * Methode zum Erzeugen eines aufsteigend sortierten Arrays von int-Zahlen
     *
     * @param n die Groesse des zu erzeugenden Arrays
     * @return das erzeugte Array {0, 1, ... , n-1}
     */
    public static int[] bestArray(int n) {
        int[] zahlen = new int[n];
        for (int i = 0; i < n; i++) {
            zahlen[i] = i;
        }
        return zahlen;
    }

    /**
     * Methode zum Erzeugen eines absteigend sortierten Arrays von int-Zahlen
     *
     * @param n die Groesse des zu erzeugenden Arrays
     * @return das erzeugte Array {n-1, n-2, ... , 0}
     */
    public static int[] worstArray(int n) {
        int[] zahlen = new int[n];
        for (int i = 0; i < n; i++) {
            zahlen[i] = n - 1 - i;
        }
        return zahlen;
    }

    /**
     * Methode zum Erzeugen eines Arrays von zuf�lligen int-Zahlen
     *
     * @param n die Groesse des zu erzeugenden Arrays
     * @return das erzeugte Array aus Zufallszahlen
     */
    public static int[] randArray(int n) {
        int[] zahlen = new int[n];
        for (int i = 0; i < n; i++) {
            zahlen[i] = (int) (Math.random() * n);
        }
        return zahlen;
    }
}