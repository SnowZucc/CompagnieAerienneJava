package g8.louisjulien;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    public int numeroReservation;
    private int dateReservation;
    private String statut;
    private Passager passager;
    private Vol vol;

    public List<Reservation> volsReserves = new ArrayList<Reservation>();

    public Reservation(int numeroReservation, int dateReservation, Passager passager, Vol vol) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = "Non reservé";
        this.passager = passager;
        this.vol = vol;
    }

    public int getDateReservation() {
        return dateReservation;
    }
    public String getStatut() {
        return statut;
    }

    // Cherche la réservation qui correspond au numéro dans la liste et change son statut en true
    public void confirmerReservation(int numeroReservation) {
        this.numeroReservation = numeroReservation;
        for (Reservation r : volsReserves) {
            if (r.numeroReservation == numeroReservation) {
                r.statut = "Reservé";
                break;
            }
        }
    }

    // Pareil pour annuler
    public void annulerReservation(int numeroReservation) {
        this.numeroReservation = numeroReservation;
        for (Reservation r : volsReserves) {
            if (r.numeroReservation == numeroReservation) {
                r.statut = "Annulée";
                break;
            }
        }
    }

    // Pareil mais pour modifier les attributs
    public void modifierReservation(int numeroReservation, int date, String statut, Passager passager, Vol vol) {
        this.numeroReservation = numeroReservation;
        for (Reservation r : volsReserves) {
            if (r.numeroReservation == numeroReservation) {
                r.dateReservation = date;
                r.statut = statut;
                r.passager = passager;
                r.vol = vol;
                break;
            }
        }
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
