package g8.louisjulien;

import java.util.HashMap;

public class Passager extends Personne {

    private Object Passeport;
    private int nbReservations;

    static HashMap<Integer, Reservation> listeReservations = new HashMap<>();       // Static

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

    public void reserverVol(Vol vol) {
        nbReservations++;
        listeReservations.put(nbReservations, new Reservation(nbReservations, this, vol));
    }
    public void annulerReservation(int id) {
        nbReservations--;
        listeReservations.remove(id);
    }
    public String obtenirReservations(int id) {
        return listeReservations.get(id).toString();
    }

}
