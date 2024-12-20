package g8.louisjulien;

public class Pilote extends Employe {

    int Licence;
    float heuresDeVol;

    public Pilote(int Identifiant, String Nom, String Adresse, int Contact, int numeroEmploye, String dateEmbauche, int Licence, float heuresDeVol) {
        super(Identifiant, Nom, Adresse, Contact, numeroEmploye, dateEmbauche);
        this.Licence = Licence;
        this.heuresDeVol = heuresDeVol;
    }
    public void affecterVol(Vol vol) {
        vol.getEquipage().get("Pilotes").add(this.Nom);
    }
    public void obtenirVol(int numeroVol) {
        for (Vol vol : Vol.listeVolsPlanifies) {
            if (vol.getNumeroVol() == numeroVol) {
                System.out.println(vol);
                break;
            }
        }
    }
}
