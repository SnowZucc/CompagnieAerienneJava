package g8.louisjulien;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vol vol1 = new Vol("Paris", "Tokyo", "01/01/2024 10h", "22h");
        Vol vol2 = new Vol("Tokyo", "Paris", "01/01/2024 00h", "12h");
        Vol vol3 = new Vol("Paris", "Berlin", "28/01/2024 16h", "20h");

        // Classe vol
//        vol1.planifierVol("Paris", "Tokyo", "03/12/24 23:00", "04/12/24 11:00");
//        vol2.planifierVol("Tokyo", "Paris", "10/12/24 10:00", "10/12/24 22:00");
//        vol3.planifierVol("Tokyo", "Paris", "10/12/24 10:00", "10/12/24 22:00");

        // Afficher les vols
            System.out.println("===== Classe vol =====");
            System.out.println("Affichage des vols planifiés");
        System.out.println("Taille de la liste des vols planifiés : " + Vol.listeVolsPlanifies.size());
            for (int i = 0; i < Vol.listeVolsPlanifies.size(); i++) {
                Vol vol = Vol.listeVolsPlanifies.get(i);                        // Récupère le vol à l'index i
                System.out.println("Numéro du vol: " + vol.getNumeroVol());
                System.out.println("Origine: " + vol.getOrigine());
                System.out.println("Destination: " + vol.getDestination());
                System.out.println("Date et Heure de départ: " + vol.getDateHeureDepart());
                System.out.println("Date et Heure d'arrivée: " + vol.getDateHeureArrivee());
                System.out.println("État: " + vol.getEtat());
                System.out.println();
            }

        System.out.println("=========== Vols pour le 01/01/2024 ===============");
        // Appel de la méthode planifierVol pour une date donnée
        List<Vol> volsPourLaDate = Vol.planifierVol("01/01/2024");
        // Impression des résultats
        System.out.println("Vols pour le 01/01/2024 :");
        for (Vol vol : volsPourLaDate) {
            System.out.println("Vol N°" + vol.getNumeroVol() + " - Origine : " + vol.getOrigine() + " -> Destination : " + vol.getDestination());
        }
        System.out.println("=========== Vols pour le 01/01/2024 ===============");
        System.out.println();

        Vol.annulerVol(1);

            // Voir si vol2 a été annulé
        System.out.println("Voir si le vol a été annulé");
        System.out.println("Numéro du vol: " + vol1.getNumeroVol());
        System.out.println("État: " + vol2.getEtat());
            System.out.println("Numéro du vol: " + vol2.getNumeroVol());
            System.out.println("État: " + vol2.getEtat());
        System.out.println("Numéro du vol: " + vol3.getNumeroVol());
        System.out.println("État: " + vol3.getEtat());
            System.out.println();

        vol1.modifierVol("Londres", "Rome", "2024-12-01 02:00", "2024-12-01 16:00", "Modifié");

        // Voir si vol2 a été modifié
        System.out.println("Voir si le vol a été modifié");
        System.out.println("Numéro du vol: " + vol1.getNumeroVol());
        System.out.println("Origine: " + vol1.getOrigine());
        System.out.println("Destination: " + vol1.getDestination());
        System.out.println("Date et Heure de départ: " + vol1.getDateHeureDepart());
        System.out.println("Date et Heure d'arrivée: " + vol1.getDateHeureArrivee());
        System.out.println("État: " + vol1.getEtat());
        System.out.println();

        Passager passager1 = new Passager(1, "Jean-Marc", "123 Rue du nhfruogerhngerhilfh", 123456789, 0, "2024-12-01", "ABCDEF");

        // Test de réservation
        System.out.println("===== Classe Passager =====");
        System.out.println("Ajout de réservations pour le passager...");
        passager1.reserverVol(vol1);
        passager1.reserverVol(vol2);

        // Affichage des réservations avant confirmation
        System.out.println("\nRéservations avant confirmation :");
        for (Integer id : Passager.listeReservations.keySet()) {
            Reservation res = Passager.listeReservations.get(id);
            System.out.println("Réservation N°" + res.numeroReservation + " - Statut : " + res.getStatut() + " - Vol : " + res.getVol().getOrigine() + " -> " + res.getVol().getDestination());
        }

        // Afficher la liste des passagers
        System.out.println("Listing passagers");
        vol1.listingPassager();
        vol2.listingPassager();
        vol3.listingPassager();

        // Test de confirmation de réservation
        System.out.println("\nConfirmation de la réservation N°1...");
        Reservation reservation1 = Passager.listeReservations.get(1);
        reservation1.confirmerReservation(1);

        // Affichage des réservations après confirmation
        System.out.println("\nRéservations après confirmation :");
        for (Integer id : Passager.listeReservations.keySet()) {
            Reservation res = Passager.listeReservations.get(id);
            System.out.println("Réservation N°" + res.numeroReservation + " - Statut : " + res.getStatut() + " - Vol : " + res.getVol().getOrigine() + " -> " + res.getVol().getDestination());
        }

        // Test d'annulation de réservation
        System.out.println("Annulation de la réservation N°2...");
        passager1.annulerReservation(2);

        // Affichage des réservations après annulation
        System.out.println("Réservations après annulation :");
        for (Integer id : Passager.listeReservations.keySet()) {
            Reservation res = Passager.listeReservations.get(id);
            System.out.println("Réservation N°" + res.numeroReservation + " - Statut : " + res.getStatut() + " - Vol : " + res.getVol().getOrigine() + " -> " + res.getVol().getDestination());
        }

        // Test modification d'une réservation
        Reservation res1 = Passager.listeReservations.get(1);
        res1.modifierReservation(1, "Confirmée", passager1, vol2);

        System.out.println("\nInversement de l'origine et de la destination :");
        res1 = Passager.listeReservations.get(1);
        System.out.println("Réservation N°" + res1.numeroReservation + " - Statut : " + res1.getStatut() + " - Vol : " + res1.getVol().getOrigine() + " -> " + res1.getVol().getDestination());

        System.out.println("==== Classe employé =====");
        Employe jeff = new Pilote(100, "Jeff", "1 Rue.", 0, 105, "01/01/1945", 452, 8000);
        String roleJeff = jeff.obtenirRole();
        System.out.println(roleJeff);
    }
}