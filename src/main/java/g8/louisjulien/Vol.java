package g8.louisjulien;
import java.util.ArrayList;
import java.util.HashMap;

public class Vol {
    private int numeroVol;
    private String Origine;
    private String Destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private Boolean Etat;
//    public int indexVol;    // Pour définir le numéro des prochains vols

    public static ArrayList<Vol> listeVolsPlanifies = new ArrayList<>(); // Liste de vols planifiés

    public void planifierVol(Vol vol) {
//          this.Origine = Origine;
//          this.Destination = Destination;
//        this.dateHeureDepart = dateHeureDepart;
//        this.dateHeureArrivee = dateHeureArrivee;
//        this.numeroVol = indexVol;  // Numéro de vol depuis l'index puis ajoute 1 à l'index
//        indexVol+=1;

        listeVolsPlanifies.add(vol);
    }

    public void annulervol() {
        // Donner id - annuler vol dans la liste de vols réservés dans
    }

    public void modifierVol() {

    }

    public void listingPassager() {

    }
}
