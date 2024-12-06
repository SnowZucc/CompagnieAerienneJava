package g8.louisjulien;

public class PersonnelCabine extends Employe{

    int qualification;
    public PersonnelCabine(int Identifiant, String Nom, String Adresse, int Contact, int numeroEmploye, String dateEmbauche, int qualification) {
        super(Identifiant, Nom, Adresse, Contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    public void affecterVol(Vol vol) {
        vol.getEquipage().put();
    }
    public void obtenirVol() {

    }
}
