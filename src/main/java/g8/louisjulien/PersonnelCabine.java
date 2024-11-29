package g8.louisjulien;

public class PersonnelCabine extends Employe{

    int qualification;
    public PersonnelCabine(int Identifiant, String Nom, String Adresse, String Contact, int numeroEmploye, String dateEmbauche, int qualification) {
        super(Identifiant, Nom, Adresse, Contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    public void affecterVol() {

    }
    public void obtenirVol() {

    }
}
