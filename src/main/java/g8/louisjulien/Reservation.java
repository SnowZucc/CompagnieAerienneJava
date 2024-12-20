package g8.louisjulien;

import java.time.LocalDateTime;
import java.util.Map;

public class Reservation {
    public int numeroReservation;
    private LocalDateTime dateReservation;
    private String statut;
    private Passager passager;
    private Vol vol;

    public Reservation(int numeroReservation, Passager passager, Vol vol) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = LocalDateTime.now();     // Heure et date de maintenant
        this.statut = "Non confirmée";                  // Par défaut : non confirmée
        this.passager = passager;
        this.vol = vol;
    }

    // Cherche la réservation qui correspond au numéro dans la liste et change son statut en true
    public void confirmerReservation(int numeroReservation) {
        this.numeroReservation = numeroReservation;
        for (Map.Entry<Integer, Reservation> entry : passager.listeReservations.entrySet()) {
            if (entry.getKey() == numeroReservation) { // Vérifie si la clé correspond au numéro de réservation
                entry.getValue().statut = "Confirmée"; // Met à jour le statut de la réservation
                break; // Stoppe la boucle après la confirmation
            }
        }
    }

    public void annulerReservation(int numeroReservation) {
        passager.listeReservations.get(numeroReservation).statut = "Annulée";
        passager.listeReservations.remove(numeroReservation);
    }

    public void modifierReservation(int numeroReservation, String statut, Passager passager, Vol vol) {
        Reservation r = passager.listeReservations.get(numeroReservation);
        r.dateReservation = LocalDateTime.now();
        r.statut = statut;
        r.passager = passager;
        r.vol = vol;
    }

    public String getStatut() {
        return statut;
    }

    public Vol getVol() {
        return vol;
    }
}
