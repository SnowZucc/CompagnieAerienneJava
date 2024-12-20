package g8.louisjulien;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

public class Vol {
    private final int numeroVol;
    private String[] Origine = new String[2];
    private String[] Destination = new String[2];
    private LocalDateTime dateHeureDepart;
    private LocalDateTime dateHeureArrivee;
    private String Etat; // 3 états: Planifié, Annulé, Modifié
    private ArrayList<String> pilotes = new ArrayList<>();
    private ArrayList<String> personnelCab = new ArrayList<>();

    public static int indexVol;    // Pour définir le numéro des prochains vols (static car partagé entre instances)
    public Avion avion;
    public static ArrayList<Vol> listeVolsPlanifies = new ArrayList<>(); // Liste de vols planifiés
    HashMap<String, ArrayList<String>> equipage =  new HashMap<>();
    public static double prixBillet = 250;
    public static double Revenus;

    public Vol(String Origine, String Destination, LocalDateTime dateHeureDepart, LocalDateTime dateHeureArrivee) {
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
    // C'EST BON J'AI FINI

    public static List<Vol> planifierVol(String dateHeureDepart) {
        System.out.println("=========== Vols pour le " + dateHeureDepart + " ===============");
        List<Vol> volsDuJour = new ArrayList<>();
        for (Vol vol : Vol.listeVolsPlanifies) {

            if (vol.dateHeureDepart.toString().startsWith(dateHeureDepart)) {
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

    public void modifierVol(String origine, String destination, LocalDateTime dateHeureDepart, LocalDateTime dateHeureArrivee, String etat) {
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

    public boolean chevauche(Vol autreVol) {
        // Conflit temporel : les deux plages se chevauchent
        boolean chevauchementTemporel = !(this.dateHeureArrivee.isBefore(autreVol.dateHeureDepart) ||
                this.dateHeureDepart.isAfter(autreVol.dateHeureArrivee));
        // Conflit de position : l'avion doit être à l'aéroport d'origine à temps
        boolean correspondanceAeroports = this.Destination[1].equals(autreVol.Origine[1]);

        return chevauchementTemporel && correspondanceAeroports;
    }

    public static void plusPopulaires() {
        Map<String, Integer> destinationCount = new HashMap<>();

        for (Vol vol : Vol.listeVolsPlanifies) {
            String destination = vol.getDestination()[0];       // Récupère la destination du vol
            int nbPassagers = vol.listePassagers.size();        // Compte le nombre de passagers sur ce vol
            destinationCount.put(destination, destinationCount.getOrDefault(destination, 0) + nbPassagers); // Ajouter au compteur
        }

        System.out.println("===== Destinations populaires =====");
        for (Map.Entry<String, Integer> entry : destinationCount.entrySet()) {
            System.out.println("Destination: " + entry.getKey() + " - Nombre de passagers: " + entry.getValue());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "INFORMATIONS SUR LE VOL N°" + this.numeroVol + " :"
                + "\nOrigine:" + String.join(", ", this.Origine)            // On dois utiliser join car nous avons le String dans un tableau
                + "\nDestination:" + String.join(", ", this.Destination)
                + "\nDateHeureDepart:" + this.dateHeureDepart
                + "\nDateHeureArrivee:" + this.dateHeureArrivee
                + "\nAvion:" + this.avion
                + "\nPersonnel Cabine:" + this.personnelCab
                + "\nPilotes:" + this.pilotes
                + "\nEtat:" + this.Etat;

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

    public String getOriginePasTableau() {
        return String.join(", ", this.Origine);         // Pas propre du tout mais sinon c'est un enfer
    }

    public String getDestinationPasTableau() {
        return String.join(", ", this.Destination);
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

    public static double getRevenus() {
        return Revenus;
    }
}