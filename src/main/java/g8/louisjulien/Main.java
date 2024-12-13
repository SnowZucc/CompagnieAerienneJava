package g8.louisjulien;

public class Main {
    public static void main(String[] args) {
//         TestVolsManuels.Tester();
//         LectureFichier.main();

        TraiterDataset.importerVols("src/main/java/g8/louisjulien/flightsCoupe.csv");

        System.out.println("===== Classe Vol =====");
        System.out.println("Affichage des vols planifiés");
        System.out.println("Il y a " + Vol.listeVolsPlanifies.size() + " vols planifiés.");
        for (int i = 0; i < Vol.listeVolsPlanifies.size(); i++) {
            Vol vol = Vol.listeVolsPlanifies.get(i);                        // Crée vols
            System.out.println(vol);
            System.out.println();
        }


        TraiterDataset.importerPassagers("src/main/java/g8/louisjulien/Noms.txt");
        System.out.println("===== Classe Passager =====");
        System.out.println("Il y a " + TraiterDataset.passagers.size() + " passagers.");
        System.out.println("Affichage de leurs informations personnelles et de leurs vols réservés:");
        for (int i = 0; i < TraiterDataset.passagers.size(); i++) {
            Passager passager = TraiterDataset.passagers.get(i);
            System.out.println(passager);
            System.out.println("\nVOLS RESERVES :");
            passager.obtenirReservations();
            System.out.println();
        }
    }
}