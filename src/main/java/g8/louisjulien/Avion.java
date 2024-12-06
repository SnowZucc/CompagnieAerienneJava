package g8.louisjulien;

import java.util.ArrayList;
import java.util.HashMap;

public class Avion {
    private int Immatriculation;
    private String Modele;
    private int Capacite;
    private ArrayList<Vol> volsAffectes = new ArrayList();


    public Avion(int Immatriculation, String Modele, int Capacite, HashMap<String, String> Situation, String posInit) {
        this.Immatriculation = Immatriculation;
        this.Modele = Modele;
        this.Capacite = Capacite;
    }

    public void affecterVol(Vol vol) {
        if (verifierDisponibilite(vol)) {
            volsAffectes.add(vol);
            vol.avion = this;
        }
    }

    public boolean verifierDisponibilite(Vol vol) {
        for (Vol v : volsAffectes) {
            if (vol.chevauche(vol)) {
                return false; // Conflit trouvé
            }
        }
        return true; // Pas de conflit
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
