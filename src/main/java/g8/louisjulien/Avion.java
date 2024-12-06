package g8.louisjulien;

import java.util.ArrayList;
import java.util.HashMap;

public class Avion {
    private int Immatriculation;
    private String Modele;
    private int Capacite;
    private HashMap<String, String> Situation; // Position de l'avion en fonction de la date et l'heure
    private ArrayList<Vol> volsAffectes = new ArrayList();
    private final String posInit;

    public HashMap<Integer, Avion> avionsDispo = new HashMap<>();

    public Avion(int Immatriculation, String Modele, int Capacite, HashMap<String, String> Situation, String posInit) {
        this.Immatriculation = Immatriculation;
        this.Modele = Modele;
        this.Capacite = Capacite;
        this.Situation = Situation;
        this.posInit = posInit;
    }

    public void affecterVol(Vol vol) {
        if (verifierDisponibilite(vol)) {
            Situation.put(vol.getDateHeureDepart(), vol.getOrigine()[1]);
            Situation.put(vol.getDateHeureArrivee(), vol.getDestination()[1]);
            avionsDispo.remove(this.Immatriculation);
            vol.avion = this;
        }
    }

    public boolean verifierDisponibilite(Vol vol) {
        if (this.Situation.get(vol.getDateHeureDepart()).equals(vol.getOrigine()[1])) {
            return true;
        }
        return false;
    }

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
//    public HashMap<String, Aeroport> getSituation() {
//        return Situation;
//    }
}
