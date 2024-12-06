package g8.louisjulien;

public class Personne {
    private String Adresse;

    public int Identifiant;
    public String Nom;
    public int Contact;
    public static int indexPersonne;

    public Personne(String Nom, String Adresse, int Contact) {
        this.Identifiant = indexPersonne;
        indexPersonne+=1;
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
    public int getContact() {
        return Contact;
    }


    public void obtenirInfos() {
        System.out.println("Informations de " + getNom() + " :");
        System.out.println("Identifiant : " + getIdentifiant());
        System.out.println("Adresse : " + getAdresse());
        System.out.println("Contact :"  + getContact());
    }
}
