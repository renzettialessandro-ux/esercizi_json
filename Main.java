import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        // Creiamo l'oggetto Gson
        Gson gson = new Gson();

        try {
            // 1. LEGGERE IL FILE JSON
            FileReader reader = new FileReader("corso.json");
            Corso corso = gson.fromJson(reader, Corso.class);
            reader.close();

            // 2. CALCOLARE MAX E MIN
            // Partiamo prendendo il punteggio del primo studente come riferimento
            int max = corso.getStudenti().get(0).getPunteggio();
            int min = corso.getStudenti().get(0).getPunteggio();

            // Ciclo for classico per controllare tutti gli studenti
            for (int i = 0; i < corso.getStudenti().size(); i++) {
                int puntiAttuali = corso.getStudenti().get(i).getPunteggio();

                if (puntiAttuali > max) {
                    max = puntiAttuali; // Nuovo record massimo!
                }
                if (puntiAttuali < min) {
                    min = puntiAttuali; // Nuovo record minimo!
                }
            }

            // Salviamo i risultati trovati dentro l'oggetto corso
            corso.setPunteggioMassimo(max);
            corso.setPunteggioMinimo(min);

            // 3. SCRIVERE IL NUOVO FILE JSON
            // Usiamo GsonBuilder per fare in modo che il file sia "bello da leggere" (con gli a capo)
            Gson gsonBello = new GsonBuilder().setPrettyPrinting().create();
            
            FileWriter writer = new FileWriter("corso_output.json");
            gsonBello.toJson(corso, writer);
            writer.close();

            System.out.println("Fatto! Ho creato il file corso_output.json");

        } catch (Exception e) {
            System.out.println("C'è stato un errore: " + e.getMessage());
        }
    }
}
