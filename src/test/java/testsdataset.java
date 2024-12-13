import g8.louisjulien.Passager;
import g8.louisjulien.TraiterDataset;
import g8.louisjulien.Vol;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testsdataset {
    @BeforeAll                          //
    public static void setup() {
        TraiterDataset.importerVols("src/main/java/g8/louisjulien/flightsCoupe.csv");   // Méthode qui se lance avant les tests et qui initialise l'importation depuis le csv
        TraiterDataset.importerPassagers("src/main/java/g8/louisjulien/Noms.txt");
    }
    @Test
    public void testerImportationVols() {
        assertEquals(99, Vol.listeVolsPlanifies.size());        // Il doit y en avoir 100 - 1 qui est invalide
    }

    @Test
    public void testerOrigineDestination() {
        assertEquals(99, Vol.listeVolsPlanifies.size());

        Vol vol = Vol.listeVolsPlanifies.get(0);
        assertEquals("EWR, null", vol.getOriginePasTableau());      // Vérifier que l'origine et la destination sont bien importés depuis dataset.
        assertEquals("IAH, null", vol.getDestinationPasTableau());  // null car il n'y a pas les aéroports dans le dataset
    }

    @Test
    public void testListingPassagers() {        // Tester que chaque vol a entre 1 et 4200 passagers
        for (Vol vol : TraiterDataset.vols) {
            vol.listingPassager();

            assertNotNull(vol.listePassagers);
            assertTrue(vol.listePassagers.size() > 0);
            assertTrue(vol.listePassagers.size() < 4200);
        }
    }

    @Test
    public void testReservationsPassagers() {       // Vérifier que les passagers ont bien entre 1 et 4 réservations
        for (Passager passager : TraiterDataset.passagers) {
            passager.obtenirReservations();

            assertTrue(passager.listeReservations.size() > 0);
            assertTrue(passager.listeReservations.size() < 5);
            }
    }
}