package g8.louisjulien;

public class Main {
    public static void main(String[] args) {
        Vol vol1 = new Vol();
        Vol vol2 = new Vol();

        vol1.planifierVol("Paris", "Tokyo", "03/12/24 23:00", "04/12/24 11:00");
        vol2.planifierVol("Tokyo", "Paris", "10/12/24 10:00", "10/12/24 22:00");

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
        }
    }