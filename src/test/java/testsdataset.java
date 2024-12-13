import g8.louisjulien.TraiterDataset;
import g8.louisjulien.Vol;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testsdataset {

    @Test
    public void testerImportationVols() {
        TraiterDataset.importerVols("src/main/java/g8/louisjulien/flightsCoupe.csv");

        assertEquals(99, Vol.listeVolsPlanifies.size(), "Le nombre de vols importés devrait être 10.");
    }

    @Test
    public void testerOrigineDestination() {
        TraiterDataset.importerVols("src/main/java/g8/louisjulien/flightsCoupe.csv");

        // Vérifiez les détails d'un vol (par exemple, le premier vol)
        Vol vol = Vol.listeVolsPlanifies.get(0);
        assertEquals("EWR, null", vol.getOriginePasTableau());
        assertEquals("IAH, null", vol.getDestinationPasTableau());
    }

    @Test
    public void testerPassagers() {
        Vol vol = Vol.listeVolsPlanifies.get(0);
        // Vérifiez la création des passagers
        assertEquals(1, vol.listePassagers.size(), "Chaque vol devrait avoir un passager associé.");
        assertEquals("NomPassager0", vol.listePassagers.get(0).getNom(), "Le nom du passager ne correspond pas.");
    }
}
