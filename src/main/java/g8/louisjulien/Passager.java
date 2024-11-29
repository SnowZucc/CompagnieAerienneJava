package g8.louisjulien;

public class Passager extends Personne {

    Object Passeport;

    public Passager(int Identifiant, String Nom, String Adresse, String Contact, int numeroEmploye, String dateEmbauche, Object Passeport) {
        super(Identifiant, Nom, Adresse, Contact);
        this.Passeport = Passeport;

    }

    public void reserverVol() {

    }
    public void annulerReservation() {

    }
    public void obtenirReservations() {

    }
}
