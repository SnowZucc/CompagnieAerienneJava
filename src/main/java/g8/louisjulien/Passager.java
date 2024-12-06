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

    public int getIdentifiant() {
        return Identifiant;
    }

    public void reserverVol(Vol vol) {
        nbReservations++;
        listeReservations.put(nbReservations, new Reservation(nbReservations, this, vol));
        vol.listePassagers.add(this);
    }

    public void annulerReservation(int id) {
        listeReservations.get(id).getVol().listePassagers.remove(this);
        listeReservations.remove(id);
        nbReservations--;

    }

    public void obtenirReservations() {
        System.out.println("Réservations du passager " + this.getNom() + " :");
        for (int id : listeReservations.keySet()) {
            Reservation res = listeReservations.get(id);
            System.out.println("Réservation N°" + res.numeroReservation + " - Vol : " +
                    res.getVol().getOrigine() + " -> " + res.getVol().getDestination() +
                    " - Statut : " + res.getStatut());
        }
    }
}