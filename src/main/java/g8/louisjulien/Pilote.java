package g8.louisjulien;

public class Pilote extends Employe{

    int Licence;
    float heuresDeVol;
    public Pilote(int Identifiant, String Nom, String Adresse, String Contact, int numeroEmploye, String dateEmbauche, int Licence, float heuresDeVol) {
        super(Identifiant, Nom, Adresse, Contact, numeroEmploye, dateEmbauche);
        this.Licence = Licence;
        this.heuresDeVol = heuresDeVol;
    }
    public void affecterVol() {

    }
    public void obtenirVol() {

    }
}
