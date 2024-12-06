package g8.louisjulien;

public class PersonnelCabine extends Employe{

    int qualification;
    public PersonnelCabine(int Identifiant, String Nom, String Adresse, int Contact, int numeroEmploye, String dateEmbauche, int qualification) {
        super(Identifiant, Nom, Adresse, Contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    public void affecterVol(Vol vol) {
        vol.getEquipage().get("Personnel Cabine").add(this.Nom);
    }
    public void obtenirVol(int numeroVol) {
        for (Vol vol : Vol.listeVolsPlanifies) {
            if (vol.getNumeroVol() == numeroVol) {
                vol.toString();
                break;
            }
        }
    }
}
