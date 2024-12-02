package g8.louisjulien;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    public int numeroReservation;
    private int dateReservation;
    private Boolean statut;
    private Passager passager;
    private Vol vol;

    public Reservation(int numeroReservation, int dateReservation, Vol vol) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = false;
        this.passager = passager;
        this.vol = vol;
    }
    public Reservation() {}

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
        this.statut = false;
    }
    public void ModifierReservation(int date, boolean statut, Passager passager, Vol vol) {
        this.dateReservation = date;
        this.statut = statut;
        this.passager = passager;
        this.vol = vol;
    }

    public List<Reservation> volsReserves = new ArrayList<Reservation>();

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
