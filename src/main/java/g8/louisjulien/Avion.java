package g8.louisjulien;

import java.util.ArrayList;
import java.util.HashMap;

public class Avion {
    private final int Immatriculation;
    private final String Modele;
    private final int Capacite;
    private ArrayList<Vol> volsAffectes;


    public Avion(int Immatriculation, String Modele, int Capacite) {
        this.Immatriculation = Immatriculation;
        this.Modele = Modele;
        this.Capacite = Capacite;
        this.volsAffectes = new ArrayList<>();
    }

    public void affecterVol(Vol vol) {
        if (verifierDisponibilite(vol)) {
            volsAffectes.add(vol);
            vol.avion = this;
            return;
        }
        System.out.println("AFFECTATION IMPOSSIBLE");
    }

    public boolean verifierDisponibilite(Vol vol) {
        for (Vol v : volsAffectes) {
            if (v.chevauche(vol)) {
                System.out.println("Avion indisponible pour ce vol.");
                return false; // Conflit trouvé
            }
        }
        System.out.println("Avion disponible pour ce vol!");
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
