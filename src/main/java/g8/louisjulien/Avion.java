package g8.louisjulien;

import java.util.HashMap;

public class Avion {
    private int Immatriculation;
    private String Modele;
    private int Capacite;

    public Avion(int Immatriculation, String Modele, int Capacite) {
        this.Immatriculation = Immatriculation;
        this.Modele = Modele;
        this.Capacite = Capacite;
    }




//    public HashMap<Integer, Avion> avionsDispo = new HashMap<>();
//    public void affecterVol(Vol vol) {
//        if (verifierDisponibilite(vol)) {
//            avionsDispo.remove(this.Immatriculation);
//
//        }
//    }

//    public boolean verifierDisponibilite(Vol vol) {
//        if (vol.getDateHeureDepart() == ) {
//            return true;
//        }
//        return false;
//    }


//    -----------------------------------------  GETTERS  ---------------------------------------------------------
    public int getImmatriculation() {
        return Immatriculation;
    }
    public String getModele() {
        return Modele;
    }
    public int getCapacite() {
        return Capacite;
    }
}
