package preverifica1;

public class Docente {

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    @Override
    public String toString() {
        return "Docente{" + "numero=" + numero + ", cognome=" + cognome + ", giorno=" + giorno + ", ora=" + ora + '}';
    }

   
    private String numero;
    private String cognome;
    private String giorno;
    private String ora;

    public Docente() {
        this.giorno = "";
        this.cognome = "";
        this.ora = "";
        this.numero = "";
    }

    public Docente(String numero, String cognome, String giorno,
            String ora) {
        this.numero = numero;
        this.cognome = cognome;
        this.giorno = giorno;
        this.ora = ora;
    }

    public Docente(Docente doc) {
        this.giorno = doc.giorno;
        this.cognome = doc.cognome;
        this.ora = doc.ora;
        this.numero = doc.numero;
    }

 
  
}
