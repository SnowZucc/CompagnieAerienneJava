package g8.louisjulien;

public class Passager extends Personne {

    Object Passeport;

    public Passager(int Identifiant, String Nom, String Adresse, int Contact, int numeroEmploye, String dateEmbauche, Object Passeport) {
        super(Identifiant, Nom, Adresse, Contact);
        this.Passeport = Passeport;

    }

    public void reserverVol(Vol vol) {
        Reservation r = new Reservation(); // Instance de Réservation pour accéder à la méthode d'instance.
        r.volsReserves.add(vol);
    }
    public void annulerReservation() {

    }
    public void obtenirReservations() {

    }


}
