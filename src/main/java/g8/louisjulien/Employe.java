package g8.louisjulien;

public class Employe extends Personne {
    final int NumeroEmploye;
    final String DateEmbauche;

    public Employe(int Identifiant, String Nom, String Adresse, int Contact, int numeroEmploye, String dateEmbauche) {
        super(Nom, Adresse, Contact);
        this.NumeroEmploye = numeroEmploye;
        this.DateEmbauche = dateEmbauche;
    }

    public String obtenirRole() {
        return "Rôle de l'employé :" + this.getClass().getSimpleName() + " | Identifiant : " +  this.NumeroEmploye;     // On renvoie le nom de la sous-classe comme rôle avec getSimpleName
    }
}
