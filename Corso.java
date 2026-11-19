import java.util.List;

public class Corso {
    private String nomeCorso;
    private List<Studente> studenti;
    private int punteggioMassimo;
    private int punteggioMinimo;

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setPunteggioMassimo(int max) {
        this.punteggioMassimo = max;
    }

    public void setPunteggioMinimo(int min) {
        this.punteggioMinimo = min;
    }
}