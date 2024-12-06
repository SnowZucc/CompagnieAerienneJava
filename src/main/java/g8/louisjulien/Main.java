package g8.louisjulien;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Création de 3 vols
        Vol vol1 = new Vol("Paris", "Tokyo", "01/01/2024 10h", "22h");
        Vol vol2 = new Vol("Tokyo", "Paris", "01/01/2024 00h", "12h");
        Vol vol3 = new Vol("Paris", "Berlin", "28/01/2024 16h", "20h");

        // Affectation des personnes et du personnel
        System.out.println("==== Classe personne =====");
        Personne frederic = new Personne( "Frédéric", "12 rue de Vanves, Issy", 0);
        frederic.obtenirInfos();

        System.out.println("==== Classe employé =====");
        System.out.println("Pilote");
        Pilote jeff = new Pilote(100, "Jeff", "1 Rue.", 0, 105, "01/01/1945", 452, 8000);
        String roleJeff = jeff.obtenirRole();
        System.out.println(roleJeff);
        jeff.affecterVol(vol1);
        System.out.println("Equipage du vol n°" + vol1.getNumeroVol() + " : " + vol1.equipage);
        jeff.obtenirVol(vol1.getNumeroVol());
        System.out.println();

        System.out.println("Personnel cabine");
        PersonnelCabine jose = new PersonnelCabine(420, "José", "6e cercle de l'Enfer",  466827959, 1000, "01/01/1945", "pas qualifié");
        System.out.println(jose.obtenirRole());
        jose.affecterVol(vol1);
        System.out.println("Equipage du vol n°" + vol1.getNumeroVol() + " : " + vol1.equipage);
        jose.obtenirVol(vol1.getNumeroVol());
        System.out.println();

        // Affectation aéroport [à faire]

        System.out.println("===== Classe vol =====");
        System.out.println("Affichage des vols planifiés");
        System.out.println("Il y a " + Vol.listeVolsPlanifies.size() + " vols planifiés.");
            for (int i = 0; i < Vol.listeVolsPlanifies.size(); i++) {
                Vol vol = Vol.listeVolsPlanifies.get(i);                        // Récupère le vol à l'index i
                System.out.println(vol);
                System.out.println();
            }

        Vol.annulerVol(1);

        System.out.println("Voir si vol 1 (vol2) a été annulé");
        System.out.println("État vol 1 : " + vol2.getEtat());
        System.out.println();

        vol2.modifierVol("Tunis", "Rome", "2024-12-01 02:00", "2024-12-01 16:00", "Modifié");
        // Voir si vol2 a été modifié
        System.out.println(vol2);
        System.out.println();

        System.out.println("Test planifierVol pour avoir un agenda des vols pour un jour donné");
        List<Vol> volsPourLaDate = Vol.planifierVol("01/01/2024");// Création liste des vols pour un jour avec planifierVol

        for (Vol vol : volsPourLaDate) {
            System.out.println("Vol N°" + vol.getNumeroVol() + " - Origine : " + vol.getOriginePasTableau() + " -> Destination : " + vol.getDestinationPasTableau());
        }
        System.out.println();

        System.out.println("===== Classe Passager =====");
        Passager passager1 = new Passager("Jean-Marc", "123 Rue du nhfruogerhngerhilfh", 123456789, 0, "2024-12-01", "ABCDEF");

        // Test de réservation
        System.out.println("Jean-Marc ajoute maintenant 2 réservations");
        passager1.reserverVol(vol1);
        passager1.reserverVol(vol2);
        passager1.obtenirReservations();

        // Afficher la liste des passagers
        System.out.println("Listing passagers");
        vol1.listingPassager();
        vol2.listingPassager();
        vol3.listingPassager();

        // Test de confirmation de réservation
        System.out.println("Test confirmation de la réservation N°1");
        Reservation reservation1 = Passager.listeReservations.get(1);
        reservation1.confirmerReservation(1);

        // Affichage des réservations après confirmation
        System.out.println("\nRéservations après confirmation de la réservation 1 (par Jean-Marc) :");
        passager1.obtenirReservations();

        System.out.println("Jean-Marc change d'avis et annule sa réservation 2 (il aura pas le temps d'y aller)");
        passager1.annulerReservation(2);
        passager1.obtenirReservations();

        System.out.println("Inversement de l'origine et de la destination :");
        Reservation res1 = Passager.listeReservations.get(1);
        res1.modifierReservation(1, "Confirmée", passager1, vol2);
        System.out.println("Réservation N°" + res1.numeroReservation + " - Statut : " + res1.getStatut() + " - Vol : " + res1.getVol().getOriginePasTableau() + " -> " + res1.getVol().getDestinationPasTableau());

        System.out.println("Revenus = " + Vol.getRevenus());
        System.out.println();
        Vol.plusPopulaires();
    }
}