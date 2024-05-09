package second_semester.DatenStrukturen.Uebungen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class RechtSchreibeHilfe {

    private String woerterbuchfile;
    private String textfile;
    private static Set<String> woerterbuch;
    private static Map<Integer, List<String>> fehlerspeicher;

    public RechtSchreibeHilfe(String woerterbuchfile, String textfile) {
        woerterbuch = new HashSet<>();
        fehlerspeicher = new HashMap<>();
    }

    private static void initialisiereWoerterbuch() throws IOException {
        FileReader FR = new FileReader(
                "/home/woodz/Dev/Projects/Study-Java/src/second_semester/DatenStrukturen/Uebungen/woerter.txt");
        BufferedReader BR = new BufferedReader(FR);
        String Zeile;
        while ((Zeile = BR.readLine()) != null) {
            woerterbuch.add(Zeile);
        }
        BR.close();
    }

    private static void analysiereText() throws IOException {
        FileReader FR = new FileReader(
                "/home/woodz/Dev/Projects/Study-Java/src/second_semester/DatenStrukturen/Uebungen/text.txt");
        BufferedReader BR = new BufferedReader(FR);

        if (!woerterbuch.isEmpty()) {
            String Zeile;
            int Zeilenzähler = 1;
            while ((Zeile = BR.readLine()) != null) {
                List<String> fehler = new ArrayList<String>();
                StringTokenizer tokenizer = new StringTokenizer(Zeile, " \n\t.,;:!?()-");
                while (tokenizer.hasMoreTokens()) {
                    fehler.add(tokenizer.nextToken());
                    if (!woerterbuch.contains(fehler)) {
                        fehlerspeicher.put(Zeilenzähler, fehler);
                    }
                }
                Zeilenzähler++;
            }

        }
        Iterator<Entry<Integer, List<String>>> iterator = fehlerspeicher.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Integer, List<String>> eintrag = iterator.next();
            Integer name = eintrag.getKey();
            List<String> nummern = eintrag.getValue();
            System.out.println(name + ": " + nummern);
        }
        BR.close();
    }

    public void generiereReport() {

    }

    public static void main(String[] args) throws IOException {

        RechtSchreibeHilfe RSH = new RechtSchreibeHilfe(null, null);

        initialisiereWoerterbuch();
        analysiereText();

    }
}
