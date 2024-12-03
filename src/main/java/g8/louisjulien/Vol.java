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
    public int indexVol;    // Pour définir le numéro des prochains vols

    public static ArrayList<Vol> listeVolsPlanifies = new ArrayList<>(); // Liste de vols planifiés

    // Donner id - ajouter un vol dans la liste de vols réservés avec les attributs choisis, + génère un numéro de vol
    public void planifierVol(String Origine, String Destination, String dateHeureDepart, String dateHeureArrivee, Boolean Etat) {
        this.Origine = Origine;
        this.Destination = Destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.numeroVol = indexVol;  // Numéro de vol depuis l'index puis ajoute 1 à l'index
        indexVol+=1;

        listeVolsPlanifies.add(this);       // Ajoute un objet Vol dans la liste avec tous les attributs qu'on a attribués à l'instance de la classe actuelle (vol1 etc)
    }

    public void annulervol(int numeroVol) {
        this.numeroVol = numeroVol;
        for (Vol v : listeVolsPlanifies) {
            if (v.numeroVol == numeroVol) {
                v.Etat = "Annulé";
                break;
            }
        }
    }

    public void modifierVol() {

    }

    public void listingPassager() {

    }
}
