package g8.louisjulien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class TraiterDataset {

    public static List<Vol> vols = new ArrayList<>();
    public static void importerVols(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");      // Diviser les lignes dans un tableau
                int id = Integer.parseInt(values[0]);          // Mettre les trucs dans des variables
                String origin = values[13];
                String destination = values[14];
                String numeroAvion = values[12];

                LocalDateTime depTime = gererDateTime(values[19], values[4]); // Combinaison de time_hour et dep_time
                LocalDateTime arrTime = gererDateTime(values[19], values[7]); // Combinaison de time_hour et arr_time

                Vol vol = new Vol(origin, destination, depTime, arrTime);
                vols.add(vol);

                // Passager fictif en attendant la vraie fonction
                Passager passager = new Passager("NomPassager", "Adresse" + id, 123456789,"Passeport" + id);
                passager.reserverVol(vol);
            }
            System.out.println("Vols importés avec succès : " + vols.size());
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    private static LocalDateTime gererDateTime(String timeHour, String time) {  // Fonction pour transformer les horaires en LocalDateTime
        String[] dateParts = timeHour.split(" ")[0].split("-");   // Divise la chaîne, espace comme délimiteur pour partie date (premier élément) puis divise cette date avec - comme délimiteur,
        // puis stocke composants individuels dans tableaudateParts.
        try {
            String cleanedTime = time.split("\\.")[0];               // Enlever la partie décimale si elle existe

            int hour = cleanedTime.length() >= 2 ? Integer.parseInt(cleanedTime.substring(0, cleanedTime.length() - 2)) : 0;    // Vérifie si la longueur de cleanedTime est au moins 2 caractères,
            // puis extrait la partie correspondant aux heures (avant les deux derniers caractères).
            // Si la longueur est inférieure à 2, initialise l'heure à 0.
            int minute = Integer.parseInt(cleanedTime.substring(cleanedTime.length() - 2));   // Extrait les deux derniers caractères de cleanedTime pour obtenir les minutes.

            return LocalDateTime.of(
                    Integer.parseInt(dateParts[0]), // Convertit les chaines du tableau en entier : Année
                    Integer.parseInt(dateParts[1]), // Mois
                    Integer.parseInt(dateParts[2]), // Jour
                    hour,                           // Heure
                    minute                          // Minute
            );
        } catch (NumberFormatException e) {
            System.err.println("Erreur lors de l'analyse de l'heure : " + time + ". Exception : " + e.getMessage());
            return null;
        }
    }

    public static List<Passager> passagers = new ArrayList<>();
    public static void importerPassagers(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String nom = reader.readLine();
            Random rand  = new Random();
            // On crée un passager par nom.
            while ((nom = reader.readLine()) != null) {
                String adresse = "";                            // Nous n'avons pas implémenté l'adresse
                // Génération d'un contact (numéro de téléphone) aléatoire entre 00.00.00.00.00 et 09.99.99.99.99
                int contact = rand.nextInt(999999999);
                // Génération d'un code de passeport composé de lettres majuscules aléatoires.
                String passeport = "";
                for (int i=0; i<7; i++) {
                    passeport = passeport + (char) ('A' + rand.nextInt(26));
                }
                // Nouvelle instance de passager.
                Passager passager = new Passager(nom, adresse, contact, passeport);
                passagers.add(passager);
                // Un passager peut réserver entre 1 et 4 vols.
                int nbVols = 1 + rand.nextInt(4);
                for (int i=0; i<nbVols; i++) {
                    // Chacun de ces vols est choisi au hasard dans la liste des vols remplie préremptivement.
                    Vol v = vols.get(rand.nextInt(vols.size()));
                    // On vérifie si le passager a déjà réservé ce vol.
                    boolean bool = true;
                    for (Passager p : v.listePassagers) {
                        if (p == passager) {
                            bool = false;
                            break;
                        }
                    }
                    // Un passager ne peut pas réserver un vol qu'il a déjà réservé.
                    if (bool) {
                        passager.reserverVol(v);
                    }
                }
            }
            System.out.println("Passagers importés avec succès!");
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }


}
