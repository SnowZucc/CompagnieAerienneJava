package g8.louisjulien;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Création de 3 vols
        Vol vol1 = new Vol("Paris", "Tokyo",
                LocalDateTime.of(2024, 1, 1, 10, 0),
                LocalDateTime.of(2024, 1, 1, 22, 0));
        Vol vol2 = new Vol("Tokyo", "Paris", LocalDateTime.of(2024, 1, 1, 0, 0),
                LocalDateTime.of(2024, 1, 1, 12, 0));
        Vol vol3 = new Vol("Paris", "Berlin", LocalDateTime.of(2024, 1, 28, 16, 0),
                LocalDateTime.of(2024, 1, 28, 20, 0));

        // Affectation des personnes et du personnel
        System.out.println("==== Classe personne =====");
        Personne frederic = new Personne( "Frédéric", "12 rue de Vanves, Issy", 0);
        frederic.obtenirInfos();
        System.out.println();

        System.out.println("==== Classe employé =====");
        System.out.println("Pilote");
        Pilote jeff = new Pilote(100, "Jeff", "1 Rue.", 0, 105, "01/01/1945", 452, 8000);
        String roleJeff = jeff.obtenirRole();
        System.out.println(roleJeff);

        System.out.println("Personnel cabine");
        PersonnelCabine jose = new PersonnelCabine(420, "José", "6e cercle de l'Enfer",  466827959, 1000, "01/01/1945", "pas qualifié");
        System.out.println(jose.obtenirRole());

        // Affectation des rôles
        jeff.affecterVol(vol1);
        System.out.println("Equipage du vol n°" + vol1.getNumeroVol() + " : " + vol1.equipage);
        jeff.obtenirVol(vol1.getNumeroVol());
        System.out.println();
        jeff.affecterVol(vol2);     // Bon j'ai la flemme donc Jeff pilotera tous les avions
        jeff.affecterVol(vol3);

        jose.affecterVol(vol1);
        System.out.println("Equipage du vol n°" + vol1.getNumeroVol() + " : " + vol1.equipage);
        jose.obtenirVol(vol1.getNumeroVol());
        System.out.println();
        jose.affecterVol(vol2);
        jose.affecterVol(vol3);

        // Affectation aéroport [à faire]

        System.out.println("===== Classe vol =====");
        System.out.println("Affichage des vols planifiés");
        System.out.println("Il y a " + Vol.listeVolsPlanifies.size() + " vols planifiés.");
            for (int i = 0; i < Vol.listeVolsPlanifies.size(); i++) {
                Vol vol = Vol.listeVolsPlanifies.get(i);                        // Récupère le vol à l'index i
                System.out.println(vol);
                System.out.println();
            }

         // Test annulation vol
        Vol.annulerVol(1);

        System.out.println("Voir si vol 1 (vol2) a été annulé");
        System.out.println("État vol 1 : " + vol2.getEtat());
        System.out.println();

        // Test modification vol
        vol2.modifierVol("Tunis", "Rome",
                LocalDateTime.of(2024, 12, 1, 2, 0),
                LocalDateTime.of(2024, 12, 1, 16, 0), "Modifié");
        // Voir si vol2 a été modifié
        System.out.println(vol2);
        System.out.println();

        System.out.println("Test planifierVol pour avoir un agenda des vols pour un jour donné");
        List<Vol> volsPourLaDate = Vol.planifierVol("2024-01-01");// Création liste des vols pour un jour avec planifierVol

        for (Vol vol : volsPourLaDate) {
            System.out.println("Vol N°" + vol.getNumeroVol() + " - Origine : " + vol.getOriginePasTableau() + " -> Destination : " + vol.getDestinationPasTableau());
        }
        System.out.println();

        System.out.println("===== Classe Passager =====");
        Passager passager1 = new Passager("Jean-Marc", "123 Rue du nhfruogerhngerhilfh", 123456789, 0, "2024-12-01", "ABCDEF");
        System.out.println("Passeport de Jean-Marc : " + passager1.getPasseport());
        System.out.println();

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
        System.out.println();

        // Test de confirmation de réservation
        System.out.println("Jean-Marc va maintenant confirmer sa réservation pour le vol N°0");
        Reservation reservation1 = Passager.listeReservations.get(1);
        reservation1.confirmerReservation(1);

        System.out.println("Réservations après confirmation de la réservation 1 (par Jean-Marc) :");
        passager1.obtenirReservations();

        System.out.println("Jean-Marc change d'avis et annule sa réservation 2 (il aura pas le temps d'y aller)");
        passager1.annulerReservation(2);
        passager1.obtenirReservations();

        System.out.println("Modification : inversement de l'origine et de la destination :");
        Reservation res1 = Passager.listeReservations.get(1);
        res1.modifierReservation(1, "Confirmée", passager1, vol2);
        System.out.println("Réservation N°" + res1.numeroReservation + " - Statut : " + res1.getStatut() + " - Vol : " + res1.getVol().getOriginePasTableau() + " -> " + res1.getVol().getDestinationPasTableau());
        System.out.println();

        System.out.println("Total des revenus grâce aux réservatins = " + Vol.getRevenus());
        System.out.println();
        Vol.plusPopulaires();
    }
}