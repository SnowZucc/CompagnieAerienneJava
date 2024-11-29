package g8.louisjulien;

public class Personne {

    int Identifiant;
    String Nom;
    String Adresse;
    String Contact;

    public Personne(int Identifiant, String Nom, String Adresse, String Contact) {
        this.Identifiant = Identifiant;
        this.Nom = Nom;
        this.Adresse = Adresse;
        this.Contact = Contact;
    }

    public int getIdentifiant() {
        return Identifiant;
    }
    public void setIdentifiant(int Identifiant) {
        this.Identifiant = Identifiant;
    }
    public String getNom() {
        return Nom;
    }
    public String getAdresse() {
        return Adresse;
    }
    public String getContact() {
        return Contact;
    }


    public void obtenirInfo() {
        getIdentifiant();
        getNom();
        getAdresse();
        getContact();

    }
}
