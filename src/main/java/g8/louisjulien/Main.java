package g8.louisjulien;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Vol vol1 = new Vol();
        Vol vol2 = new Vol();

        vol1.planifierVol("Paris", "Tokyo", "03/12/24 23:00", "04/12/24 11:00");
        vol2.planifierVol("Tokyo", "Paris", "10/12/24 10:00", "10/12/24 22:00");

        // Afficher les vols planifiés
        System.out.println("Vols planifiés:");
        for (Vol v : Vol.listeVolsPlanifies) {
            System.out.println("Vol ID : " + v.obtenirNumeroVol());
        }


    }
}