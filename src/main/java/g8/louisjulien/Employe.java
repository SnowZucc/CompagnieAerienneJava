package g8.louisjulien;

public class Employe extends Personne {

    final int NumeroEmploye;
    final String DateEmbauche;

    public Employe(int Identifiant, String Nom, String Adresse, String Contact, int numeroEmploye, String dateEmbauche) {
        super(Identifiant, Nom, Adresse, Contact);
        this.NumeroEmploye = numeroEmploye;
        this.DateEmbauche = dateEmbauche;
    }

    public int obtenirRole() {
        return Identifiant;
    }
}
