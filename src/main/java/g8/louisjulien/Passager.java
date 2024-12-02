package g8.louisjulien;

import java.util.HashMap;

public class Passager extends Personne {

    private Object Passeport;
    private int nbReservations;

    public Passager(int Identifiant, String Nom, String Adresse, int Contact, int numeroEmploye, String dateEmbauche, Object Passeport) {
        super(Identifiant, Nom, Adresse, Contact);
        this.Passeport = Passeport;
        this.nbReservations = 0;
    }


    public Object getPasseport() {
        return Passeport;
    }
    public void setPasseport(Object Passeport) {
        this.Passeport = Passeport;
    }
    HashMap<Integer, Reservation> listeReservations = new HashMap<>();
    public void reserverVol(Vol vol) {
        listeReservations.put(r.numeroReservation, r);
        nbReservations++;
        listeReservations.put(nbReservations, new Reservation());
    }
    public void annulerReservation(int id) {
        listeReservations.get(id) = new Reservation();
        listeReservations.remove(id);
    }
    public void obtenirReservations(int id) {
        System.out.println(listeReservations.get(id).getDateReservation());
        System.out.println(listeReservations.get(id).getStatut());
    }

}
