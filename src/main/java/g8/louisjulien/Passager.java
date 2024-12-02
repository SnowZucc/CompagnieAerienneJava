package g8.louisjulien;

public class Passager extends Personne {

    Object Passeport;

    public Passager(int Identifiant, String Nom, String Adresse, int Contact, int numeroEmploye, String dateEmbauche, Object Passeport) {
        super(Identifiant, Nom, Adresse, Contact);
        this.Passeport = Passeport;

    }


    Reservation r = new Reservation(); // Instance de Réservation pour accéder à la méthode d'instance.
    public void reserverVol(Reservation vol) {
        r.volsReserves.add(vol);
    }
    public void annulerReservation(Reservation vol) {
        r.volsReserves.remove(vol);
    }
    public void obtenirReservations(int numeroReservations) {
        Reservation rTrouve = null;
        for (Reservation reservation : r.volsReserves) {
            if (reservation.numeroReservation == numeroReservations) {
                rTrouve = reservation;
                break;
            }
        }
        System.out.println(rTrouve.getDateReservation());
        System.out.println(rTrouve.getStatut());
    }


}
