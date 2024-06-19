package second_semester.BauemeUndGraphen.Uebungen.Graphen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class GraphListen {
    
    private int anzahlKnoten;
    private int anzahlKanten;
    private ArrayList<Set<Integer>> liste;


    public GraphListen() throws IOException{

        FileReader FR = new FileReader(
                "/home/woodz/Dev/Projects/Study-Java/src/second_semester/BauemeUndGraphen/Uebungen/Graphen/graph2.txt");
        BufferedReader BR = new BufferedReader(FR);

        liste = new ArrayList<Set<Integer>>();
        String Zeile;
        
         //Man kann erst zeile 1 und 2 einzelnd lesen 
         //und danach den rest zusammen:
         
             // Lese die Anzahl der Knoten
             if ((Zeile = BR.readLine()) != null) {
                anzahlKnoten = Integer.parseInt(Zeile);
                for (int i = 0; i < anzahlKnoten; i++) {
                    liste.add(new TreeSet<>()); 
                    // Initialisiere für jede Knoten ein leeres Set
                }
            }
            // Lese die Anzahl der Kanten
            if ((Zeile = BR.readLine()) != null) {
                anzahlKanten = Integer.parseInt(Zeile);
            }
        //verarbeite die restlichen Zeilen
        while ((Zeile = BR.readLine()) != null) {
            //String Zeile an den Stellen aufteilen, an denen ein Leerzeichen auftritt.
            String[] zahlenpaare = Zeile.split("\\s+");
            //sobald 2 im Array drin sind, soll 1. Zahl Start und 2. Zahl Ziel sein
            if(zahlenpaare.length >=2){
                int startKnoten = Integer.parseInt(zahlenpaare[0]);
                int zielKnoten = Integer.parseInt(zahlenpaare[1]);
                liste.get(startKnoten).add(zielKnoten);
                liste.get(zielKnoten).add(startKnoten);
            }

        }
        BR.close();
    }

    public int getKnotenAnzahl() {
		return anzahlKnoten;
	}
    public int getKantenAnzahl(){
        return anzahlKanten;
    }

    public void printGraph() {
        for (int i = 0; i < anzahlKnoten; i++) {
            System.out.print("Knoten " + i + ":");
            for (Integer kante : liste.get(i)) {
                System.out.print(" -> " + kante);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {

        GraphListen g = new GraphListen();

        System.out.println("Anzahl Knoten: " +g.anzahlKnoten);
        System.out.println("Anzahl Kanten: " +g.anzahlKanten);

        g.printGraph();
        
    }
}