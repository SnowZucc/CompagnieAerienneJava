package g8.louisjulien;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Vol {
    private final int numeroVol;
    private String[] Origine = new String[2];
    private String[] Destination = new String[2];
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String Etat; // 3 états: Planifié, Annulé, Modifié
    public static int indexVol;    // Pour définir le numéro des prochains vols (static car partagé entre instances)

    private Avion avion;
    HashMap<String, ArrayList<String>> equipage =  new HashMap<>();
    private ArrayList<String> pilotes = new ArrayList<>();
    private ArrayList<String> personnelCab = new ArrayList<>();


    public static ArrayList<Vol> listeVolsPlanifies = new ArrayList<>(); // Liste de vols planifiés

    public Vol(String Origine, String Destination, String dateHeureDepart, String dateHeureArrivee) {
        this.numeroVol = indexVol;
        indexVol+=1;
        this.Origine[0] = Origine;
        this.Destination[0] = Destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.Etat = "Planifié";
        listeVolsPlanifies.add(this);
        this.equipage.put("Pilotes", pilotes);
        this.equipage.put("Personnel Cabine", personnelCab);
    }

    // !!! METHODE A REFAIRE: il faut planifier tous les vols d'une journée,
    // i.e regarder la date et l'heure des vols et les ajouter à une liste !!!
    // Donner id - ajouter un vol dans la liste de vols réservés avec les attributs choisis, + génère un numéro de vol

    public static List<Vol> planifierVol(String dateHeureDepart) {
        System.out.println("=========== Vols pour le " + dateHeureDepart + " ===============");
        List<Vol> volsDuJour = new ArrayList<>();
        for (Vol vol : Vol.listeVolsPlanifies) {
            if (vol.dateHeureDepart.startsWith(dateHeureDepart)) {
                volsDuJour.add(vol);
            }
        }
        return volsDuJour;
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
        this.Origine[0] = origine;
        this.Destination[0] = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.Etat = etat;

        System.out.println("Le vol " + numeroVol + " a été modifié.");
    }

    public List<Passager> listePassagers = new ArrayList<>();
    public void listingPassager() {
        System.out.println("Liste des passagers pour le vol N°" + this.numeroVol + " :");
        for (Passager p : listePassagers) {
            System.out.println("Passager : " + p.getNom());
            System.out.println();
        }
    }
//    -----------------------------------------  GETTERS  ---------------------------------------------------------

    public int getNumeroVol() {         // Getters pour pouvoir utiliser les attributs dans main, etc.
        return this.numeroVol;
    }

    public String[] getOrigine() {
        return this.Origine;
    }

    public String[] getDestination() {
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

    public HashMap<String, ArrayList<String>> getEquipage() {
        return this.equipage;
    }
    public Avion getAvion() {
        return this.avion;
    }


    @Override
    public String toString() {
        return "INFORMATIONS SUR LE VOL N°" + this.numeroVol + " :\n"
                + "Origine:" + String.join(", ", this.Origine)
                + "\nDestination:" + String.join(", ", this.Destination)
                + "\nDateHeureDepart:" + this.dateHeureDepart
                + "\nDateHeureArrivee:" + this.dateHeureArrivee
                + "\nEtat:" + this.Etat
                + "\nPersonnel Cabine:" + this.personnelCab
                + "\nPilotes:" + this.pilotes;
    }

}