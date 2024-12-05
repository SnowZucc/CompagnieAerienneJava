package g8.louisjulien;

public class Main {
    public static void main(String[] args) {
        Vol vol1 = new Vol();
        Vol vol2 = new Vol();
        Vol vol3 = new Vol();

        // Classe vol
        vol1.planifierVol("Paris", "Tokyo", "03/12/24 23:00", "04/12/24 11:00");
        vol2.planifierVol("Tokyo", "Paris", "10/12/24 10:00", "10/12/24 22:00");
        vol3.planifierVol("Tokyo", "Paris", "10/12/24 10:00", "10/12/24 22:00");

        // Afficher les vols planifiés
            for (int i = 0; i < Vol.listeVolsPlanifies.size(); i++) {
                Vol vol = Vol.listeVolsPlanifies.get(i);                        // Récupère le vol à l'index i
                System.out.println("Numéro du vol: " + vol.obtenirNumeroVol());
                System.out.println("Origine: " + vol.obtenirOrigine());
                System.out.println("Destination: " + vol.obtenirDestination());
                System.out.println("Date et Heure de départ: " + vol.obtenirDateHeureDepart());
                System.out.println("Date et Heure d'arrivée: " + vol.obtenirDateHeureArrivee());
                System.out.println("État: " + vol.obtenirEtat());
                System.out.println();
            }

        Vol.annulervol(1);

            // Voir si vol2 a été annulé
        System.out.println("Numéro du vol: " + vol1.obtenirNumeroVol());
        System.out.println("État: " + vol2.obtenirEtat());
            System.out.println("Numéro du vol: " + vol2.obtenirNumeroVol());
            System.out.println("État: " + vol2.obtenirEtat());
        System.out.println("Numéro du vol: " + vol3.obtenirNumeroVol());
        System.out.println("État: " + vol3.obtenirEtat());
            System.out.println();

        vol1.modifierVol("Paris", "Berlin", "2024-12-01 14:00", "2024-12-01 16:00", "Modifié");
        System.out.println("Vol 1 modifié");

        // Voir si vol2 a été modifié
        System.out.println("Numéro du vol: " + vol1.obtenirNumeroVol());
        System.out.println("Origine: " + vol1.obtenirOrigine());
        System.out.println("Destination: " + vol1.obtenirDestination());
        System.out.println("Date et Heure de départ: " + vol1.obtenirDateHeureDepart());
        System.out.println("Date et Heure d'arrivée: " + vol1.obtenirDateHeureArrivee());
        System.out.println("État: " + vol1.obtenirEtat());
        System.out.println();

        // Afficher la liste des passagers
        vol1.listingPassager();

        Passager passager1 = new Passager(1, "Jean-Marc", "123 Rue du nhfruogerhngerhilfh", 123456789, 0, "2024-12-01", "ABCDEF");

        // Test de réservation
        System.out.println("Ajout de réservations pour le passager...");
        passager1.reserverVol(vol1);
        passager1.reserverVol(vol2);

        // Affichage des réservations avant confirmation
        System.out.println("\nRéservations avant confirmation :");
        for (Integer id : Passager.listeReservations.keySet()) {
            Reservation res = Passager.listeReservations.get(id);
            System.out.println("Réservation N°" + res.numeroReservation + " - Statut : " + res.getStatut() + " - Vol : " + res.getVol().obtenirOrigine() + " -> " + res.getVol().obtenirDestination());
        }

        // Test de confirmation de réservation
        System.out.println("\nConfirmation de la réservation N°1...");
        Reservation reservation1 = Passager.listeReservations.get(1);
        reservation1.confirmerReservation(1);

        // Affichage des réservations après confirmation
        System.out.println("\nRéservations après confirmation :");
        for (Integer id : Passager.listeReservations.keySet()) {
            Reservation res = Passager.listeReservations.get(id);
            System.out.println("Réservation N°" + res.numeroReservation + " - Statut : " + res.getStatut() + " - Vol : " + res.getVol().obtenirOrigine() + " -> " + res.getVol().obtenirDestination());
        }

        // Test d'annulation de réservation
        System.out.println("\nAnnulation de la réservation N°2...");
        passager1.annulerReservation(2);

        // Affichage des réservations après annulation
        System.out.println("\nRéservations après annulation :");
        for (Integer id : Passager.listeReservations.keySet()) {
            Reservation res = Passager.listeReservations.get(id);
            System.out.println("Réservation N°" + res.numeroReservation + " - Statut : " + res.getStatut() + " - Vol : " + res.getVol().obtenirOrigine() + " -> " + res.getVol().obtenirDestination());
        }

        // Test modification d'une réservation
        System.out.println("\nAvant modification :");
        Reservation res1 = Passager.listeReservations.get(1);
        System.out.println("Réservation N°" + res1.numeroReservation + " - Statut : " + res1.getStatut() + " - Vol : " + res1.getVol().obtenirOrigine() + " -> " + res1.getVol().obtenirDestination());

        res1.modifierReservation(1, "Confirmée", passager1, vol2);

        System.out.println("\nInversement de l'origine et de la destination :");
        res1 = Passager.listeReservations.get(1);
        System.out.println("Réservation N°" + res1.numeroReservation + " - Statut : " + res1.getStatut() + " - Vol : " + res1.getVol().obtenirOrigine() + " -> " + res1.getVol().obtenirDestination());
    }
    }