package g8.louisjulien;
import java.util.ArrayList;
import java.util.HashMap;

public class Vol {
    private int numeroVol;
    private String Origine;
    private String Destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String Etat;
    public static int indexVol;    // Pour définir le numéro des prochains vols (static car partagé entre instances)

    public static ArrayList<Vol> listeVolsPlanifies = new ArrayList<>(); // Liste de vols planifiés

    public int obtenirNumeroVol() {         // Getters pour pouvoir utiliser les attributs dans main, etc.
        return this.numeroVol;
    }

    public String obtenirOrigine() {
        return this.Origine;
    }

    public String obtenirDestination() {
        return this.Destination;
    }

    public String obtenirDateHeureDepart() {
        return this.dateHeureDepart;
    }

    public String obtenirDateHeureArrivee() {
        return this.dateHeureArrivee;
    }

    public String obtenirEtat() {
        return this.Etat;
    }
    // Donner id - ajouter un vol dans la liste de vols réservés avec les attributs choisis, + génère un numéro de vol
    public void planifierVol(String Origine, String Destination, String dateHeureDepart, String dateHeureArrivee) {
        this.Origine = Origine;
        this.Destination = Destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.Etat = "Planifié";
        this.numeroVol = indexVol;  // Numéro de vol depuis l'index puis ajoute 1 à l'index
        indexVol+=1;

        listeVolsPlanifies.add(this);       // Ajoute un objet Vol dans la liste avec tous les attributs qu'on a attribués à l'instance de la classe actuelle (vol1 etc)
    }

    public static void annulervol(int numeroVol) {      // BUG : annuler vol 1 annule vol 1 et 2.
        //this.numeroVol = numeroVol;
        for (Vol v : listeVolsPlanifies) {
            if (v.numeroVol == numeroVol) {
                v.Etat = "Annulé";
                System.out.println("Le vol " + numeroVol + " a été annulé.");
                break;
            }
        }
    }

    public void modifierVol() {

    }

    public void listingPassager() {

    }
}
