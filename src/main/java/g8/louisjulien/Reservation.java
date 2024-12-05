package g8.louisjulien;

import java.time.LocalDateTime;
import java.util.Map;


public class Reservation {
    public int numeroReservation;
    private LocalDateTime dateReservation;
    private String statut;
    private Passager passager;
    private Vol vol;

    //public List<Reservation> volsReserves = new ArrayList<Reservation>();

    public Reservation(int numeroReservation, Passager passager, Vol vol) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = LocalDateTime.now();
        this.statut = "Non confirmée";
        this.passager = passager;
        this.vol = vol;
    }

    public LocalDateTime getDateReservation() {
        return dateReservation;
    }
    public String getStatut() {
        return statut;
    }

    // Cherche la réservation qui correspond au numéro dans la liste et change son statut en true
    public void confirmerReservation(int numeroReservation) {
        this.numeroReservation = numeroReservation;
        for (Map.Entry<Integer, Reservation> entry : Passager.listeReservations.entrySet()) {
            if (entry.getKey() == numeroReservation) { // Vérifie si la clé correspond au numéro de réservation
                entry.getValue().statut = "Confirmée"; // Met à jour le statut de la réservation
                break; // Stoppe la boucle après la confirmation
            }
        }
    }


    public void annulerReservation(int numeroReservation) {
        Passager.listeReservations.get(numeroReservation).statut = "Annulée";
        Passager.listeReservations.remove(numeroReservation);
    }


    public void modifierReservation(int numeroReservation, String statut, Passager passager, Vol vol) {
        Reservation r = Passager.listeReservations.get(numeroReservation);
        r.dateReservation = LocalDateTime.now();
        r.statut = statut;
        r.passager = passager;
        r.vol = vol;
    }


    public Passager getPassager() {
        return passager;
    }
    public void setPassager(Passager passager) {
        this.passager = passager;
    }
    public Vol getVol() {
        return vol;
    }
    public void setVol(Vol vol) {
        this.vol = vol;
    }
}
