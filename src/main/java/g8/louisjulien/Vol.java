package g8.louisjulien;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Vol {
    private int numeroVol;
    private String Origine;
    private String Destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String Etat; // 4 états: En attente, En cours, Terminé, Annulé
    public static int indexVol;    // Pour définir le numéro des prochains vols (static car partagé entre instances)

    public static ArrayList<Vol> listeVolsPlanifies = new ArrayList<>(); // Liste de vols planifiés

    public Vol(int numeroVol, String Origine, String Destination, String dateHeureDepart, String dateHeureArrivee, String etat) {
        this.numeroVol = numeroVol;
        this.Origine = Origine;
        this.Destination = Destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.Etat = etat;
    }

    // !!! METHODE A REFAIRE: il faut planifier tous les vols d'une journée,
    // i.e regarder la date et l'heure des vols et les ajouter à une liste !!!
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

    public static void annulerVol(int numeroVol) {      // BUG : annuler vol 1 annule vol 1 et 2.
        //this.numeroVol = numeroVol;
        for (Vol v : listeVolsPlanifies) {
            if (v.numeroVol == numeroVol) {
                v.Etat = "Annulé";
                System.out.println("Le vol " + numeroVol + " a été annulé.");
                break;
            }
        }
    }

    public void modifierVol(String origine, String destination, String dateHeureDepart, String dateHeureArrivee, String etat) {
        this.Origine = origine;
        this.Destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.Etat = etat;
    }

    public List<Passager> listePassagers = new ArrayList<>();
    public void listingPassager() {
        System.out.println("Liste des passagers pour le vol N°" + this.numeroVol + " :");
        for (Passager p : listePassagers) {
            System.out.println("Passager : " + p.getNom());
        }
    }
//    -----------------------------------------  GETTERS  ---------------------------------------------------------

    public int getNumeroVol() {         // Getters pour pouvoir utiliser les attributs dans main, etc.
        return this.numeroVol;
    }

    public String getOrigine() {
        return this.Origine;
    }

    public String getDestination() {
        return this.Destination;
    }

    public String getDateHeureDepart() {
        return this.dateHeureDepart;
    }

    public String getDateHeureArrivee() {
        return this.dateHeureArrivee;
    }

    public String getEtat() {
        return this.Etat;
    }
}