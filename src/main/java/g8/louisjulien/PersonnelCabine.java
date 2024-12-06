package g8.louisjulien;

public class PersonnelCabine extends Employe{

    String qualification;
    public PersonnelCabine(int Identifiant, String Nom, String Adresse, int Contact, int numeroEmploye, String dateEmbauche, String qualification) {
        super(Identifiant, Nom, Adresse, Contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    public void affecterVol(Vol vol) {
        vol.getEquipage().get("Personnel Cabine").add(this.Nom);
    }
    public void obtenirVol(int numeroVol) {
        for (Vol vol : Vol.listeVolsPlanifies) {
            if (vol.getNumeroVol() == numeroVol) {
                System.out.println(vol.toString());
                break;
            }
        }
    }
}
