package g8.louisjulien;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    public int numeroReservation;
    private final int dateReservation;
    private Boolean statut;

    public Reservation(int numeroReservation, int dateReservation) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = false;
    }


    public int getDateReservation() {
        return dateReservation;
    }
    public int getStatut() {
        return dateReservation;
    }




    public void confirmerReservation() {
        this.statut = true;
    }

    public void annulerReservation() {
        volsReserves.remove(this);
    }

    public void modifierReservation(Reservation newReservation) {

    }

    public List<Reservation> volsReserves = new ArrayList<Reservation>();

}
