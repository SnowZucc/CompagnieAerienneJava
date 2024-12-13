package g8.louisjulien;

import java.util.HashMap;

public class Passager extends Personne {
    private String Passeport;
    private int nbReservations;

    public HashMap<Integer, Reservation> listeReservations = new HashMap<>();       // Static

    public Passager(String Nom, String Adresse, int Contact, String Passeport) {
        super(Nom, Adresse, Contact);
        this.Passeport = Passeport;
        this.nbReservations = 0;
    }

    public void reserverVol(Vol vol) {
        nbReservations++;
        listeReservations.put(nbReservations, new Reservation(nbReservations, this, vol));
        vol.listePassagers.add(this);
        Vol.Revenus+=Vol.prixBillet;
    }

    public void annulerReservation(int id) {
        listeReservations.get(id).getVol().listePassagers.remove(this);
        listeReservations.remove(id);
        nbReservations--;
        System.out.println("La réservation " + id + " a été annulée");
    }

    public void obtenirReservations() {
        System.out.println("Réservations du passager " + this.getNom() + " :");
        for (int id : listeReservations.keySet()) {
            Reservation res = listeReservations.get(id);
            System.out.println("Réservation N°" + res.numeroReservation + " - Vol : " +                // Accès aux indices spécifiques des tableaux Origine et Destination
                    res.getVol().getOrigine()[0] + " -> " + res.getVol().getDestination()[0] +
                    " - Statut : " + res.getStatut());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "INFORMATIONS SUR LE PASSAGER " + this.Nom + " :"
                + "\nTel: " + this.Contact
                + "\nAdresse: " + this.getAdresse()
                + "\nID Passeport: " + this.getPasseport()
                + "\nIdentifiant Personne:" + this.getIdentifiant();
    }


//    -----------------------------------------  GETTERS  ---------------------------------------------------------

    public Object getPasseport() {
        return Passeport;
    }

    public int getIdentifiant() {
        return Identifiant;
    }
}